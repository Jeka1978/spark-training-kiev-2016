package football.services;

import football.data.UserConfig;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.spark.sql.functions.*;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Service
public class TeamAppender implements DataAppender, CustomUdf {
    @Autowired
    private UserConfig userConfig;


    @Override
    public DataFrame appendColumns(DataFrame dataFrame) {
        dataFrame = dataFrame.withColumn("team1",callUDF(name(),col("from")));
        dataFrame = dataFrame.withColumn("team2",callUDF(name(),col("to")));
        return dataFrame;
    }

    @Override
    public String call(String player) throws Exception {
        return userConfig.players2Team.get(player);
    }

    @Override
    public String name() {
        return "findTeam";
    }
}
