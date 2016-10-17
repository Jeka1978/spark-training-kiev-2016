package football.infra.aop;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Evegeny on 25/05/2016.
 */
// this annotation will show dataframe not in production mode
@Retention(RUNTIME)
public @interface ShowDataFrameInTheBeginning {
}
