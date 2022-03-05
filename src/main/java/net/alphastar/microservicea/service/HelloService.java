package net.alphastar.microservicea.service;

import net.alphastar.microservicea.DTO.HelloObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HelloService {

    @GetMapping(path = "/hello")
    public HelloObject sayHello() {
        HelloObject helloObject = new HelloObject();
        helloObject.setData(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        helloObject.setNumber(1);
        return helloObject;
    }
}
