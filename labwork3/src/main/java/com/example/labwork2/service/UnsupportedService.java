package com.example.labwork2.service;

import com.example.labwork2.exception.UnsupportedCodeException;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedService {
    void checkCode(String code) throws UnsupportedCodeException;
}
