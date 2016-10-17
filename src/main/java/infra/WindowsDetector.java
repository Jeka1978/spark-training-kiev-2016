package infra;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Iterator;

/**
 * Created by Evegeny on 07/04/2016.
 */
public class WindowsDetector implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        Iterator<Object> annotationAttributes = metadata.getAnnotationAttributes(Windows.class.getName()).values().iterator();
        boolean windowsRequested = (boolean) annotationAttributes.next();
        boolean windowsDetected = false;
        String os = System.getenv().get("OS");
        if (os != null && os.toLowerCase().contains("windows")) {
            windowsDetected = true;
        }
        return (windowsRequested && windowsDetected) || (!windowsRequested && !windowsDetected);
    }
}
