package com.msg.pigeon.validation;

import com.msg.pigeon.model.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ArgumentExceptionHandleAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public GenericResponse valid(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<String> errorMessages = allErrors.stream().map(ObjectError::getDefaultMessage).collect(toList());
        String message = StringUtils.join(errorMessages, ";");
        return GenericResponse.CLIENT_ERROR.setMessage(message);
    }

}