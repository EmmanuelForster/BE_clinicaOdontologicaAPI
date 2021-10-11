package edu.dh.API_clinicaOdontologica;

import edu.dh.API_clinicaOdontologica.model.Domicilio;
import edu.dh.API_clinicaOdontologica.model.Paciente;
import edu.dh.API_clinicaOdontologica.service.impl.PacienteService;
import edu.dh.API_clinicaOdontologica.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class PacienteIntegracionTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PacienteService pacienteService;

    @Test
    @WithMockUser(roles="ADMIN")
    public void cargarDataSet() throws Exception{
        Domicilio domicilio = new Domicilio("Lavalleja", 333, "CABA", "Buenos Aires");
        Paciente p = new Paciente("Forster", "Emmanuel", "mail@mail.com", 12345678, LocalDate.now());
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Jsons.asJsonString(p)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse((response.getResponse()).getContentAsString().isEmpty());
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void listarPacientes() throws Exception {
        this.cargarDataSet();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

}