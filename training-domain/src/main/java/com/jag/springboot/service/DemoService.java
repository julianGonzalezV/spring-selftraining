package com.jag.springboot.service;

import com.jag.springboot.entity.DemoEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class DemoService {
    public List<DemoEntity> getAll(){
        return Collections.singletonList(new DemoEntity("Demo1"));
    }
}
