package infra.exceptions;

import org.springframework.beans.BeansException;

/**
 * Created by Evegeny on 08/05/2016.
 */
public class BeanNotFoundException extends BeansException {
    public BeanNotFoundException(String msg) {
        super(msg);
    }

    public BeanNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
