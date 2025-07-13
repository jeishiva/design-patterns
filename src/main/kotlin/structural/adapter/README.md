# 🔌 Adapter Pattern

### **Pattern Type:** Structural

---

## 🧭 The Origin – Bridging Global Payment Gateways

You’re building a platform that processes payments globally. To make this work, you integrate multiple payment gateways like:

- 💳 Stripe (U.S.)
- 🏦 Alipay (China)
- 💸 Razorpay (India)
- 🌐 Others coming soon...

But each gateway speaks its own language:
- Stripe expects cents and returns JSON with `"succeeded"` or `"failed"`
- Alipay uses Yuan and returns raw strings with status codes
- Others will follow their own formats...

You need a **consistent interface** for your system — regardless of how gateways work under the hood.  
This is exactly where the **Adapter Pattern** shines.

---

## 🧩 The Problem It Solves

> ❓ How do you integrate third-party systems with different input/output formats into your unified payment flow?

The **Adapter Pattern** lets you:

- Normalize request/response flows across APIs
- Isolate external SDK quirks
- Swap or add gateways with zero changes to core business logic

---

## 💡 Real-World Applications

1. **International Payment Systems**  
   Stripe, Alipay, PayPal, Razorpay all plug into one `PaymentGatewayAdapter` interface.

2. **Database/Storage Clients**  
   Expose a single `DataStore` interface while using Room, MongoDB, or Firebase behind the scenes.

3. **Logging Frameworks**  
   Unify logging behind a common adapter (Log4J, Timber, Firebase, etc.).

4. **File/Media Parsers**  
   Convert various image/audio file formats into a common rendering pipeline.

---

## 🔧 Example in Action

```kotlin
val request = PaymentRequest(
    amount = 49.99,
    currency = "USD",
    customerId = "user_abc",
    method = PaymentMethod.Card
)

val stripeResponse = StripeAdapter().process(request)
val alipayResponse = AlipayAdapter().process(request)
```
