package infra.bpp;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Evegeny on 20/03/2016.
 */
@Component
public class AutowireBroadcasterAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private OriginalBeanClassResolverBeanPostProcessor originalBeanClassResolver;
    @Autowired
    private ApplicationContext context;

    static final Logger log = LoggerFactory.getLogger(AutowireBroadcasterAnnotationBeanPostProcessor.class);


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        List<Field> fields = ReflectionUtils.getAllFields(bean.getClass());
        fields.forEach(field -> {
            if (field.isAnnotationPresent(AutowireBroadcast.class)) {
                AutowireBroadcast annotation = field.getAnnotation(AutowireBroadcast.class);
                if (field.getType().equals(List.class)) {
                    injectList(bean, field, annotation);
                } else {

                    injectObject(bean, field, annotation);
                }
            }
        });
        return bean;
    }

    private void injectObject(Object bean, Field field, AutowireBroadcast annotation) {
        Object bean2Inject;

        Object bean1 = context.getBean(annotation.value());

        ReflectionUtils.setField(field, bean, sc.broadcast(bean1));
    }

    private void injectList(Object bean, Field field, AutowireBroadcast annotation) {

        List<Broadcast<?>> broadcasts = new ArrayList<>();
        Collection beans = context.getBeansOfType(annotation.value()).values();
        for (Object beanOfType : beans) {
            broadcasts.add(sc.broadcast(beanOfType));
        }
        ReflectionUtils.setField(field, bean, broadcasts);
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
