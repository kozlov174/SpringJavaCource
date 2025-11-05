package com.example.MyThirdApp.service;

import com.example.MyThirdApp.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify(Response response);

}