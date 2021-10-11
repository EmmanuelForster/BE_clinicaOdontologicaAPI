package edu.dh.API_clinicaOdontologica.controller;


import edu.dh.API_clinicaOdontologica.model.DTO.OdontologoDTO;
import edu.dh.API_clinicaOdontologica.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Qualifier("OdontologoService")
    private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/create")
    public String registrarOdontologo(@RequestBody OdontologoDTO odontologo) {
        return odontologoService.create(odontologo);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable("id") Long id) {
        OdontologoDTO odontologo = odontologoService.read(id);
        return ResponseEntity.ok(odontologo);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Collection<OdontologoDTO> listarOdontologo() {
        return odontologoService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        return odontologoService.delete(id);
    }

    @PutMapping("/update")
    public String actualizar(@RequestBody OdontologoDTO odontologo) {
        return odontologoService.update(odontologo);
    }

    @GetMapping("/getByLastname")
    public Set<OdontologoDTO> listOdontologoLike(@RequestParam String lastname) {
        return odontologoService.getOdontologoByLastnameLike(lastname);
    }

}