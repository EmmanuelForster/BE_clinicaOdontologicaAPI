package edu.dh.API_clinicaOdontologica.controller;

import edu.dh.API_clinicaOdontologica.model.DTO.PacienteDTO;
import edu.dh.API_clinicaOdontologica.model.Paciente;
import edu.dh.API_clinicaOdontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    @Qualifier("PacienteService")
    private PacienteService pacienteService;


    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @PostMapping("/create")
    public String registrar(@RequestBody PacienteDTO paciente) {
        return pacienteService.create(paciente);
    }

    @GetMapping("/{id}")
    @ResponseBody
    ResponseEntity<PacienteDTO> buscar(@PathVariable("id") Long id){
        PacienteDTO paciente = pacienteService.read(id);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Collection<PacienteDTO> listarPaciente(){
        return pacienteService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String eliminar (@PathVariable Long id){
        return pacienteService.delete(id);
    }

    @PutMapping("/update")
    public String actualizar (@RequestBody PacienteDTO paciente){
        return pacienteService.update(paciente);
    }

}
