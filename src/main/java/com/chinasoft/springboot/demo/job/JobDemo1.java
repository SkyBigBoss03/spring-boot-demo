package com.chinasoft.springboot.demo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class JobDemo1 {
/*    0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
    0 0 12 * * ? 每天中午12点触发
   0 0/5 0 * * ? 每5分钟执行一次*/
    //每分钟执行一次
    @Scheduled(cron = "0 0/1 * * * ?")
    public void testJob(){
        System.out.println("now time:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }
}
