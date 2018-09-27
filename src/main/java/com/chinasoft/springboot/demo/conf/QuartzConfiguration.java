package com.chinasoft.springboot.demo.conf;

import com.chinasoft.springboot.demo.job.FirstJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfiguration {
    @Bean(name="firstJobDetail")
    public MethodInvokingJobDetailFactoryBean firstJobdetail(FirstJob firstJob){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        jobDetail.setConcurrent(false);
        // 为需要执行的实体类对应的对象
        jobDetail.setTargetObject(firstJob);
        // 需要执行的方法
        jobDetail.setTargetMethod("saveUser");
        return jobDetail;
    }

    @Bean(name="firstTrigger")
    public SimpleTriggerFactoryBean firstTrigger(JobDetail firstJobDetail) {
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(firstJobDetail);
        // 设置任务启动延迟
        trigger.setStartDelay(0);
        // 每5秒执行一次
        trigger.setRepeatInterval(5000);
        return trigger;
    }

    // 配置Scheduler
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger firstTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 延时启动，应用启动1秒后
        bean.setStartupDelay(1);
        // 注册触发器
        bean.setTriggers(firstTrigger);
        return bean;
    }


}
