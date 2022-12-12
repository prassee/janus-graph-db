name := "graph-db"

scalaVersion := "2.12.15"

version := "0.1"

libraryDependencies ++= Seq(
  "org.janusgraph" % "janusgraph-core" % "0.6.2",
  "org.janusgraph" % "janusgraph-cql" % "0.6.2",
  "org.janusgraph" % "janusgraph-es" % "0.6.2",
  "io.netty" % "netty-all" % "4.1.14.Final",
  "org.scalameta" %% "munit" % "0.7.29" % Test
)
