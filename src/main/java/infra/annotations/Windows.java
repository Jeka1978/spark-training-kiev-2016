package infra.annotations;

import infra.WindowsDetector;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Evegeny on 07/04/2016.
 */
@Retention(RUNTIME)
@Conditional(WindowsDetector.class)
public @interface Windows {
    boolean value();
}
