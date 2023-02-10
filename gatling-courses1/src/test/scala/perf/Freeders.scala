package perf

import io.gatling.core.Predef._

object Feeders {

  val users = csv("users.csv").circular
  val cities = csv("cities.csv").random
  val arrive = csv("arrive.csv").random
}
