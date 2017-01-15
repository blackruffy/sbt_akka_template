package net.blackruffy

import akka.util.Timeout
import akka.pattern.ask
import akka.actor.{ActorSystem, Props}
import akka.event.{ Logging, LoggingAdapter }

import scala.util.{ Try }
import scala.concurrent.duration._
import scala.concurrent.{ Await }

object Main {
  def main(args: Array[String]) {
    implicit val system = ActorSystem("akka-template")
    implicit val executionContext = system.dispatcher
    val logger = system.log

    val myActor = system.actorOf(Props[MyActor], "my-actor")

    implicit val timeout = Timeout(60.seconds)

    logger.info(Await.result(myActor ? "Hello World", 60.seconds).toString)

    system.shutdown

  }
}
