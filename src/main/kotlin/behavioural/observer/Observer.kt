package behavioural.observer

interface SurveillanceDrone {
    fun register(unit: ResponseUnit)
    fun unregister(unit: ResponseUnit)
    fun notifyUnits(encryptedMessage: String)
}


class BorderPatrolDrone : SurveillanceDrone {

    private val subscribers = mutableListOf<ResponseUnit>()

    override fun register(unit: ResponseUnit) {
        subscribers.add(unit)
    }

    override fun unregister(unit: ResponseUnit) {
        subscribers.remove(unit)
    }

    override fun notifyUnits(encryptedMessage: String) {
        subscribers.forEach { it.onThreatDetected(encryptedMessage) }
    }

    fun detectThreat(threat: String) {
        val encrypted = encrypt(threat)
        println("Drone detected a threat: $threat")
        notifyUnits(encrypted)
    }

    private fun encrypt(data: String): String {
        return data.reversed() + "_cipher"
    }
}

interface ResponseUnit {
    fun onThreatDetected(encryptedMessage: String)
}

class ArmyCommand : ResponseUnit {
    override fun onThreatDetected(encryptedMessage: String) {
        println("Army Command received alert: $encryptedMessage")
    }
}

class CyberIntel : ResponseUnit {
    override fun onThreatDetected(encryptedMessage: String) {
        println("Cyber Intelligence decoding threat: $encryptedMessage")
    }
}

class CommunicationCenter : ResponseUnit {
    override fun onThreatDetected(encryptedMessage: String) {
        println("Communication Center broadcasting emergency: $encryptedMessage")
    }
}



fun main() {
    val drone = BorderPatrolDrone()

    val army = ArmyCommand()
    val cyber = CyberIntel()
    val communicationCenter = CommunicationCenter()

    drone.register(army)
    drone.register(cyber)
    drone.register(communicationCenter)

    drone.detectThreat("Missile Launch Detected")
}
