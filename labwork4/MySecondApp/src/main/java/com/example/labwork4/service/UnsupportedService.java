package com.example.labwork4.service;

import com.example.labwork4.exception.UnsupportedCodeException;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedService {
    void checkCode(String code) throws UnsupportedCodeException;
}
