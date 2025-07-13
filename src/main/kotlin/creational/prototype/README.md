# 🧩 Prototype Pattern

## **Pattern Type:** Creational

---

## 📖 Origin Story – Born from the Need for Immutability

In modern UI frameworks like **Jetpack Compose**, **SwiftUI**, or **React**, immutability is not just a guideline — it's the foundation.

Imagine you're building a screen design tool. A user configures a **UI card**:
- Title: “News”
- Style: Rounded, Grey
- Action: Subscribe

Now, they want to create a similar card with just the title changed to **“Tech”**, keeping everything else the same.

In an **immutable world**, you can’t mutate the original card — and you shouldn’t re-build it from scratch either.  
This is where the **Prototype Pattern** steps in: it enables **safe cloning** of complex objects with the option to **tweak specific values**, preserving the original.

---

## 🎯 The Core Problem It Solves

How do you create new objects based on existing ones **without mutating** the original or writing verbose constructors?

The Prototype Pattern allows:
- **Cloning** objects in a clean and safe way
- **Tweaking** only what’s needed, keeping the rest intact
- Supporting immutability-first design without unnecessary duplication

---

## 💡 Real World Applications

1. **UI Builders & Editors**  
   Duplicate pre-configured components (e.g., cards, buttons) immutably using `copy()`, then customize as needed.

2. **Game Object Cloning**  
   Copy an enemy, tower, or level layout with slight variations — like position or power level — without altering the original.

---

## 🍎 Cross-Platform Perspective

- In **Kotlin**, `data class.copy()` is a natural way to implement the Prototype Pattern.
- In **Swift (iOS)**, value types (`struct`) and `copy-on-write` behavior achieve the same effect — clone and mutate safely.

---

## 🚫 When Not to Use This Pattern

- Avoid if object construction is trivial or mutation is not a concern.
- Not ideal for **deep object graphs** unless deep copy is implemented carefully.

---
