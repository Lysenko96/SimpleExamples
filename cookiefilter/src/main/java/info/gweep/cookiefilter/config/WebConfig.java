package info.gweep.cookiefilter.config;

import info.gweep.cookiefilter.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("info.gweep.cookiefilter")
public class WebConfig {

    @Bean
    public FilterRegistrationBean<LoginFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<LoginFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LoginFilter());
        filterFilterRegistrationBean.addUrlPatterns("/index");
        return filterFilterRegistrationBean;
    }
}
