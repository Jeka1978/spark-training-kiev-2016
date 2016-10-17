package infra.bpp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AutowireBroadcast {
    Class value();
}
