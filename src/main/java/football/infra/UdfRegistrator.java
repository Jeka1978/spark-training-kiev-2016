package football.infra;

import football.services.CustomUdf;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Service
public class UdfRegistrator {

    @Autowired
    private List<CustomUdf> customUdfs;

    @Autowired
    private SQLContext sqlContext;

    @PostConstruct
    public void registerAllCustomUdf() {
        for (CustomUdf udf : customUdfs) {
            sqlContext.udf().register(udf.name(), udf, DataTypes.StringType);
        }
    }
}
