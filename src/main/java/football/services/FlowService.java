package football.services;

import football.infra.aop.ShowDataFrameInTheEnd;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Service
public class FlowService {
    @Autowired
    private FootballDataframeCreator dataframeCreator;

    @Autowired
    private List<DataAppender> dataAppenders;

    @ShowDataFrameInTheEnd
    public void doWork(){
        DataFrame dataFrame = dataframeCreator.createDataFrame();
        for (DataAppender dataAppender : dataAppenders) {
            dataFrame = dataAppender.appendColumns(dataFrame);
        }
//        dataFrame.saveAsParquetFile();

    }
}
