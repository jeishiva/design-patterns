# 🧩 Builder Pattern

**Pattern Type:** Creational

---

## 📖 Origin Story – Why This Pattern Was Born

Imagine you're building a **real-time communication engine** like Zoom or Google Meet. You need to initialize it with a range of settings: audio, video, stream quality, and fallback behavior.

Passing all of them through a long constructor call becomes unreadable and error-prone — especially as defaults and optional settings evolve. You need a better way to construct this object without compromising readability or flexibility.

This is where the **Builder pattern** enters.

---
``` Kotlin
// Readable and Flexible (Builder Pattern)
val rtcEngine = RTCEngine.Builder()
.setVideoEnabled(true)
.setAudioEnabled(false)
.setStreamQuality("HD")
.setNetworkFallbackSetting("LOW_LATENCY")
.build()


// Without Builder (Constructor Hell)
val rtcEngine = RTCEngine(true, false, "HD", "LOW_LATENCY")
```

## 🎯 The Core Problem It Solves

How do you build a complex object step-by-step, allowing flexibility in configuration **without telescoping constructors** or dozens of optional parameters?

The Builder pattern allows:
- Clear and **fluent configuration** of objects
- Separation of **construction logic from the object itself**
- Building **immutable or partially mutable objects** in a controlled way

---

## 💡 Where You’ll See It (Top 3 Use Cases)

1. **RTCEngine Setup**  
   Helps configure various features like audio, video, stream quality, fallback rules in a readable and modular way.

2. **HTTP Request Objects (e.g., OkHttp, Retrofit)**  
   Used to construct request objects with optional headers, body types, and timeout settings.

---

## 🚫 When Not to Use This Pattern

- **Avoid when your object is simple** and has only 1–2 required fields.
- Avoid overuse where Kotlin named/optional parameters already suffice.

---
