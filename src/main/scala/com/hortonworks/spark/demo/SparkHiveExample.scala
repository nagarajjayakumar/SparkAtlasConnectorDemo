package com.hortonworks.spark.demo

import java.io.File

import org.apache.spark.sql.{SaveMode, SparkSession}

object SparkHiveExample {

  // $example on:spark_hive$
  case class Record(key: Int, value: String)

  // $example off:spark_hive$

  def main(args: Array[String]) {
    // When working with Hive, one must instantiate `SparkSession` with Hive support, including
    // connectivity to a persistent Hive metastore, support for Hive serdes, and Hive user-defined
    // functions. Users who do not have an existing Hive deployment can still enable Hive support.
    // When not configured by the hive-site.xml, the context automatically creates `metastore_db`
    // in the current directory and creates a directory configured by `spark.sql.warehouse.dir`,
    // which defaults to the directory `spark-warehouse` in the current directory that the spark
    // application is started.

    // $example on:spark_hive$
    // warehouseLocation points to the default location for managed databases and tables
    val warehouseLocation = new File("spark-warehouse").getAbsolutePath

    val spark = SparkSession
      .builder()
      .appName("Spark SQL Atlas Demo")
      .config("spark.sql.warehouse.dir", warehouseLocation)
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._
    import spark.sql

    val traindata_atlas_demo11 = Seq(
      ("Hortonworks is a big data software company based in Santa Clara, California."),
      ("Temporary views in Spark SQL are session-scoped and will disappear if the session that creates it terminates."),
      ("Datasets are similar to RDDs, however, instead of using Java serialization or Kryo they use a specialized Encoder.")
    ).toDF("text")


    sql("CREATE TABLE IF NOT EXISTS traindata_atlas_demo11 (text STRING) USING hive")
    traindata_atlas_demo11.write.mode(SaveMode.Overwrite).format("csv").save("/tmp/traindata_atlas_demo11.csv")

    sql("LOAD DATA INPATH '/tmp/traindata_atlas_demo11.csv' INTO TABLE traindata_atlas_demo11")
    sql("select * from traindata_atlas_demo11").show()

    val training = sql("select * from traindata_atlas_demo11")

    training.show()

    spark.stop()
    // $example off:spark_hive$
  }
}
