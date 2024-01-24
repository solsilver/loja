package com.br.nathan.Loja.service.exception;

public class ItemDuplicado extends RuntimeException{
    public ItemDuplicado(String msg){
        super(msg);
    }
}
