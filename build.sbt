name := "simple-scala-spark-app"

version := "0.0.1"

scalaVersion := "2.11.12" //DBR 5.3

sparkVersion := "2.4.0"

sparkComponents ++= Seq("sql")

fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
