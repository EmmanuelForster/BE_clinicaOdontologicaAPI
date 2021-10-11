package edu.dh.API_clinicaOdontologica;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dh.API_clinicaOdontologica.model.DTO.OdontologoDTO;
import edu.dh.API_clinicaOdontologica.model.Odontologo;
import edu.dh.API_clinicaOdontologica.service.impl.OdontologoService;
import edu.dh.API_clinicaOdontologica.util.Jsons;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
import java.util.Collection;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class OdontologoIntegracionTest {
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;



    @Test
    @WithMockUser(roles="ADMIN")
    public void cargarDataSet() throws Exception{

        Odontologo o = new Odontologo("Forster", "Emmanuel", 12345678);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/odontologos/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Jsons.asJsonString(o)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse((response.getResponse()).getContentAsString().isEmpty());
    }

    @Test
    public void eliminarOdontologoTest() {
        odontologoService.delete(1L);
        Assert.assertNull(odontologoService.read(1L));

    }

    @Test
    public void traerTodos() {
        Odontologo o = new Odontologo("Forster", "Emmanuel", 12345678);
        odontologoService.create(mapper.convertValue(o, OdontologoDTO.class));
        Collection<OdontologoDTO> odontologos = odontologoService.getAll();
        Assert.assertTrue(odontologos.size() == 1);
        System.out.println(odontologos);
    }

}
