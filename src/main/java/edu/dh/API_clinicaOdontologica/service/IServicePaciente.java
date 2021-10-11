package edu.dh.API_clinicaOdontologica.service;


import edu.dh.API_clinicaOdontologica.model.DTO.PacienteDTO;
import edu.dh.API_clinicaOdontologica.model.Paciente;

import java.util.Collection;

public interface IServicePaciente {

    String create(PacienteDTO paciente);

    PacienteDTO read(Long id);

    String update(PacienteDTO paciente);

    String delete(Long id);

    Collection<PacienteDTO> getAll();

}
