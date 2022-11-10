package com.jag.springboot.service;

import com.jag.springboot.entity.DemoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DemoService {
    public List<DemoEntity> getAll() {
        return IntStream.range(0, 6).mapToObj(x -> new DemoEntity("Demo-".concat(String.valueOf(x)))).collect(Collectors.toList());
    }
}
