# 🧩 Composite Pattern

### **Pattern Type:** Structural

---

## 🧭 The Origin – One Nation, Many Taxpayers

In a nation's financial ecosystem, tax is collected from various types of contributors:

- 👤 **Individuals** (like salaried employees)
- 🏢 **Corporates** (like private companies)
- 📦 **Holding companies** that consist of multiple subsidiaries and individuals

Although their structure differs, the government wants to **treat all of them uniformly** during collection. It shouldn't matter whether it's a single person or a complex group — the system should simply say:  
➡️ `collectTax()`.

This is where the **Composite Pattern** fits perfectly.

---

## 🧩 The Problem It Solves

How can we **treat both individual objects and groups of objects uniformly**, especially when they're organized in tree-like structures?

The Composite Pattern allows:
- A **common interface** for all entities (individual or group)
- Recursive structures, where composites can contain other composites
- The **client (like the government)** to invoke a single method (`collectTax()`) without needing to know the internal structure

---

## 🛠️ Real-World Applications

1. **Taxation Systems**  
   Governments collecting taxes from nested organizational structures (individuals, corporates, and holding companies)

2. **UI Component Trees**  
   Buttons, panels, containers — each drawn using a single `draw()` function regardless of whether they contain children

3. **File System Navigation**  
   Treat files and folders uniformly via operations like `open()`, `getSize()`, `delete()`

4. **Organizational Hierarchies**  
   Handling salary payouts, performance tracking, or delegation across nested teams and departments

---

## ⚠️ When Not to Use

- When the structure is flat or fixed — no nesting of similar types
- When there's no need for uniform operations (e.g., each type behaves entirely differently)
---

## 💡 Key Concepts

| Role              | Kotlin Class          | Description                                 |
|-------------------|------------------------|---------------------------------------------|
| `Component`       | `TaxPayer` interface   | Defines the unified `collectTax()` contract |
| `Leaf`            | `Individual`, `Corporate` | Represents simple entities              |
| `Composite`       | `HoldingCompany`       | Represents grouped entities (can be nested) |
| `Client`          | `main()`               | Calls `collectTax()` on any level uniformly |

---

Let me know when you're ready to move to **Bridge** or **Decorator** next — we can keep the same storytelling momentum going! 🚀
