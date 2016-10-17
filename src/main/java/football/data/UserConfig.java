package football.data;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Component
public class UserConfig implements Serializable {

    public List<String> columnNames;
    public Map<String, String> players2Team = new HashMap<>();

    @Value("${columnNames}")
    private void setColumnNames(String[] columnNames) {
        this.columnNames = Arrays.asList(columnNames);
    }

    @PostConstruct
    @SneakyThrows
    private void initTeams(){
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("teams.properties"));
        for (Object key : properties.keySet()) {
            String line = (String) properties.get(key);
            String[] players = line.split(",");
            for (String player : players) {
                players2Team.put(player, (String) key);
            }
        }
    }
}









