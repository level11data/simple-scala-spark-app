package com.level11data.example.scala.simpleapp;


import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object SimpleApp {
  def main(args: Array[String]) {
    println("Arguments:")

    var i = 0
    for(a <- args) {
      i = i+1
      println(s"$i. $a")
    }

    val sc =  SparkContext.getOrCreate()
    val sqlContext = SQLContext.getOrCreate(sc)

    import sqlContext.implicits._

    for(t <- sqlContext.tables().collect()) {
      println(t)
    }

    val simpleData = Seq(("Group A","Section 1",50),("Group B","Section 2", 75), ("Group A", "Section 1", 25), ("Group C", "Section 2", 75))

    val simpleRdd = sc.parallelize(simpleData)

    val simpleDf = simpleRdd.toDF()

    simpleDf.show()
  }
}