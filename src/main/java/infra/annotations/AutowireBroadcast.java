package infra.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Evegeny on 20/03/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutowireBroadcast {

    /**
     * @return type which should be injected with broadcast wrapper (can be spring bean or not)
     */
    Class value();
}
