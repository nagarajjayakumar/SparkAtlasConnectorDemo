package com.hortonworks.spark.demo

import java.io.File

import org.apache.spark.ml.PipelineModel
import org.apache.spark.sql.SparkSession

object SparkStructuredStreamingExample {

  // $example on:spark_hive$
  case class Record(key: Int, value: String)

  // $example off:spark_hive$

  def main(args: Array[String]) {

    val warehouseLocation = new File("spark-warehouse").getAbsolutePath

    val spark = SparkSession
      .builder()
      .appName("Spark Streaming Kafka Atlas Demo")
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._


    val kafkaServer = "hcegchdp1-h0.connected.hortonworks.com:6667"

    val sameModel = PipelineModel.load("/tmp/model_streaming_690")

    val df = spark.readStream.format("kafka").option("kafka.bootstrap.servers", kafkaServer).option("subscribe", "in_topic_demo1").option("kafka.security.protocol", "SASL_PLAINTEXT").option("kafka.sasl.kerberos.service.name", "kafka").load()

    val df2 = df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
      .as[(String, String)].toDF("id", "text")

    //sink streaming data to other kafaka
    val output = sameModel.transform(df2).toDF("key", "value", "words", "filtered").selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")

    output.writeStream.format("kafka").option("kafka.bootstrap.servers", kafkaServer).option("checkpointLocation", "/tmp/demo/kafkadddOutxx4").option("kafka.security.protocol", "SASL_PLAINTEXT").option("kafka.sasl.kerberos.service.name", "kafka").option("topic", "out_topic_demo6").start()

    spark.streams.awaitAnyTermination()


  }
}
