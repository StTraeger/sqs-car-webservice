import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

class LoadTest extends Simulation {

  val httpProtocoll = http
    .baseURL("http://localhost:8080")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader(1)

  val scn = scenario("DemoLoadTest").repeat(100){exec(http("Cars").get("/cars"))}
  setUp(scn.inject(rampUsers(20) over(1)).protocols(httpProtocoll)))
}