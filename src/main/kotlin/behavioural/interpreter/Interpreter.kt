package behavioural.interpreter

// Context: Carries information needed for interpreting signals
class BrainSignalContext(val signal: String)

// Abstract Expression
interface NeuralinkExpression {
    fun interpret(context: BrainSignalContext): String
}

// Terminal Expressions: Concrete expressions to handle specific signals
class MoveArmExpression : NeuralinkExpression {
    override fun interpret(context: BrainSignalContext): String {
        return if (context.signal.contains("ARM_SIGNAL")) {
            "Move Arm"
        } else {
            "No Action"
        }
    }
}

class SpeakExpression : NeuralinkExpression {
    override fun interpret(context: BrainSignalContext): String {
        return if (context.signal.contains("SPEECH_SIGNAL")) {
            "Speak Command"
        } else {
            "No Action"
        }
    }
}

class ScrollPhoneExpression : NeuralinkExpression {
    override fun interpret(context: BrainSignalContext): String {
        return if (context.signal.contains("SCROLL_SIGNAL")) {
            "Scroll Phone"
        } else {
            "No Action"
        }
    }
}

// Composite Expression: Combines multiple expressions
class CompositeNeuralinkInterpreter(
    private val expressions: List<NeuralinkExpression>
) : NeuralinkExpression {
    override fun interpret(context: BrainSignalContext): String {
        return expressions
            .map { it.interpret(context) }
            .filter { it != "No Action" }
            .joinToString(separator = " | ")
            .ifEmpty { "No valid signal interpreted" }
    }
}

// Client code
fun main() {
    val context = BrainSignalContext("ARM_SIGNAL + SPEECH_SIGNAL")

    val interpreter = CompositeNeuralinkInterpreter(
        listOf(MoveArmExpression(), SpeakExpression(), ScrollPhoneExpression())
    )

    val result = interpreter.interpret(context)
    println("Neuralink Output: $result")
}
