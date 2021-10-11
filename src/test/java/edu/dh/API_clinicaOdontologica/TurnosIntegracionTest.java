package edu.dh.API_clinicaOdontologica;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dh.API_clinicaOdontologica.model.DTO.OdontologoDTO;
import edu.dh.API_clinicaOdontologica.model.DTO.PacienteDTO;
import edu.dh.API_clinicaOdontologica.model.DTO.TurnoDTO;
import edu.dh.API_clinicaOdontologica.model.Domicilio;
import edu.dh.API_clinicaOdontologica.model.Odontologo;
import edu.dh.API_clinicaOdontologica.model.Paciente;
import edu.dh.API_clinicaOdontologica.model.Turno;
import edu.dh.API_clinicaOdontologica.service.impl.OdontologoService;
import edu.dh.API_clinicaOdontologica.service.impl.PacienteService;
import edu.dh.API_clinicaOdontologica.service.impl.TurnoService;
import org.junit.Assert;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TurnosIntegracionTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(roles = "ADMIN")
    public void cargarDataSet() throws Exception {
        Domicilio domicilio = new Domicilio("Lavalleja", 333, "CABA", "Buenos Aires");
        Paciente p = new Paciente("Forster", "Emmanuel", "mail@mail.com", 12345678, LocalDate.now());
        pacienteService.create(mapper.convertValue(p, PacienteDTO.class));
        Odontologo o = new Odontologo("Balducci", "Camila", 3455647);
        this.odontologoService.create(mapper.convertValue(o, OdontologoDTO.class));

        Paciente pTurno = mapper.convertValue(pacienteService.read(1L), Paciente.class);
        Odontologo oTurno = mapper.convertValue(odontologoService.read(1L), Odontologo.class);
        String response = turnoService.create(mapper.convertValue(new Turno(pTurno, oTurno, LocalDate.now()), TurnoDTO.class));
        Assert.assertEquals(response, "Se creo un nuevo turno");
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void listarTurnos() throws Exception {
        this.cargarDataSet();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/turnos/getAll").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }
}
