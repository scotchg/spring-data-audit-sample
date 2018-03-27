package com.github.scotchg.sample.audit;

import com.github.scotchg.sample.audit.infra.repository.BaseRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
@Configuration
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }


    public static class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        public String getCurrentAuditor() {
            return "Mr. Auditor";
        }

    }
}
