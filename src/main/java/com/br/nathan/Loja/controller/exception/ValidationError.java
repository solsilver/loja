package com.br.nathan.Loja.controller.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationError extends  StantardError{
    private List<FieldMessage> errors = new ArrayList<>();
    public ValidationError(Integer status, String msg, Long timestamp){
        super(status,msg,timestamp);
    }
    public  void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName,message));

    }
    public List<FieldMessage> getErrors(){
        return errors;
    }

}
