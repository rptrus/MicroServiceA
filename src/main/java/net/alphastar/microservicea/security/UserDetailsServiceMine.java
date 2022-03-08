package net.alphastar.microservicea.security;

import net.alphastar.microservicea.DAO.UsersDao;
import net.alphastar.microservicea.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;

//@Component
public class UserDetailsServiceMine implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersDao.findByUsername("rohan");
        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        List<GrantedAuthority> authorities = Collections.singletonList(authority);
        //UserDetails userdeets = new User(user.getUsername(),  /*new BCryptPasswordEncoder().encode(*/user.getPassword()/*)*/,authorities);
        UserDetails userdeets = new User(user.getUsername(),  "$2a$10$deUsrZi0ZtpbBhwov0ODDOxbsgMGoRhv/c7f5yLEAr2cQ18itHG8q",authorities);
        System.out.println("UserDetails: "+user.getUsername());
        return userdeets;
    }
}
