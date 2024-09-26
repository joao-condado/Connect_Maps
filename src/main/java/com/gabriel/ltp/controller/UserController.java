package com.gabriel.ltp.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UserController{

    @GetMapping("/user-JoaoBCamilo")
    public String getMethodName(){
        return "Fala galera, Monark aqui";

    }


}