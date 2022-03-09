package net.alphastar.microservicea.service;

import net.alphastar.microservicea.DTO.HelloObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class HelloService {

    @GetMapping(path = "/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public HelloObject sayHello() {
        HelloObject helloObject = new HelloObject();
        helloObject.setData(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        helloObject.setNumber(1);
        return helloObject;
    }

    @GetMapping(path = "/goodbye")
    public HelloObject sayGoodBye() {
        HelloObject helloObject = new HelloObject();
        helloObject.setData(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        helloObject.setNumber(2);
        return helloObject;
    }

}
