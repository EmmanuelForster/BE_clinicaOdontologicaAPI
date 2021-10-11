package edu.dh.API_clinicaOdontologica.service;


import edu.dh.API_clinicaOdontologica.exceptions.ResourceNotFoundException;
import edu.dh.API_clinicaOdontologica.model.DTO.TurnoDTO;

import java.util.Collection;

public interface IServiceTurno {

    String create(TurnoDTO turnoDTO) throws ResourceNotFoundException;

    TurnoDTO read(Long id) throws ResourceNotFoundException;

    String update(TurnoDTO turnoDTO) throws ResourceNotFoundException;

    void delete(Long id) throws ResourceNotFoundException;

    Collection<TurnoDTO> getAll() throws ResourceNotFoundException;

}
