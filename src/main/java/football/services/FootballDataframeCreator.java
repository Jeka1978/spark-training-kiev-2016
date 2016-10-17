package football.services;

import football.config.Config;
import football.data.UserConfig;
import football.infra.aop.ShowDataFrameInTheBeginning;
import football.infra.aop.ShowDataFrameInTheEnd;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Service
public class FootballDataframeCreator implements Serializable{
    @Autowired
    private transient SQLContext sqlContext;

    @Autowired
    private transient JavaSparkContext sc;

    @Autowired
    private BaseRowCreator baseRowCreator;

    @Autowired
    private UserConfig userConfig;

    @ShowDataFrameInTheEnd
    public DataFrame createDataFrame() {
        JavaRDD<String> rdd = sc.textFile("data/rawData.txt");
        rdd = rdd.filter(line->!line.isEmpty());
        JavaRDD<Row> rowRdd = rdd.map(baseRowCreator::createRowFromLine);
        List<String> columnNames = userConfig.columnNames;
        StructField[] fields = new StructField[columnNames.size()];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = DataTypes.createStructField(columnNames.get(i), DataTypes.StringType, true);
        }
        DataFrame dataFrame = sqlContext.createDataFrame(rowRdd, DataTypes.createStructType(fields));
        return dataFrame;

    }
}




