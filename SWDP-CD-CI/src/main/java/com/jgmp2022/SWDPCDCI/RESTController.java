package com.jgmp2022.SWDPCDCI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    @GetMapping
    String greeting() {
        return "Hello from '/' end point";
    }
}
