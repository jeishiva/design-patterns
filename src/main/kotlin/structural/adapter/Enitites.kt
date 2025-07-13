package structural.adapter

data class PaymentRequest(
    val amount: Double,
    val currency: String,
    val customerId: String,
    val method: PaymentMethod,
    val metadata: Map<String, String> = emptyMap()
)

data class PaymentResponse(
    val transactionId: String,
    val status: PaymentStatus,
    val rawPayload: String,
    val message: String? = null
)

// Sealed class to represent different payment methods
sealed class PaymentMethod {
    data object Card : PaymentMethod()
    data object UPI : PaymentMethod()
    data object BankTransfer : PaymentMethod()
    data object Wallet : PaymentMethod()
}

// Sealed class to represent normalized payment status
sealed class PaymentStatus {
    data object Success : PaymentStatus()
    data object Failure : PaymentStatus()
    data object Pending : PaymentStatus()
}
