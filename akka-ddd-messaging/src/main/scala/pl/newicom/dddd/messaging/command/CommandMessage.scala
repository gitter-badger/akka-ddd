package pl.newicom.dddd.messaging.command

import java.util.Date

import pl.newicom.dddd.aggregate.{Command, EntityId}
import pl.newicom.dddd.messaging.{EntityMessage, Message}
import pl.newicom.dddd.utils.UUIDSupport.uuid

case class CommandMessage(
    command: Command,
    id: String = uuid,
    timestamp: Date = new Date)
  extends Message with EntityMessage {

  type MessageImpl = CommandMessage

  override def entityId: EntityId = command.aggregateId

  override def payload: Any = command

  override def toString: String = {
    val msgClass = getClass.getSimpleName
    s"$msgClass(command = $command, id = $id, timestamp = $timestamp, metaData = $metadata)"
  }

}