package com.example.MyThirdApp.service;

import com.example.MyThirdApp.exception.UnsupportedCodeException;
import org.springframework.stereotype.Service;

@Service
public interface UnsupportedService {
    void checkCode(String code) throws UnsupportedCodeException;
}
