package structural.adapter

// Target interface
interface PaymentGatewayAdapter {
    fun process(request: PaymentRequest): PaymentResponse
}

// Simulated Stripe SDK
class StripeSDK {
    fun makePayment(cents: Int, currencyCode: String, user: String): Map<String, Any> {
        return mapOf(
            "id" to "txn_stripe_123",
            "status" to "succeeded",
            "raw" to "{...stripe response...}"
        )
    }
}

class StripeAdapter(private val stripeSDK: StripeSDK = StripeSDK()) : PaymentGatewayAdapter {
    override fun process(request: PaymentRequest): PaymentResponse {
        val cents = (request.amount * 100).toInt()
        val response = stripeSDK.makePayment(cents, request.currency, request.customerId)

        return PaymentResponse(
            transactionId = response["id"] as String,
            status = when (response["status"]) {
                "succeeded" -> PaymentStatus.Success
                "pending" -> PaymentStatus.Pending
                else -> PaymentStatus.Failure
            },
            rawPayload = response["raw"] as String
        )
    }
}


// Simulated Alipay SDK
class AlipayClient {
    fun pay(request: Map<String, Any>): String {
        return """{"orderId":"alipay_456","code":200,"message":"ok"}"""
    }
}

class AlipayAdapter(private val client: AlipayClient = AlipayClient()) : PaymentGatewayAdapter {
    override fun process(request: PaymentRequest): PaymentResponse {
        val payload = mapOf(
            "amountYuan" to request.amount,
            "currency" to request.currency,
            "userId" to request.customerId
        )

        val rawResponse = client.pay(payload)
        // Simulate parsing response
        val txnId = "alipay_456" // extracted from response
        val status = PaymentStatus.Success

        return PaymentResponse(
            transactionId = txnId,
            status = status,
            rawPayload = rawResponse
        )
    }
}
