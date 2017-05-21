package fgh.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huxia on 2017/5/20.
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    //当服务不可用时，会调用hiError
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi," + name + ",sorry,system is error!";
    }
}
