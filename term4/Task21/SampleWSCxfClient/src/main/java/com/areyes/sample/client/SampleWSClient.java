package com.areyes.sample.client;

import com.sample.service.SampleWebService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleWSClient {

	
	public SampleWSClient() {
		
		ClassPathXmlApplicationContext classPathXmlAppContext = new ClassPathXmlApplicationContext("classpath:META-INF/beans.xml");
		classPathXmlAppContext.start();
		
		SampleWebService sampleWebService = (SampleWebService)classPathXmlAppContext.getBean("client");
		
		System.out.println(sampleWebService.getDataFromWebService().getTitle());
		System.out.println(sampleWebService.getDataFromWebService().getDescription());
		System.out.println(sampleWebService.getDataFromWebService().getAuthor());
        System.out.println(sampleWebService.getDataFromWebService().getPublisher());
        System.out.println(sampleWebService.getDataFromWebService().getPublishedYear());
    }
	
	public static void main(String[] args){
		new SampleWSClient();
	}
}
