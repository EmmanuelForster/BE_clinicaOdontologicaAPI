package edu.dh.API_clinicaOdontologica.service;

import edu.dh.API_clinicaOdontologica.model.DTO.OdontologoDTO;
import edu.dh.API_clinicaOdontologica.model.Odontologo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;


@Service
public interface IServiceOdontologo {

        String create(OdontologoDTO odontologo);

        OdontologoDTO read(Long id);

        String update(OdontologoDTO odontologo);

        String delete(Long id);

        Collection<OdontologoDTO> getAll();

        Set<OdontologoDTO> getOdontologoByLastnameLike(String lastname);

    }


