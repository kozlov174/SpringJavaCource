package com.example.labwork2.service;

import com.example.labwork2.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);

}