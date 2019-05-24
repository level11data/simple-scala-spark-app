package com.level11data.example.scala.simpleapp

import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]) {
    println("Arguments:")

    var i = 0
    for(a <- args) {
      i = i+1
      println(s"$i. $a")
    }

    val spark = SparkSession.builder().enableHiveSupport().getOrCreate()

    println("All Tables in MetaStore:")
    for(t <- spark.sqlContext.tables().collect()) {
      println(t)
    }

  }
}