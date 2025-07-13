# 🔁 Iterator Pattern

## 🧩 Pattern Type
Behavioral

---

## 📖 The Origin Story

Imagine being stranded in a foreign country where you don’t speak the local language. You’re hungry, but the restaurants don’t understand your words. So, you use a **hand gesture mimicking eating** — a **universal way to communicate**.

Similarly, in software, we deal with a variety of collections: `List`, `LinkedList`, `Queue`, `Heap`, `Tree`, etc. Each has its own internal structure and way of accessing elements. The **Iterator Pattern** acts like a **universal gesture** — a common interface that allows you to traverse any collection **without needing to know how it works internally**.

---

## ✅ What Problem Does It Solve?

Without the Iterator pattern, each collection would need to expose its internal structure or require custom traversal code — leading to tight coupling and duplication.

The Iterator pattern:
- **Decouples traversal from data structure**
- Provides a **consistent interface** to iterate over diverse collections
- Enables **multiple iterators** over the same structure without interference

---

## 💡 Top Use Cases

1. Iterating through custom data structures (e.g. tree, graph, doubly linked list)
2. UI Components iterating through child views
3. File systems traversal (directories/files)
4. Database cursor or pagination systems
5. Paging APIs in mobile apps (Jetpack Paging, iOS Combine)

---

## 🍜 Real-World Analogy: Eating Gesture

- You're in a foreign land
- Each restaurant speaks a different language
- But everyone understands the "hand-to-mouth" eating gesture
- The **gesture** = **iterator**
- The **restaurants** = **data structures**
- You don't need to know their internal "menu"; you just ask using the gesture and get food (elements)

This gives you a **uniform way** to access things **without speaking their native structure**.

---





