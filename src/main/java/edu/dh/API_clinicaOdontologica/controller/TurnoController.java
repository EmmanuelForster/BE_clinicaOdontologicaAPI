package edu.dh.API_clinicaOdontologica.controller;

import edu.dh.API_clinicaOdontologica.model.DTO.TurnoDTO;
import edu.dh.API_clinicaOdontologica.service.impl.TurnoService;
import edu.dh.API_clinicaOdontologica.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;



@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Qualifier("TurnoService")
    TurnoService turnoService;

    public TurnoController (TurnoService turnoService){
        this.turnoService = turnoService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    ResponseEntity<TurnoDTO> read(@PathVariable("id") Long id) throws ResourceNotFoundException{
        TurnoDTO turno = turnoService.read(id);
        return ResponseEntity.ok(turno);
    }

    @PostMapping("/create")
    void create (@RequestBody TurnoDTO turnoDTO  ) throws ResourceNotFoundException{
    turnoService.create(turnoDTO);
    }

    @PutMapping("/update")
    void update(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException{
        turnoService.update(turnoDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") Long id) throws ResourceNotFoundException {
        turnoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("El turno fue eliminado");
    }

    @GetMapping("/getAll")
    @ResponseBody
    Collection<TurnoDTO> getAll () throws ResourceNotFoundException{
        return turnoService.getAll();
    }

}
