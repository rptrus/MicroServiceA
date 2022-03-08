package net.alphastar.microservicea.service;

import net.alphastar.microservicea.DAO.UsersDao;
import net.alphastar.microservicea.DTO.HelloObject;
import net.alphastar.microservicea.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HelloService {

    @Autowired
    private UsersDao usersDao;

    @GetMapping(path = "/hello")
    //@PreAuthorize("hasRole('ADMIN')")
    public HelloObject sayHello() {

        for (Users user: usersDao.findAll()) {
            System.out.println(user.getUsername());
        }

        HelloObject helloObject = new HelloObject();
        helloObject.setData(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        helloObject.setNumber(1);
        return helloObject;
    }
}
