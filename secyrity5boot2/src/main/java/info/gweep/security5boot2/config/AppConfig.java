package info.gweep.security5boot2.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{Config.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SecurityConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    @Override
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true);
//        return new Filter[]{new HiddenHttpMethodFilter(), encodingFilter};
//    }


    // for download file

//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        registration.setMultipartConfig(multipartConfigElement());
//    }
//
//    @Bean
//    public MultipartConfigElement multipartConfigElement(){
//        return new MultipartConfigElement(null, 5000000, 5000000, 0);
//    }
}
