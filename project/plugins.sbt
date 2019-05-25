logLevel := Level.Warn

resolvers += "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"

addSbtPlugin("org.spark-packages" % "sbt-spark-package" % "0.2.6")

//required to build a FAT / UBER JAR
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.9")