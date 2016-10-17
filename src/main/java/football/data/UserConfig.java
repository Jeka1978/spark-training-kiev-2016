package football.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Component
public class UserConfig implements Serializable {

    public List<String> columnNames;

    @Value("${columnNames}")
    private void setColumnNames(String[] columnNames) {
        this.columnNames = Arrays.asList(columnNames);
    }
}
