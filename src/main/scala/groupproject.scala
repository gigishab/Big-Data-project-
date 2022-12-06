
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.{SparkConf, SparkContext}



object groupproject extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

    val SparkConf = new SparkConf()
    SparkConf.set("spark.app.name", "groupproject2")
    SparkConf.set("spark.master", "local[*]")

    val spark = SparkSession.builder().config(SparkConf).getOrCreate()


    val orderdf = spark.read.option("header", true)
      .option("inferSchema", true)
      .csv("grptable.csv")


    //orderdf.show()


    orderdf.createOrReplaceTempView("tabledata")


    val res = spark.sql("select * from tabledata where age = 25")

    res.show()



}
