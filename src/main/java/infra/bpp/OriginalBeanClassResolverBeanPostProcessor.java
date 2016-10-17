package infra.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 08/05/2016.
 */
@Component
public class OriginalBeanClassResolverBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> beanName2OriginalBeanClass = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        beanName2OriginalBeanClass.put(beanName, bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Class getOriginalBeanClass(String beanName) {
        return beanName2OriginalBeanClass.get(beanName);
    }
}
