package com.jag.springboot.controller;

import com.jag.springboot.entity.DemoEntity;
import com.jag.springboot.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {
    private final DemoService demoService;

    /**
     * After Spring 4.3 If your class has only single constructor then there is no need to put @Autowired.
     * @param demoService
     */
    public DemoRestController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    List<DemoEntity> getAll(){
        return demoService.getAll();
    }
}
