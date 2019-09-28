package com.epam.dmrval.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
@ComponentScan("com.epam.dmrval")
public class AppWebConfiguration extends WebMvcConfigurationSupport {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  //  @Override
  //  public void addViewControllers(ViewControllerRegistry registry) {
  //    registry.addViewController("/").setViewName("forward:/login/");
  //    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
  //    super.addViewControllers(registry);
  //  }
}
