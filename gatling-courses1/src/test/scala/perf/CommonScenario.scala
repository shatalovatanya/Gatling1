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
  }
  val login = group("login"){
    exec(loginPl)
      .exec(navPlmenu)
      .exec(selectionPage)
      .exec(welcomePLsearch)
      .exec(navPlflights)
  }

  val choice = group("choice"){
    exec(reservationPl)
      .exec(ticketSelection)
      .exec(flightSelection)
      .exec(ticket)
  }
  val basket = group("basket"){
    exec(welcomeItinerary)
      .exec(itineraryMenu)
      .exec(itinerary)
  }
  val singOff = group("singOff"){
    exec(exit)
      .exec(exitHome)
  }

  val mainScenario = scenario("mainScenario")
    .feed(Feeders.users)
    .feed(Feeders.cities)
    .feed(Feeders.arrive)
    .exec(open)
    .exec(login)
    .exec(choice)
    .exec(basket)
    .exec(singOff)
}


