package net.alphastar.microservicea.security;

import net.alphastar.microservicea.DAO.UsersDao;
import net.alphastar.microservicea.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersDao.findByUsername(username);
        String[] role = user.getRoles().split(",");
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (role != null && role.length > 0) {
            for (String aRole: role) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + aRole.toUpperCase()));
            }
        }
        // see https://stackoverflow.com/questions/37615034/spring-security-spring-boot-how-to-set-roles-for-users
        //UserDetails userdeets = new User(user.getUsername(),  "$2a$10$deUsrZi0ZtpbBhwov0ODDOxbsgMGoRhv/c7f5yLEAr2cQ18itHG8q", authorities);
        UserDetails userdeets = new User(user.getUsername(),  new BCryptPasswordEncoder().encode(user.getPassword()), authorities);
        System.out.println("UserDetails: "+user.getUsername());
        return userdeets;
    }
}
