# 🧩 Strategy Pattern

## **Pattern Type:** Behavioral

---

## 🧭 The Origin – Adapting Behavior Without Changing the Core

You're building an e-commerce platform, and your pricing strategy depends on the **type of customer**:

- 🎯 **New customers** should be acquired at any cost — even if it means zero margin — just to let them experience your product and service.
- 🛒 **Returning customers** should be charged the regular price with healthy margins.

Rather than cluttering your code with `if-else` logic, you want a **flexible way to plug in different pricing strategies** at runtime.

That’s where the **Strategy Pattern** steps in.

---

## 🧩 The Problem It Solves

> ❓ How do you vary the behavior of a class without changing its code?

With Strategy Pattern:
- Define a family of interchangeable behaviors (strategies)
- Inject them into your business logic at runtime
- Avoid `if-else` or `when` logic sprinkled throughout the code

---

## 💡 Real-World Applications

1. **E-commerce Pricing**  
   Adjust price based on customer type: new, returning, VIP, bulk buyer.

2. **Billing Systems (Happy Hours)**  
   Apply discounts or offers during happy hours or festive periods.

3. **Game AI / Difficulty Settings**  
   Switch strategy dynamically based on level: Easy, Medium, Hard.

4. **User Moderation Systems**  
   If a user is flagged for spamming, switch their account to read-only mode.

---
