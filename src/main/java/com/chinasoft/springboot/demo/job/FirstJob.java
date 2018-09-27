package com.chinasoft.springboot.demo.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@Component
public class FirstJob {
    public void saveUser(){
        System.out.println("=============the firstJon========="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }
}
