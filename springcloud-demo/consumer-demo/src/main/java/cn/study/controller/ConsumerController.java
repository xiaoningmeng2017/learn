package cn.study.controller;

import cn.study.client.UserClient;
import cn.study.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultFailback")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
////    private DiscoveryClient discoveryClient;

    @Autowired(required = false)
    private RibbonLoadBalancerClient ribbonLoadBalancerClient;

    @Autowired
    private UserClient userClient;

    @GetMapping("user/{id}")
    public User queryByUserId(@PathVariable("id") long id){
        User user = userClient.queryById(id);
        log.info("打印user："+user);
        return user;
    }

    @GetMapping("{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallback" )
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold" ,value="10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds" ,value="10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage" ,value="60")
    })
//    @HystrixCommand
    public String  queryById( @PathVariable("id") long id){
//        String url="http://localhost:8081/user/"+id;
//        //根据服务ID获取实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        //从服务中获取id和端口
//        ServiceInstance instance = instances.get(0);

//        ServiceInstance instance = ribbonLoadBalancerClient.choose("user-service");
//        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
        if(id%2 == 0){
           throw  new RuntimeException("");
        }
        String url ="http://user-service/user/"+id;
        log.info("打印url"+url);
        String  user=restTemplate.getForObject(url,String.class);
        log.info("日志打印"+user);
        return user;
    }

    public String  defaultFailback(){
        return "不好意思，服务器太拥挤了！~";
    }

    public String queryByIdFallback(long id){
        return "不好意思，服务器太拥挤了！~";
    }
}
