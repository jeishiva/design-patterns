package behavioural.strategy

// Context: Strategy interface for pricing
interface PricingStrategy {
    fun calculatePrice(originalPrice: Double): Double
}

// Strategy for new customers - zero margin (acquisition focus)
class NewCustomerPricing : PricingStrategy {
    override fun calculatePrice(originalPrice: Double): Double {
        println("🎯 New customer detected. Selling at cost.")
        return originalPrice // 0% margin, possibly even discounted
    }
}

// Strategy for existing customers - sell at full price
class ReturningCustomerPricing : PricingStrategy {
    override fun calculatePrice(originalPrice: Double): Double {
        println("🛒 Returning customer. Selling at full price.")
        return originalPrice * 1.20 // Assuming 20% margin
    }
}


// Context: E-commerce engine that uses a pricing strategy
class ECommercePlatform(private var strategy: PricingStrategy) {

    fun setPricingStrategy(newStrategy: PricingStrategy) {
        strategy = newStrategy
    }

    fun checkout(originalPrice: Double): Double {
        return strategy.calculatePrice(originalPrice)
    }
}


fun main() {
    val originalPrice = 500.0

    val platform = ECommercePlatform(NewCustomerPricing())
    println("Final Price: ₹${platform.checkout(originalPrice)}\n")

    // Later user returns — update strategy
    platform.setPricingStrategy(ReturningCustomerPricing())
    println("Final Price: ₹${platform.checkout(originalPrice)}")
}
