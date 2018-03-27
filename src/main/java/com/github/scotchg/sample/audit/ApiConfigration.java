package com.github.scotchg.sample.audit;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfigration {
    @Bean
    public Jdk8Module javaOptionalModule() {
       return new Jdk8Module();
    }
}
