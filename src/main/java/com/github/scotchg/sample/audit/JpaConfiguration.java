package com.github.scotchg.sample.audit;

import com.github.scotchg.sample.audit.infra.repository.BaseRepositoryImpl;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
@Configuration
public class JpaConfiguration {

    @ConfigurationProperties(prefix = "system.jpa")
    @Component
    @Validated
    @Data
    public static class SystemJpaConfiguration {
        @NotNull private String auditor;
    }

    @RequiredArgsConstructor
    @Getter
    public static class AuditorAwareImpl implements AuditorAware<String> {
        private final String currentAuditor;
    }

    @Bean
    public AuditorAware<String> auditorProvider(SystemJpaConfiguration systemJpaConfiguration) {
        return new AuditorAwareImpl(systemJpaConfiguration.getAuditor());
    }
}
