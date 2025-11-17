package com.example.labwork5.service;

import com.example.labwork5.exception.UnsupportedCodeException;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedService {
    void checkCode(String code) throws UnsupportedCodeException;
}
