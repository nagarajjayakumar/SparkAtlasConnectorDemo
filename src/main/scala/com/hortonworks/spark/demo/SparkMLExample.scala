package com.hortonworks.spark.demo

import java.io.File

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.feature.{StopWordsRemover, Tokenizer}
import org.apache.spark.sql.SparkSession

object SparkMLExample {

  // $example on:spark_hive$
  case class Record(key: Int, value: String)

  // $example off:spark_hive$

  def main(args: Array[String]) {

    val warehouseLocation = new File("spark-warehouse").getAbsolutePath

    val spark = SparkSession
      .builder()
      .appName("Spark ML Atlas Demo")
      .enableHiveSupport()
      .getOrCreate()

    import spark.sql


    val training = sql("select * from traindata_atlas_demo11")

    training.show()

    // Configure an ML pipeline, which consists of three stages: tokenizer, remover.
    val tokenizer = new Tokenizer().setInputCol("text").setOutputCol("words")

    val remover = new StopWordsRemover().setInputCol("words").setOutputCol("filtered")

    val pipeline = new Pipeline().setStages(Array(tokenizer, remover))

    val model = pipeline.fit(training)

    val pipelineDir = "/tmp/pipeline_streaming_demo11"

    val modelDir = "/tmp/model_streaming_demo11"

    pipeline.write.overwrite().save(pipelineDir)

    model.write.overwrite().save(modelDir)

    training.show()
  }
}
