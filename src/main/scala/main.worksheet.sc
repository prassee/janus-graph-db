import org.janusgraph.core.JanusGraphFactory
import scala.io.Source
val g = JanusGraphFactory
  .build()
  .set("storage.backend", "cql")
  .set("storage.cql.keyspace", "janusgraph")
  .set("storage.cql.read-consistency-level", "ONE")
  .set("storage.hostname", "127.0.0.1")
  .open()
  .traversal()

g.V().has("name", "abc pvt ltd").count().next()
