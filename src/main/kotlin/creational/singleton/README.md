# 🧩 Singleton Pattern

## **Pattern Type:** Creational

---

## 📖 Origin Story – Why This Pattern Was Born

Imagine you’re setting up an **analytics engine** in a mobile app. You only want one instance of it collecting events, managing queues, and dispatching data throughout the app’s lifetime. Creating multiple instances would mean duplicated data, race conditions, and chaos.

This need — to **create an object once and reuse it globally across the system** — gave birth to the **Singleton** pattern.

---

## 🎯 The Core Problem It Solves

How do you ensure that only **one instance of a class exists**, with **global access**, and **controlled lifecycle management**?

Singleton provides a clean solution when:
- You need **shared state or coordination** across the app
- The object is **costly to create or must persist** across system boundaries
- You want to enforce a **single point of control**

---

## 💡 Real-World Applications

1. **Analytics Engine Instance**  
   Ensures a single event collector is initialized and used app-wide.

2. **Application Object (Android / iOS)**  
   Provides a centralized context that lives throughout the app lifecycle.

3. **Configuration or Settings Manager**  
   Stores and provides access to global config like feature flags, themes, or environment info.

---

## 🚫 When Not to Use This Pattern

- **Avoid if global access isn’t essential.**  
  Singleton instances live for the entire application lifecycle. Using them for short-lived or modular logic can lead to **unnecessary memory retention** and **tight coupling**.

- **Makes unit testing harder.**  
  Singletons introduce hidden dependencies, making test setup and mocking difficult unless designed carefully (e.g., using interfaces or dependency injection).

---
