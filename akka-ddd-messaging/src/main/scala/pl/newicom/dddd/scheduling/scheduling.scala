package pl.newicom.dddd.scheduling

import akka.actor.ActorPath
import org.joda.time.DateTime
import pl.newicom.dddd.aggregate.{Command, DomainEvent}

  //
  // Commands
  //
  case class ScheduleEvent(businessUnit: String, target: ActorPath, deadline: DateTime, event: DomainEvent) extends Command {
    def aggregateId = businessUnit
  }

  // 
  // Events
  // 
  case class EventScheduled(businessUnit: String, target: ActorPath, deadline: DateTime, deadlineMillis: Long, event: DomainEvent)
