package football.services;

import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.functions;
import org.springframework.stereotype.Component;

import static org.apache.spark.sql.functions.*;

/**
 * Created by Evegeny on 28/12/2016.
 */
@Component
public class HalfTimeDataAppender implements DataAppender, CustomUdf {
    @Override
    public DataFrame appendColumns(DataFrame dataFrame) {
        return dataFrame.withColumn("half time", callUDF(name(),col("eventTime")));
    }

    @Override
    public String name() {
        return "halfTime";
    }

    @Override
    public String call(String s) throws Exception {
        String[] split = s.split(":");
        if (Integer.parseInt(split[0]) > 45) {

            return "2";
        } else {
            return "1";
        }
    }
}
