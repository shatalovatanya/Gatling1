package perf

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import perf.Actions._

object CommonScenario{
  def apply(): ScenarioBuilder = new CommonScenario().mainScenario
}

class CommonScenario {

  val open = group("open") {
    exec(webtours)
      .exec(welcomePl)
      .exec(navPl)
      .exec(navPlmenu)
      .exec(selectionPage)
      .exec(welcomePLsearch)
      .exec(navPlflights)
      .exec(reservationPl)
      .exec(welcomeItinerary)
      .exec(itinerary)
      .exec(itineraryMenu)
      .exec(exit)
      .exec(exitHome)

  }

  val login = group("open") {
    exec(loginPl)
      .exec(ticketSelection)
      .exec(flightSelection)
      .exec(ticket)
  }

  val mainScenario = scenario("mainScenario")
    .feed(Feeders.users)
    .feed(Feeders.cities)
    .feed(Feeders.arrive)
    .exec(open)
    .exec(login)
}

