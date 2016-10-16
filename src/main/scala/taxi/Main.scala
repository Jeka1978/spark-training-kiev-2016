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
    println(rdd.count())

    /*  val count: Long = rdd.map(line => line.split(" ")).map(arr => (arr(1), arr(2).toInt))
        .filter(_._1.equalsIgnoreCase("boston"))
        .filter(_._2 > 10).count()
      println(count)*/

    rdd.map(_.toLowerCase()).map(line => line.split(" ")).map(arr => (arr(1), arr(2).toInt))
      .filter(_._1.equalsIgnoreCase("boston"))
      .reduceByKey(_ + _).collect().foreach(println)

    val tripsRdd: RDD[(String, Int)] = rdd.map(_.split(" ")).map(arr => (arr(0), arr(2).toInt))
      .reduceByKey(_ + _)

    val rdd1: RDD[String] = context.textFile("data/taxi/drivers.txt")
    val driversRdd: RDD[(String, String)] = rdd1.map(_.split(",")).map(arr => (arr(0), arr(1)))

    tripsRdd.join(driversRdd)
      .map(_._2)
      .sortByKey(ascending = false).take(3).foreach(println)
  }


}
