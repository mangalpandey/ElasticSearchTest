import org.apache.spark.{SparkConf, SparkContext}
import org.elasticsearch.spark._

object Test{
  def main(args: Array[String]): Unit = {
  val conf = new SparkConf().setAppName("ElasticTest").setMaster("local")
    conf.set("es.index.auto.create", "true")
    var sc = new SparkContext(conf)
    val number = Map("one" -> 1, "two" -> 3, "three" -> 3)
    val airports = Map("arrival" -> "Otopeni", "SFO" -> "San Fran")

    sc.makeRDD(
      Seq(number, airports)
    ).saveToEs("spark/docs")
  }
}