package com.example.labwork5.service;

import com.example.labwork5.exception.UnsupportedCodeException;
import org.springframework.stereotype.Service;

@Service
public class UnsupportedCodeService implements UnsupportedService {

    @Override
    public void checkCode(String code) throws UnsupportedCodeException {
        if (code.equals("123")){
            throw new UnsupportedCodeException("Код " + code + " не поддерживается!");
        }
    }
}
