package com.example.labwork2.controller;

import com.example.labwork2.exception.ValidationFailedException;
import com.example.labwork2.exception.UnsupportedCodeException;
import com.example.labwork2.model.*;
import com.example.labwork2.service.UnsupportedCodeService;
import com.example.labwork2.service.ValidationService;
import com.example.labwork2.service.ModifyResponseService;
import com.example.labwork2.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final UnsupportedCodeService unsupportedCodeService;
    private final ModifyResponseService modifySystemTimeService;
    private final ModifyResponseService modifyOperationUidService;

    @Autowired
    public MyController(ValidationService validationService,
                        UnsupportedCodeService unsupportedCodeService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifySystemTimeService,
                        @Qualifier("ModifyOperationUidResponseService") ModifyResponseService modifyOperationUidService) {
        this.validationService = validationService;
        this.unsupportedCodeService = unsupportedCodeService;
        this.modifySystemTimeService = modifySystemTimeService;
        this.modifyOperationUidService = modifyOperationUidService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {

        log.info("Получен запрос: uid={}, operationUid={}", request.getUid(), request.getOperationUid());

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessage.EMPTY)
                .build();

        log.info("Создан начальный response: code={}", response.getCode());

        try {
            log.info("Валидация запроса");
            validationService.isValid(bindingResult);
            log.info("Валидация успешно пройдена");

            log.info("Проверка кода: uid={}", request.getUid());
            unsupportedCodeService.checkCode(request.getUid());
            log.info("Проверка кода успешно пройдена");

        } catch (ValidationFailedException e) {
            log.error("Ошибка валидации: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessage.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            log.error("Обнаружен неподдерживаемый код: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessage.UNSUPPORTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Неизвестная ошибка: {}", e.getMessage());
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessage.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Модификация response
        log.info("Модификация systemTime");
        response = modifySystemTimeService.modify(response);

        log.info("Модификация operationUid");
        response = modifyOperationUidService.modify(response);

        log.info("Финальный response: code={}, operationUid={}, systemTime={}",
                response.getCode(), response.getOperationUid(), response.getSystemTime());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}