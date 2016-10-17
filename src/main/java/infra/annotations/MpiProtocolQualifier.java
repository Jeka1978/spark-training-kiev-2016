package infra.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Evegeny on 06/05/2016.
 */
@Retention(RUNTIME)
@Qualifier
public @interface MpiProtocolQualifier {
    MpiProtocolType[] value();
}
