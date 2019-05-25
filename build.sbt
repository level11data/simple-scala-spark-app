name := "simple-scala-spark-app"

version := "0.0.1"

scalaVersion := "2.11.12" //DBR 5.3

sparkVersion := "2.4.0"

sparkComponents ++= Seq("sql")

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"

//do not include Scala in FAT JAR
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

//assembly requires different JAR name config than package
assemblyJarName in assembly := s"${name.value}_${scalaBinaryVersion.value}-${version.value}.jar"

fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
