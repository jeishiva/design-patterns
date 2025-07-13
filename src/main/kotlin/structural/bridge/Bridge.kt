package structural.bridge

// Implementor: Interface for LLM integrations
interface LLMIntegration {
    fun queryVisibility(productName: String): String
}

// Concrete Implementors
class ChatGPTIntegration : LLMIntegration {
    override fun queryVisibility(productName: String): String {
        return "ChatGPT: '$productName' mentioned 3 times in top queries"
    }
}

class GeminiIntegration : LLMIntegration {
    override fun queryVisibility(productName: String): String {
        return "Gemini: '$productName' mentioned in 2 recent answers"
    }
}

class ClaudeIntegration : LLMIntegration {
    override fun queryVisibility(productName: String): String {
        return "Claude: '$productName' visibility score is moderate"
    }
}

// Abstraction: SEO Tracker
abstract class SEOTracker(protected val llm: LLMIntegration) {
    abstract fun track(productName: String)
}

// Refined Abstraction: Track product visibility
class ProductVisibilityTracker(llm: LLMIntegration) : SEOTracker(llm) {
    override fun track(productName: String) {
        println("🔎 Tracking product visibility for '$productName'")
        val result = llm.queryVisibility(productName)
        println("📊 $result\n")
    }
}

// Refined Abstraction: Track brand mentions
class BrandMentionsTracker(llm: LLMIntegration) : SEOTracker(llm) {
    override fun track(productName: String) {
        println("🔍 Checking brand mentions for '$productName'")
        val result = llm.queryVisibility(productName)
        println("📢 $result\n")
    }
}
