package edu.dh.API_clinicaOdontologica.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dh.API_clinicaOdontologica.model.DTO.OdontologoDTO;
import edu.dh.API_clinicaOdontologica.model.DTO.PacienteDTO;
import edu.dh.API_clinicaOdontologica.model.Odontologo;
import edu.dh.API_clinicaOdontologica.model.Paciente;
import edu.dh.API_clinicaOdontologica.repository.IPacienteRepository;
import edu.dh.API_clinicaOdontologica.service.IServicePaciente;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.*;

@Service
public class PacienteService implements IServicePaciente {


    IPacienteRepository pacienteRepository;

    private ObjectMapper mapper;

    @Autowired
    public PacienteService(IPacienteRepository pacienteRepository, ObjectMapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public String create(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        if (paciente != null)
            pacienteRepository.save(paciente);
        return "Se creo un nuevo paciente";
    }

    @Override
    public PacienteDTO read(Long id) {

        Optional<Paciente> paciente= pacienteRepository.findById(id);

        return mapper.convertValue(paciente, PacienteDTO.class);

    }

    @Override
    public String update(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        if (pacienteRepository.findById(paciente.getId()).isPresent()){
            pacienteRepository.save(paciente);
            return "Se modifico el paciente con id : " + paciente.getId();
        }
        return "No se encontro el paciente";
    }

    @Override
    public String delete(Long id) {
        if (pacienteRepository.findById(id).isPresent())
            pacienteRepository.deleteById(id);
        return "Se elimino el paciente con id : " + id;
    }

    @Override
    public Collection<PacienteDTO> getAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();

        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente: pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }

        return pacientesDTO;
    }
}
