package net.blackruffy

import akka.actor.{ Actor, ActorSystem }

class MyActor extends Actor {

  def receive = {
    case msg: String => sender ! msg
  }

}
