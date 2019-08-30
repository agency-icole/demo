package com.example.demo;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.statsd.StatsdConfig;
import io.micrometer.statsd.StatsdFlavor;
import io.micrometer.statsd.StatsdMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
@EnableWebMvc
public class DemoApplication {

    @Autowired
    MeterRegistry meterRegistry;

    @RequestMapping("/")
    @Timed
    public String index(){
        Timer timer = Timer.builder("demo_rest")
                .tag("special","test")
                .register(meterRegistry);
        timer.record(100, TimeUnit.MILLISECONDS);
        return "greet";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
