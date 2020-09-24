package com.boot.boot.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;


@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class test extends QuartzJobBean{


	//执行方法
	@Override
	protected void executeInternal(JobExecutionContext arg) throws JobExecutionException {

		System.err.println("定时任务---------");
	}
}
