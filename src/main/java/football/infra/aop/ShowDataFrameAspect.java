package football.infra.aop;

import org.apache.spark.sql.DataFrame;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 25/05/2016.
 */
@Aspect
public class ShowDataFrameAspect {
    @Before("@annotation(football.infra.aop.ShowDataFrameInTheBeginning)")
    public void showDataFrameInTheBeginningOfMethod(JoinPoint jp){
        DataFrame dataFrame = (DataFrame) jp.getArgs()[0];
        System.out.println("ShowDataFrameInTheBeginning aspect is working...");
        printToConsole(jp, dataFrame);
        System.out.println("ShowDataFrameInTheBeginning aspect end of the print...");
    }

    @AfterReturning(value = "@annotation(football.infra.aop.ShowDataFrameInTheEnd)",returning = "dataFrame")
    public void showDataFrameInTheEndOfMethod(JoinPoint jp,DataFrame dataFrame){
        System.out.println("ShowDataFrameInTheEnd aspect is working...");
        printToConsole(jp, dataFrame);
        System.out.println("ShowDataFrameInTheEnd aspect is working...");
    }

    private void printToConsole(JoinPoint jp, DataFrame dataFrame) {
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();
        System.out.println("*********BEGIN*********  "+className+"  "+methodName+"  **********BEGIN***********");
        dataFrame.show();
        System.out.println("*********END*********  "+className+"  "+methodName+"  **********END***********");
    }
}
