package com.github.sttraeger.sqsdemoserver.gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.scenario.Simulation

class LoadTest extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:8080")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader(1)

  val scn = scenario("DemoLoadTest").exec(http("getAllCars").get("/cars")).pause(25)
}