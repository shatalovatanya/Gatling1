package perf

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import perf.Actions._

object CommonScenario{
  def apply(): ScenarioBuilder = new CommonScenario().mainScenario
}

class CommonScenario {

  val open = group( "open"){
    exec(webtours)
      .exec(welcomePl)
      .exec(navPl)
      .exec(navPllogin)
      .exec(reservationPl)
      .exec(exit)
  }
  val login = group("open") {
    exec(loginPl)
      .exec(reservationspl)
      .exec(reservations)
      .exec(ticket)

  }

  val mainScenario = scenario("mainScenario")
    .feed(Feeders.users)
    .feed(Depart.cities)
    .feed(Arrive.arrive)
    .exec(open)
    .exec(login)

}

