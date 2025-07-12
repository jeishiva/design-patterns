// TradingProxy.kt

// The core service interface
interface TradingService {
    fun placeOrder(stock: String, quantity: Int)
}

// The real implementation – sensitive core system
class TradingEngine : TradingService {
    override fun placeOrder(stock: String, quantity: Int) {
        println("✅ Order placed: $quantity shares of $stock")
    }
}

// Proxy that controls access to the TradingEngine
class TradingProxy(
    private val tradingEngine: TradingEngine,
    private val userSession: UserSession
) : TradingService {

    override fun placeOrder(stock: String, quantity: Int) {
        if (userSession.isAuthenticated) {
            println("🔐 Access granted by TradingProxy")
            tradingEngine.placeOrder(stock, quantity)
        } else {
            println("🚫 Access denied: User not authenticated")
        }
    }
}

// Mock user session
data class UserSession(val isAuthenticated: Boolean)

// Usage
fun main() {
    val realEngine = TradingEngine()

    val guestSession = UserSession(isAuthenticated = false)
    val guestProxy = TradingProxy(realEngine, guestSession)
    guestProxy.placeOrder("AAPL", 10)

    val authSession = UserSession(isAuthenticated = true)
    val authProxy = TradingProxy(realEngine, authSession)
    authProxy.placeOrder("TSLA", 5)
}
