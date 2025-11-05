package com.example.labwork4.service;

import com.example.labwork4.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface ModifyRequestService {

    void modify(Request request);
}
