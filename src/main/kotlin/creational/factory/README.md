# 🧩 Factory Pattern

## **Pattern Type:** Creational

---

## 📖 Origin Story – Why This Pattern Was Born

Imagine you're building **YouTube**. A single video page could display content as:
- A **regular video**
- A **live stream**
- A **short**
- Or even a **music video**

While they all share common behavior (play, pause, seek), each has distinct logic — like live buffering or looping. Trying to handle all variations with `if-else` scattered across your codebase becomes unmaintainable.

This led to the **Factory Pattern** — a way to **delegate object creation** to specialized logic depending on context or input type.
The Factory pattern centralizes and encapsulates the creation logic.

---

## 🎯 The Core Problem It Solves

How do you create objects without exposing the creation logic to the client, and **return instances based on input or configuration**?

The Factory pattern solves:
- **Type-based instantiation** (e.g., from a content type, message type, or API response)
- Avoiding `if-else`/`switch` clutter when instantiating polymorphic objects
- Decoupling creation logic from usage

---

## 💡 Real-World Applications

1. **YouTube Video Renderer**  
   Creates different video player objects (`LiveVideo`, `ShortVideo`, `MusicVideo`, `RegularVideo`) depending on metadata.

2. **WhatsApp Message Creation**  
   When receiving a message payload, a factory determines if it’s a `TextMessage`, `ImageMessage`, `VoiceNote`, etc., and returns the appropriate type to render or store.

---

## 🚫 When Not to Use This Pattern

- If the object creation logic is **simple** and doesn’t change based on dynamic input, a factory may be overkill.
- Overuse can lead to **too many small classes** with little logic, making it harder to trace or debug.
---
