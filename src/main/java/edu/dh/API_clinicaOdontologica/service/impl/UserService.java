//package edu.dh.API_clinicaOdontologica.service.impl;
//
//import edu.dh.API_clinicaOdontologica.model.User;
//import edu.dh.API_clinicaOdontologica.model.UserRole;
//import edu.dh.API_clinicaOdontologica.repository.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private IUserRepository userRepository;
//
//
//    public UserService(IUserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//
//        Optional<User> user = userRepository.findByEmail(name);
//
//        if (user != null) {
//            Set<GrantedAuthority> authorizations = new HashSet<>();
//
//            for (UserRole role : user.get().getRoles()) {
//                GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
//                authorizations.add(authority);
//            }
//
//            org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(user.get().getName(), user.get().getPassword(), true, true, true, true, authorizations);
//
//            return userDetail;
//        } else {
//            throw new UsernameNotFoundException("No se ha encontrado el usuario con ese email");
//        }
//    }
//
//}
