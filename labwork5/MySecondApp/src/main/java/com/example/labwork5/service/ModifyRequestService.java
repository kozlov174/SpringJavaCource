package com.example.labwork5.service;

import com.example.labwork5.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface ModifyRequestService {

    void modify(Request request);
}
