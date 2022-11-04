package com.jag.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {
    //private final DemoService demoService;

    /*public DemoRestController(DemoService demoService) {
        this.demoService = demoService;
    }*/

    @GetMapping
    List<DemoEntity> getAll(){
        return Collections.singletonList(new DemoEntity("Demo1"));
    }
}
