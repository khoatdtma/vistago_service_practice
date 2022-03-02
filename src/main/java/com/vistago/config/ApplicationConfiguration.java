package com.vistago.config;

import com.vistago.filters.AuditTrailInfoFilter;
import com.vistago.filters.AuthenticationFilter;
import com.vistago.filters.RequestResponseLoggingFilter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.vistago.repositories")
@EntityScan("com.vistago.entities")
public class ApplicationConfiguration {

    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestResponseLoggingFilter());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter(){
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticationFilter());
        registrationBean.addUrlPatterns("/rest/*");
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AuditTrailInfoFilter> auditTrailInfoFilter(){
        FilterRegistrationBean<AuditTrailInfoFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuditTrailInfoFilter());
        registrationBean.setOrder(3);
        return registrationBean;
    }

}
