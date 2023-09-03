package com.example.userapp.service;

import org.springframework.stereotype.Service;

@Service
public class PosOrderService implements OrderService{
    @Override
    public void saveOrder() {
        System.out.println("I am from pos order");
    }
}
