package infra.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Evegeny on 03/04/2016.
 *
 * Convension is to take path location from from dev/prod.properties add /fieldname/fieldname.avro
 */


@Retention(RUNTIME)
@Target(FIELD)
public @interface AvroLocationByConvention {
}
