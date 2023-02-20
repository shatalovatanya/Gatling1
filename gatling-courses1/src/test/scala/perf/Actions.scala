package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Actions {

  //.................

  val webtours = http("/webtours/")
    .get("/webtours/")
    .check(status is 200)

  val welcomePl = http("/cgi-bin/welcome.pl")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOff","true")
    .check(status is 200)

  val navPl = http("/cgi-bin/nav.pl?in=home")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(status is 200)
    .check(regex("""name="userSession" value="(.+)"""").saveAs( "userSession"))

  val loginPl = http("/cgi-bin/login.pl")
    .post("/cgi-bin/login.pl")
    .formParam("userSession","${userSession}")
    .formParam("username","${login}")
    .formParam("password","${password}")
    .formParam("login.x","0")
    .formParam("login.y","0")
    .formParam("JSFormSubmit","off")
    .check(status is 200)

  val navPlmenu = http("/cgi-bin/nav.pl?page=menu&in=home")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "home")
    .check(status is 200)

  val selectionPage = http("/cgi-bin/login.pl?intro=true")
    .get("/cgi-bin/login.pl")
    .queryParam("intro", "true")
    .check(status is 200)

  val welcomePLsearch = http("/cgi-bin/welcome.pl?page=search")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "search")
    .check(status is 200)

  val navPlflights = http("/cgi-bin/nav.pl?page=menu&in=flights")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "flights")
    .check(status is 200)

  val reservationPl = http("/cgi-bin/reservations.pl?page=welcome")
    .get("/cgi-bin/reservations.pl")
    .queryParam("page", "welcome")
    .check(status is 200)
    .check(regex("""name="departDate" value="(\d{2}.\d{2}.\d{4})"""").saveAs("departDate"))
    .check(regex("""name="returnDate" value="(\d{2}.\d{2}.\d{4})"""").saveAs("returnDate"))

  val ticketSelection = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("advanceDiscount", "0")
    .formParam("depart", "${depart}")
    .formParam("departDate", "${departDate}")
    .formParam("arrive", "${arrive}")
    .formParam("returnDate", "${returnDate}")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "39")
    .formParam("findFlights.y", "7")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(status is 200)
    .check(regex("""name="outboundFlight" value="([0-9]{1,3};[0-9]{1,4};\d{2}.\d{2}.\d{4})"""").findAll.saveAs( "outboundFlight"))

  val flightSelection = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "${outboundFlight.random()}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("reserveFlights.x", "46")
    .formParam("reserveFlights.y", "14")
    .check(status is 200)


  val ticket = http("/cgi-bin/reservations.pl")
    .post("/cgi-bin/reservations.pl")
    .formParam("firstName", "Tanya")
    .formParam("lastName", "Isaykina")
    .formParam("address1", "12")
    .formParam("address2", "12")
    .formParam("pass1", "Tanya Isaykina")
    .formParam("creditCard", "")
    .formParam("expDate", "")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("outboundFlight", "${outboundFlight.random()}")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "44")
    .formParam("buyFlights.y", "1")
    .formParam(".cgifields", "saveCC")
    .check(status is 200)

  val welcomeItinerary = http("/cgi-bin/welcome.pl?page=itinerary")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "itinerary")
    .check(status is 200)

  val itineraryMenu = http("/cgi-bin/nav.pl?page=menu&in=itinerary")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "itinerary")
    .check(status is 200)

  val itinerary = http("/cgi-bin/itinerary.pl")
    .get("/cgi-bin/itinerary.pl")
    .check(status is 200)

  val exit = http("/cgi-bin/cgi-bin/welcome.pl?signOff=1")
    .get("/cgi-bin/welcome.pl")
    .queryParam("signOf", "1")
    .check(status is 200)

  val exitHome = http("/cgi-bin/nav.pl?in=home")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(status is 200)

}
