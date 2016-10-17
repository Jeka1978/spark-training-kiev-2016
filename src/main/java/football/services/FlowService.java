package football.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 17/10/2016.
 */
@Service
public class FlowService {
    @Autowired
    private FootballDataframeCreator dataframeCreator;

    public void doWork(){

    }
}
