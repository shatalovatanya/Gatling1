package perf

import io.gatling.core.Predef._

object Arrive {

  val arrive = csv("arrive.csv").random
}
