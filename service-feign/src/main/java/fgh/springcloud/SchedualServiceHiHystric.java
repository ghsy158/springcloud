package fgh.springcloud;

import org.springframework.stereotype.Component;

/**
 * Created by huxia on 2017/5/21.
 */
//断路器
@Component
public class SchedualServiceHiHystric implements  SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name +",system is down!";
    }
}
