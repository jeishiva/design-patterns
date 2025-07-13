package behavioural.template

abstract class AnalyticsProcessor {

    // Template method - defines the skeleton
    fun processEvent(event: String) {
        saveToKafka(event)
        val cleaned = cleanup(event)
        val enriched = enrich(cleaned)
        evaluate(enriched)
    }

    // Steps with common/default logic
    private fun saveToKafka(event: String) {
        println("Saved to Kafka: $event")
    }

    // Steps with variations
    protected abstract fun cleanup(event: String): String
    protected abstract fun enrich(event: String): String
    protected abstract fun evaluate(event: String)
}


class ImpressionProcessor : AnalyticsProcessor() {
    override fun cleanup(event: String): String {
        println("Cleaning impression event")
        return event.trim()
    }

    override fun enrich(event: String): String {
        println("Adding geo and device metadata")
        return "$event + enriched"
    }

    override fun evaluate(event: String) {
        println("Saving enriched impression to ClickHouse: $event\n")
    }
}


class CartEventProcessor : AnalyticsProcessor() {
    override fun cleanup(event: String): String {
        println("Cleaning cart event")
        return event.lowercase()
    }

    override fun enrich(event: String): String {
        println("Enriching with product metadata and user segment")
        return "$event + productData"
    }

    override fun evaluate(event: String) {
        println("🧠 Sending to ML model for scoring: $event\n")
    }
}

fun main() {
    val impressionProcessor = ImpressionProcessor()
    impressionProcessor.processEvent("HomePageBannerClick ")

    val cartProcessor = CartEventProcessor()
    cartProcessor.processEvent("ItemAddedToCart")
}
