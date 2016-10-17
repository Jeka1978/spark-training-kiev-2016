package infra.exceptions;

import org.springframework.beans.BeansException;

/**
 * Created by Evegeny on 08/05/2016.
 */
public class MoreThanOneBeanFound extends BeansException {
    public MoreThanOneBeanFound(String msg) {
        super(msg);
    }

    public MoreThanOneBeanFound(String msg, Throwable cause) {
        super(msg, cause);
    }
}
