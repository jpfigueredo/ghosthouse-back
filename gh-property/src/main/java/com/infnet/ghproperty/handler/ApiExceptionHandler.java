package com.infnet.ghproperty.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<ApiError.Campo> campos = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            campos.add(new ApiError.Campo(nome, mensagem));
        }

        ApiError apiError = new ApiError();
        apiError.setStatus(status.value());
        apiError.setDataHora(new Date());
        apiError.setTitulo("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
        apiError.setCampos(campos);

        return handleExceptionInternal(ex, apiError, headers, status, request);

    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntityNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiError apiError = new ApiError();
        apiError.setStatus(status.value());
        apiError.setDataHora(new Date());
        apiError.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<Object> handleNegocio(RuntimeException ex, WebRequest request) {
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//
//        ApiError apiError = new ApiError();
//        apiError.setStatus(status.value());
//        apiError.setDataHora(new Date());
//        apiError.setTitulo(ex.getMessage());
//
//        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
//    }
}
