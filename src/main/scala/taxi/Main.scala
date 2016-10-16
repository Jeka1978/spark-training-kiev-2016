package taxi

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Evegeny on 16/10/2016.
  */
object Main {
  def main(args: Array[String]): Unit = {
    //https://codeload.github.com/srccodes/hadoop-common-2.2.0-bin/zip/master
    System.setProperty("hadoop.home.dir", "C:\\util\\hadoop-common-2.2.0-bin-master\\")
    val conf: SparkConf = new SparkConf().setAppName("taxi").setMaster("local")
    val context: SparkContext = new SparkContext(conf)
    val rdd: RDD[String] = context.textFile("data/taxi/trips.txt")
  }

}
