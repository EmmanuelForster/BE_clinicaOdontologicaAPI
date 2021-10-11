package edu.dh.API_clinicaOdontologica.repository;

import edu.dh.API_clinicaOdontologica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("FROM Odontologo o WHERE o.apellido LIKE %:lastname%")
    public Set<Odontologo> getOdontologoByLastnameLike(@Param("lastname") String apellido);

}