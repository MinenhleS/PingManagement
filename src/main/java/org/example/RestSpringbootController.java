package org.example;

import org.example.entity.Dodecrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Member;

@SpringBootApplication
@RestController
public class RestSpringbootController {

    public static void main(String[] args) {
        SpringApplication.run(RestSpringbootController.class, args);
    }


    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @GetMapping(value= "/callClientGetKey")
    private String getHello() {
        String uri = "http://wmbqaapp1.shoprite.co.za:7080/shoprite/aws_key_management/keys";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @PostMapping(value = "/decryptJSON")
    private String decryptJSON(@RequestBody String status) {
        String uri = "http://wmbqaapp1.shoprite.co.za:7080/shoprite/aws_security_token/gettempcredentials/json1";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri,status,String.class);
        return result;
    }

    @PostMapping(value = "/decryptXML")
    private String decryptXML(@RequestBody String status) {
        String uri = "http://wmbqaapp1.shoprite.co.za:7080/shoprite/aws_security_token/gettempcredentials";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri,status,String.class);
        return result;
    }

    @PostMapping(value = "/decryptKEY")
    private String decryptKEY(@RequestBody String status) {
        String uri = "http://wmbqaapp1.shoprite.co.za:7080/shoprite/aws/kms/encrypt";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri,status,String.class);
        return result;
    }

}
