package edu.dh.API_clinicaOdontologica.repository;

import edu.dh.API_clinicaOdontologica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository <Turno, Long> {
}
