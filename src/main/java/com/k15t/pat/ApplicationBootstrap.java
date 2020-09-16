package com.k15t.pat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootstrap.class, args);
    }


//    @Bean
//    public ServletRegistrationBean initJerseyServlet() {
//        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
//        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
//        return registration;
//    }
//
//    @Bean
//    public WebMvcConfigurerAdapter forwardToIndex() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("forward:/registration.html");
//            }
//        };
//    }

}
