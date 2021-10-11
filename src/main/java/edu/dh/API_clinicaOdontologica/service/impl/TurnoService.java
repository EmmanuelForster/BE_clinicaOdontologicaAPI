package edu.dh.API_clinicaOdontologica.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dh.API_clinicaOdontologica.exceptions.ResourceNotFoundException;
import edu.dh.API_clinicaOdontologica.model.DTO.TurnoDTO;
import edu.dh.API_clinicaOdontologica.model.Turno;
import edu.dh.API_clinicaOdontologica.repository.ITurnoRepository;
import edu.dh.API_clinicaOdontologica.service.IServiceTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class TurnoService implements IServiceTurno {


    ITurnoRepository turnoRepository;


    private ObjectMapper mapper;

    @Autowired
    public TurnoService(ITurnoRepository turnoRepository, ObjectMapper mapper) {
        this.turnoRepository = turnoRepository;
        this.mapper = mapper;
    }

    @Override
    public String create(TurnoDTO turnoDTO) throws ResourceNotFoundException {

        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        if (turno != null) {
            turnoRepository.save(turno);
            return "Se creo un nuevo turno";
        } else {
            throw new ResourceNotFoundException("No se pudo crear el turno");
        }
    }

    @Override
    public TurnoDTO read(Long id) throws ResourceNotFoundException {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;

        if (turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);

            return turnoDTO;
        } else {
            throw new ResourceNotFoundException("No se encontro el turno con id :" + id);
        }

    }

    @Override
    public String update(TurnoDTO turnoDTO) throws ResourceNotFoundException {

        Turno turno = mapper.convertValue(turnoDTO, Turno.class);

        if (turnoRepository.findById(turno.getId()).isPresent()) {
            turnoRepository.save(turno);
            return "Se modifico el turno con id : " + turno.getId();
        } else {
            throw new ResourceNotFoundException("No se ha podido modificar el turno");
        }
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        if (turnoRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("No existe el turno con el id : " + id);
        } else{
            turnoRepository.deleteById(id);
        }
    }

    @Override
    public Collection<TurnoDTO> getAll() throws ResourceNotFoundException {
        List<Turno> turnos = turnoRepository.findAll();

        if (turnos.size() != 0) {
            Set<TurnoDTO> turnosDTO = new HashSet<>();
            for (Turno turno : turnos) {
                turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
            }
            return turnosDTO;
        } else {
            throw new ResourceNotFoundException("No existen turnos");
        }
    }
}
