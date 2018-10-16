package com.forezp.servicezipkin;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ServiceZipkinApplication {
    private static final Logger log=Logger.getLogger(ServiceZipkinApplication.class.getName());
    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @RequestMapping("/hi")
    public String callHome(){
        log.log(Level.INFO,"call trace service-hi ");
        return restTemplate.getForObject("http://localhost:8989/miya",String.class);
    }
    @RequestMapping("/info")
    public String info(){
        log.log(Level.INFO,"calling trace service-hi ");
        return "i am service-hi";
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
