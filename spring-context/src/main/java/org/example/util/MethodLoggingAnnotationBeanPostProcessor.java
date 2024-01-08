package org.example.util;

import org.example.springcontext.annotation.MethodLogging;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Configuration;


public class MethodLoggingAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(MethodLogging.class)){
            Class<?> beanClazz = bean.getClass();
            return createLoggingProxy(beanClazz);
        }
        return bean;
    }

    private Object createLoggingProxy(Class<?> beanClazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanClazz);
        enhancer.setInterfaces(beanClazz.getInterfaces());

        MethodInterceptor interceptor = (Object obj, java.lang.reflect.Method method, Object[] args,
                                         MethodProxy proxy) -> {
            System.out.println("Calling method " + method.getName() + " of a class " + beanClazz.getSimpleName());
         return proxy.invokeSuper(obj, args);
        };
        enhancer.setCallback(interceptor);
        return beanClazz.cast(enhancer.create());
    }
}
