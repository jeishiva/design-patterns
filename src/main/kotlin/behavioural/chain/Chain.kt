package behavioural.chain

// Request data class
data class AppRequest(val type: String, val payload: String)

// Handler interface
interface SDKHandler {
    var next: SDKHandler?

    fun handle(request: AppRequest)

    fun pass(request: AppRequest) {
        next?.handle(request) ?: println("No handler could process request: ${request.type}")
    }
}

// Handler 1: Security
class SecurityCheckHandler : SDKHandler {
    override var next: SDKHandler? = null

    override fun handle(request: AppRequest) {
        if (request.type == "security") {
            println("✅ Security check passed: ${request.payload}")
        } else {
            pass(request)
        }
    }
}

// Handler 2: Analytics
class AnalyticsHandler : SDKHandler {
    override var next: SDKHandler? = null

    override fun handle(request: AppRequest) {
        if (request.type == "analytics") {
            println("📊 Analytics event uploaded: ${request.payload}")
        } else {
            pass(request)
        }
    }
}

// Handler 3: Crash Logging
class CrashLoggingHandler : SDKHandler {
    override var next: SDKHandler? = null

    override fun handle(request: AppRequest) {
        if (request.type == "crash") {
            println("🐞 Crash logged: ${request.payload}")
        } else {
            pass(request)
        }
    }
}

// Handler 4: Fallback (optional)
class FallbackHandler : SDKHandler {
    override var next: SDKHandler? = null

    override fun handle(request: AppRequest) {
        println("⚠️ Unrecognized request type: ${request.type}")
    }
}

// Client Code
fun main() {
    val security = SecurityCheckHandler()
    val analytics = AnalyticsHandler()
    val crashLogger = CrashLoggingHandler()
    val fallback = FallbackHandler()

    // Chain the handlers
    security.next = analytics
    analytics.next = crashLogger
    crashLogger.next = fallback

    // App sends requests
    val requests = listOf(
        AppRequest("security", "Token verified"),
        AppRequest("analytics", "User clicked Home button"),
        AppRequest("crash", "NullPointerException in LoginScreen"),
        AppRequest("other", "Some unknown event")
    )

    for (req in requests) {
        security.handle(req)
    }
}
