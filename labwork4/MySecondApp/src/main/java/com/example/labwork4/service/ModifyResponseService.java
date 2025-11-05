package com.example.labwork4.service;

import com.example.labwork4.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);

}