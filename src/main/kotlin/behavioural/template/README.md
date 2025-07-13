# 🧩 Template Method Pattern

**Pattern Type:** Behavioral

---

## 🧭 The Origin – A Consistent Pipeline Across Diverse Events

You're building a high-throughput **online analytics engine** that processes millions of events like:

- Product impressions
- Cart additions
- Search queries
- Checkout events

Each event type may require **custom processing logic**, but the **core steps remain consistent**:

1. Save the raw event to persistent storage
2. Clean up and normalize the data
3. Enrich with metadata (geo, product info, etc.)
4. Evaluate it — store, score, or trigger alert

Hardcoding this logic in each component would violate DRY and introduce bugs during onboarding or extension.

This is where the **Template Method Pattern** excels — it enforces a fixed skeleton of steps while allowing subclasses to plug in their own logic where needed.

---

## 🧩 The Problem It Solves

> How do you enforce a processing workflow while still supporting variability across components?

The Template Method pattern allows you to:

- Define a **fixed processing pipeline**
- Let subclasses override individual steps
- Avoid code duplication and workflow drift
- Add new processors without touching the core flow

---

## 💡 Real-World Applications

1. **Analytics Pipelines**  
   Different event types can reuse the same processing flow with custom logic.

2. **ETL Systems**  
   Extract → Transform → Load, but each step differs based on source or destination.

3. **Marketing Campaigns**  
   Steps like validate → personalize → queue → send can vary by campaign type.

---

