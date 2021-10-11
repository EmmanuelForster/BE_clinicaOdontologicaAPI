package edu.dh.API_clinicaOdontologica.service.impl;

import edu.dh.API_clinicaOdontologica.model.User;
import edu.dh.API_clinicaOdontologica.model.UserRole;
import edu.dh.API_clinicaOdontologica.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Set<UserRole> superAdminRoles = new HashSet<>();
        Set<UserRole> commonUserRole = new HashSet<>();

        UserRole adminRole = new UserRole("ADMIN");
        UserRole userRole = new UserRole("USER");
        UserRole visitorRole = new UserRole("VISITOR");
        superAdminRoles.add(adminRole);
        superAdminRoles.add(userRole);

        commonUserRole.add(visitorRole);

        String adminEncodedPassword = passwordEncoder.encode("password");

        String userEncodedPassword = passwordEncoder.encode("password2");

        userRepository.save(new User("Emmanuel", "manuspec", "forstereg@gmail.com", adminEncodedPassword, superAdminRoles));

        userRepository.save(new User("Camila", "cami.bal", "cami.balg@gmail.com", userEncodedPassword, commonUserRole));
    }
}
