package com.adobe.gatlingpoc

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PocSimulation2 extends Simulation {

    val httpProtocol = http
//      .baseUrl("https://service-blueprint-va6.identity-dev.adobe.com/ping") // Here is the root for all relative URLs
      .baseUrl("https://computer-database.gatling.io") // Here is the root for all relative URLs
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(http("request_1")
      .get("/"))
    .pause(7) // Note that Gatling has recorder real time pauses
  val scn2 = scenario("Scenario Name2") // A scenario is a chain of requests and pauses
    .exec(http("request_2")
      .get("/"))
    .pause(7) // Note that Gatling has recorder real time pauses

    setUp(scn.inject(atOnceUsers(1)),
      scn2.inject(atOnceUsers(1)
      ).protocols(httpProtocol))
}
