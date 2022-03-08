package net.alphastar.microservicea.service;

import net.alphastar.microservicea.DAO.UsersDao;
import net.alphastar.microservicea.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Tester {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void testIt() {
        Users user = usersDao.findByUsername("rohan");
        String ep = bCryptPasswordEncoder.encode("password");
        System.out.println(user+" "+ep);
    }
}
