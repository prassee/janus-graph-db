package kg

object KGMain {

  import scala.io.Source
  import org.janusgraph.core.JanusGraphFactory

  private val g = JanusGraphFactory
    .build()
    .set("storage.backend", "cql")
    .set("storage.cql.keyspace", "janusgraph")
    .set("storage.cql.read-consistency-level", "ONE")
    .set("storage.hostname", "127.0.0.1")
    .open()
    .traversal()

  def writeToGraph() = {
    Source
      .fromFile(this.getClass.getResource("/kg.csv").getPath())
      .getLines()
      .foreach(line => {
        val raw = line.split(",")
        val se = g.addV(raw(0)).property("name", raw(0)).next()
        val te = g.addV(raw(1)).property("name", raw(1)).next()
        se.addEdge(s"transacts=${raw(2)}", te)
          .property("amount", raw(2).toDouble)
        g.tx().commit()
      })
  }

  def count(name: String = "abc pvt ltd") = {
    g.V().has("name", name).count().next()
  }

  def main(args: Array[String]) = {
    println("janus graph")
  }
}
