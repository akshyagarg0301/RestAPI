package com.example.RestApi;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Service service;

    String url="http://127.0.0.1:8080/dailyhunt/info";

    @GetMapping("/callAPI")
    @HystrixCommand(fallbackMethod = "defaultMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100000")},
            threadPoolProperties = {@HystrixProperty(name="coreSize",value = "3"),
            @HystrixProperty(name="maximumSize",value="5"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize",value="true"),
                    @HystrixProperty(name="maxQueueSize",value="2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "2"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1")
            }

    )
    public String getData() {
     //   System.out.println("Running Thread "+Thread.currentThread().getName()+" Task from client side is "+ task_id);
        return service.consumeAPI(url);
    }

    public String defaultMethod()
    {

       // System.out.println("Fallback Running Thread"+Thread.currentThread().getName()+" Task from client side is "+task_id);
        return "Server is not working";
    }




}
