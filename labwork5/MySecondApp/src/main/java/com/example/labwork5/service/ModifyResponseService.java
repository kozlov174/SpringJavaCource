package com.example.labwork5.service;

import com.example.labwork5.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);

}