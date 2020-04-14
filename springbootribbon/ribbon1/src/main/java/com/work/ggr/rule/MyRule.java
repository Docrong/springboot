package com.work.ggr.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : gr
 * @date : 2020/3/19 21:44
 */
@Configuration
public class MyRule {

    @Bean
    public IRule MyRule(){
        return new RandomRule();
    }
}
