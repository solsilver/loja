package com.br.nathan.Loja.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StantardError {
    private Integer status;
    private String msg;
    private  Long timestamp;
}
