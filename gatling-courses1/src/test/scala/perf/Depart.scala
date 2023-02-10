package perf

import io.gatling.core.Predef._

object Depart {

  val cities = csv("cities.csv").random
}