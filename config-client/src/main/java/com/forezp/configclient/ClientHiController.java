package com.forezp.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientHiController {

    @Value("${foo}")
    String foo;
    @RequestMapping(value="/hi")
    public String hi(){
        return foo;
    }
}
