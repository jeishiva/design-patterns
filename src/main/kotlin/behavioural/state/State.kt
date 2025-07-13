// --- State Interface ---
interface SurgeryState {
    fun execute()
    fun next(): SurgeryState
    fun isFinal(): Boolean
}

// --- Concrete States ---
class ScanState : SurgeryState {
    override fun execute() {
        println("Scanning the target region for safe operation zones...")
    }

    override fun next(): SurgeryState = SterilizeState()

    override fun isFinal(): Boolean = false
}

class SterilizeState : SurgeryState {
    override fun execute() {
        println("Sterilizing the area to prevent infection...")
    }

    override fun next(): SurgeryState = IncisionState()

    override fun isFinal(): Boolean = false
}

class IncisionState : SurgeryState {
    override fun execute() {
        println("Performing precise incision...")
    }

    override fun next(): SurgeryState = OperateState()

    override fun isFinal(): Boolean = false
}

class OperateState : SurgeryState {
    override fun execute() {
        println("Repairing or removing the damaged tissue...")
    }

    override fun next(): SurgeryState = SutureState()

    override fun isFinal(): Boolean = false
}

class SutureState : SurgeryState {
    override fun execute() {
        println("🧵 Suturing the incision...")
    }

    override fun next(): SurgeryState = FinalizeState()

    override fun isFinal(): Boolean = false
}

class FinalizeState : SurgeryState {
    override fun execute() {
        println("Finalizing surgery and disengaging tools...")
    }

    override fun next(): SurgeryState {
        println("Surgery already completed.")
        return this
    }

    override fun isFinal(): Boolean = true
}

// --- Context ---
class SurgicalRobot {
    private var currentState: SurgeryState = ScanState()

    fun executeStep() {
        currentState.execute()
    }

    fun next() {
        if (!currentState.isFinal()) {
            currentState = currentState.next()
        } else {
            println("Cannot transition. Surgery is already completed.")
        }
    }

    fun isCompleted(): Boolean = currentState.isFinal()
}

// --- Usage ---
fun main() {
    val robot = SurgicalRobot()

    while (!robot.isCompleted()) {
        robot.executeStep()
        robot.next()
    }

    // Optional: Try calling again after surgery completed
    robot.executeStep()
    robot.next()
}
