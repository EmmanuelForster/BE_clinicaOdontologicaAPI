package edu.dh.API_clinicaOdontologica.repository;

import edu.dh.API_clinicaOdontologica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("from User u WHERE u.name = :name")
    Optional<User>findByName(@Param("name") String name);

    @Query("from User u WHERE u.email = :email")
    Optional<User> findByEmail(String email);
}
