package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SumService {
    public int sum(int a, int b) {
        return a + b;
    }
}
