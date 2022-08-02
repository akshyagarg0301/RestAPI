package com.example.RestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCircuitBreaker
public class RestApiApplication {

	public static void main(String[] args) throws InterruptedException {

		ConfigurableApplicationContext ctx=SpringApplication.run(RestApiApplication.class, args);
		//Controller controller = ctx.getBean(Controller.class);

//		int n=10;
//		ExecutorService executorService=Executors.newFixedThreadPool(n);
//		for(int i=0;i<n;i++)
//		{
//			int task_id=i+1;
//			executorService.submit(()->controller.getData(task_id));
//		}
//
//		executorService.shutdown();
//		executorService.awaitTermination(30, TimeUnit.SECONDS);
//
//		controller.getData(11);
//		TimeUnit.SECONDS.sleep(20);
//		System.out.println("after 20 seconds");
//		controller.getData(11);
	}

}
