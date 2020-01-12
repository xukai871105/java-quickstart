package com.example;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HelloJobMain {
    public static void main(String[] argv) throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity(HelloJob.helloJobKey)
                .build();

//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity(HelloJob.helloTriggerKey)
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ? "))
//                .build();

        // 启动过后，只运行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(HelloJob.helloTriggerKey)
                .startAt(DateBuilder.futureDate(20, DateBuilder.IntervalUnit.SECOND))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
