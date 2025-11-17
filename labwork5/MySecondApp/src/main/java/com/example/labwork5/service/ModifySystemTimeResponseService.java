package com.example.labwork5.service;

import com.example.labwork5.model.Response;
import com.example.labwork5.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("ModifySystemTimeResponseService")
@Slf4j
public class ModifySystemTimeResponseService implements ModifyResponseService {

    @Override
    public Response modify(Response response) {
        String oldTime = response.getSystemTime();
        response.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
        log.info("Modified system time from '{}' to '{}'", oldTime, response.getSystemTime());
        return response;
    }
}