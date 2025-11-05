package com.example.MyThirdApp.service;

import com.example.MyThirdApp.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("ModifyOperationUidResponseService")
public class ModifyOperationUidResponseService
        implements ModifyResponseService {

    private static final Logger log = LoggerFactory.getLogger(ModifyOperationUidResponseService.class);

    @Override
    public Response modify(Response response) {
        UUID uuid = UUID.randomUUID();
        response.setOperationUid(uuid.toString());
        log.info("Modify operation uid response: {}", response.getOperationUid());
        return response;
    }
}