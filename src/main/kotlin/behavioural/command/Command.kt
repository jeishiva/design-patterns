package behavioural.command

// Command Interface
interface CloudCommand {
    fun execute()
}

// Receivers
class CloudOperations {
    fun resizeImage(imageId: String) {
        println("Resizing image with ID: $imageId")
    }

    fun cleanLogs(service: String) {
        println("Cleaning logs for service: $service")
    }

    fun runAnalytics(jobName: String) {
        println("Running analytics job: $jobName")
    }
}

// Generic command wrapper with deferred logic
class LambdaCommand(private val action: () -> Unit) : CloudCommand {
    override fun execute() = action()
}

// Invoker
class CloudExecutor {
    private val commandQueue = mutableListOf<CloudCommand>()

    fun add(command: CloudCommand) {
        commandQueue.add(command)
    }

    fun executeAll() {
        println("Executing cloud tasks...")
        commandQueue.forEach { it.execute() }
        commandQueue.clear()
    }
}

// Client code
fun main() {
    val ops = CloudOperations()
    val executor = CloudExecutor()

    executor.add(LambdaCommand { ops.resizeImage("img_007") })
    executor.add(LambdaCommand { ops.cleanLogs("cancelled_tasks") })
    executor.add(LambdaCommand { ops.runAnalytics("task_execution") })

    executor.executeAll()
}
