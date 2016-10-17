package songs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Component
public class UserConfig {

    public List<String> garbage;

    @Value("${garbage}")
    private void setGarbage(String[] garbage) {
        this.garbage = Arrays.asList(garbage);
    }
}
