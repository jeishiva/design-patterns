// Message types in the spy network
sealed class Message {
    data class FromAgency(val content: String) : Message()
    data class FromSpy(val content: String, val isSuspicious: Boolean) : Message()
}

// Participant interface
interface Participant {
    val name: String
    fun receive(message: String)
}

// Mediator interface
interface CommunicationMediator {
    fun send(sender: Participant, message: Message)
}

// Concrete mediator
class SpyNetworkMediator : CommunicationMediator {

    private val spies = mutableListOf<Participant>()
    private var agency: Participant? = null
    private var validator: Participant? = null

    fun registerSpy(spy: Participant) {
        spies.add(spy)
    }

    fun registerAgency(agency: Participant) {
        this.agency = agency
    }

    fun registerValidator(validator: Participant) {
        this.validator = validator
    }

    override fun send(sender: Participant, message: Message) {
        when (message) {
            is Message.FromAgency -> {
                println("\n ${sender.name} (Agency) broadcasting message to all spies...")
                spies.forEach { it.receive("From Agency: ${message.content}") }
            }

            is Message.FromSpy -> {
                if (message.isSuspicious) {
                    println("\n${sender.name} (Spy) sent suspicious message. Routing to Validator.")
                    validator?.receive("Suspicious message from ${sender.name}: ${message.content}")
                } else {
                    println("\n🕵️ ${sender.name} (Spy) reporting to Agency...")
                    agency?.receive("From ${sender.name}: ${message.content}")
                }
            }

            else -> {
                println("Unknown message type: $message")
            }
        }
    }
}

// Concrete participants
class Spy(override val name: String) : Participant {
    override fun receive(message: String) {
        println("🕶️ Spy [$name] received: $message")
    }
}

class GovernmentAgency(override val name: String) : Participant {
    override fun receive(message: String) {
        println("🏛️ Agency [$name] received: $message")
    }
}

class ValidationUnit(override val name: String) : Participant {
    override fun receive(message: String) {
        println("🔍 Validator [$name] received: $message")
    }
}

// Client code
fun main() {
    val mediator = SpyNetworkMediator()

    val agency = GovernmentAgency("Central Intelligence")
    val validator = ValidationUnit("Suspicion Board")

    val spy1 = Spy("Spy Alpha")
    val spy2 = Spy("Spy Beta")

    mediator.registerAgency(agency)
    mediator.registerValidator(validator)
    mediator.registerSpy(spy1)
    mediator.registerSpy(spy2)

    // Agency sends broadcast
    mediator.send(agency, Message.FromAgency("Mission update. Stay low."))

    // Spy sends safe message
    mediator.send(spy1, Message.FromSpy("All clear in zone 5", isSuspicious = false))

    // Spy sends suspicious message
    mediator.send(spy2, Message.FromSpy("Requesting backup with unknown code", isSuspicious = true))
}
