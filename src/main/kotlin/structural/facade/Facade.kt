package structural.facade

/**
 * Activates the defense protocol:
 * 1. Alerts government stakeholders,
 * 2. Launches an interceptor missile,
 * 3. Notifies local police stations to evacuate red alert zones.
 *
 * Hides implementation details of threat response from the client.
 */
class DefenseFacade(
    private val missileLauncher: MissileLauncher,
    private val notifier: StakeholderNotifier,
    private val coordinator: EvacuationCoordinator
) {
    fun respondToThreat() {

        println("Ballistic threat detected. Activating defense protocol...\n")
        notifier.alertGovernment()
        missileLauncher.launchInterceptor()
        coordinator.notifyPoliceStations()
        println("\n✅ Response sequence completed.\n")
    }
}

// Subsystem 1: Missile Launcher
class MissileLauncher {
    fun launchInterceptor() {
        println("🚀 Interceptor missile launched to neutralize threat.")
    }
}

// Subsystem 2: Notifier
class StakeholderNotifier {
    fun alertGovernment() {
        println("📢 Government stakeholders alerted about incoming threat.")
    }
}


// Subsystem 3: Evacuation Coordinator
class EvacuationCoordinator {
    fun notifyPoliceStations() {
        println("🚓 Local police instructed to evacuate red alert zones.")
    }
}

// Client Code
fun main() {
    val missileLauncher = MissileLauncher()
    val notifier = StakeholderNotifier()
    val coordinator = EvacuationCoordinator()

    val defenseFacade = DefenseFacade(missileLauncher, notifier, coordinator)

    // Single call triggers entire complex workflow
    defenseFacade.respondToThreat()
}
