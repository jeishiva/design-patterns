package creational.singleton

// Interface defining the contract for analytics engines
interface AnalyticsEngine {
    fun trackEvent(eventName: String, properties: Map<String, Any>)
    fun flush()
}

// Example 1: Singleton using Kotlin's built-in 'object' declaration
// This is the most idiomatic way to create a singleton in Kotlin
object DefaultAnalyticsEngine : AnalyticsEngine {
    init {
        // Initialize analytics providers, config, or queues
        println("DefaultAnalyticsEngine initialized")
    }

    override fun trackEvent(eventName: String, properties: Map<String, Any>) {
        // Handle event tracking logic
        println("Tracking event: $eventName with properties: $properties")
    }

    override fun flush() {
        // Flush pending events to server
        println("Flushing analytics data...")
    }
}

// Example 2: Singleton using private constructor and companion object
// This is similar to how you'd implement a singleton in Java
class CustomAnalyticsEngine private constructor() : AnalyticsEngine {
    init {
        // Initialize analytics SDKs, event buffer, network client
        println("CustomAnalyticsEngine initialized")
    }

    override fun trackEvent(eventName: String, properties: Map<String, Any>) {
        // Track and buffer event
        println("[Custom] Tracking event: $eventName")
    }

    override fun flush() {
        // Send buffered events
        println("[Custom] Flushing analytics data...")
    }

    companion object {
        @Volatile
        private var instance: CustomAnalyticsEngine? = null

        // Thread-safe getInstance() method using double-checked locking pattern
        fun getInstance(): CustomAnalyticsEngine {
            return instance ?: synchronized(this) {
                instance ?: CustomAnalyticsEngine().also { instance = it }
            }
        }
    }
}
