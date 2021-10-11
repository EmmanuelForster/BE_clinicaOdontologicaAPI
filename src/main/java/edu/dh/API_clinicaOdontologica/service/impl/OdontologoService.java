package edu.dh.API_clinicaOdontologica.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dh.API_clinicaOdontologica.model.DTO.OdontologoDTO;
import edu.dh.API_clinicaOdontologica.model.Odontologo;
import edu.dh.API_clinicaOdontologica.repository.IOdontologoRepository;
import edu.dh.API_clinicaOdontologica.service.IServiceOdontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class OdontologoService implements IServiceOdontologo {


    private IOdontologoRepository odontologoRepository;

    private ObjectMapper mapper;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository, ObjectMapper mapper) {
        this.odontologoRepository = odontologoRepository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public String create(OdontologoDTO nuevoOdontologoDTO) {
        Odontologo nuevoOdontologo = mapper.convertValue(nuevoOdontologoDTO, Odontologo.class);
        if (nuevoOdontologo != null) {
            odontologoRepository.save(nuevoOdontologo);
            return "Se creo un nuevo odontologo";
        }
        return "Se creo un nuevo odontologo";
    }

    @Override
    public OdontologoDTO read(Long id) {

        Optional<Odontologo> odontologo= odontologoRepository.findById(id);

        return mapper.convertValue(odontologo, OdontologoDTO.class);

    }

    @Override
    public String update(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        if (odontologoRepository.findById(odontologo.getId()).isPresent()){
            odontologoRepository.save(odontologo);
            return "Se modifico el odontologo con id : " + odontologo.getId();
        }
        return "No se encontro el odontologo";     
    }

    @Override
    public String delete(Long id) {
    if (odontologoRepository.findById(id).isPresent())
        odontologoRepository.deleteById(id);
        return "Se elimino el odontologo con id : " + id;
    }

    @Override
    public Collection<OdontologoDTO> getAll() {
        List<Odontologo> odontologos = odontologoRepository.findAll();

        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo: odontologos ) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;

    }

    @Override
    public Set<OdontologoDTO> getOdontologoByLastnameLike(String lastname){
        Set<Odontologo> odontologos = odontologoRepository.getOdontologoByLastnameLike(lastname);

        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for(Odontologo odontologo : odontologos){
            odontologosDTO.add((mapper.convertValue(odontologo, OdontologoDTO.class)));
        }
        return odontologosDTO;
    }
}
