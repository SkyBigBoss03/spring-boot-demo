package com.chinasoft.springboot.demo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class JobDemo1 {
    @Scheduled(cron = "0 0/1 * * * ?")
    public void testJob(){
        System.out.println("now time:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }
}
