# 🧩 Command  Pattern

## **Pattern Type:** Behavioral

---

## 📖 The Origin Story

Imagine a cloud platform that runs various tasks on demand — resizing images, cleaning logs, executing analytics, and more.

Instead of executing these actions immediately when requested, each task is **packaged as a command** and handed off to a **central executor**, which can:
- Run them in sequence
- Retry on failure
- Delay or schedule execution
- Log executions for audits

This abstraction ensures **loose coupling** — the system that triggers a task doesn’t need to know **how** it is done.

---

## ✅ What Problem Does It Solve?

Without the Command Pattern, you might:
- Call functions directly — leading to tight coupling
- Struggle to implement retry, undo, or deferred execution
- Mix execution logic with orchestration

With this pattern, the request is **encapsulated as an object**, separating *what to do* from *how and when to do it*.

---

## 💡 Top Use Cases

1. **Cloud Task Orchestration** – like AWS Lambda queues, Firebase Cloud Functions
2. **Undo/Redo Systems** – e.g., graphic editors, IDEs
3. **Transactional Job Queues** – analytics batches, background uploads
4. **Game Command Queues** – input buffering
5. **Button Action Mapping** – decouple UI from business logic

---

## ☁️ Real-World Analogy: Cloud Task Executor

In a cloud backend:
- The user requests: "resize this image", "clean logs", or "run analytics"
- Each request becomes a **command object**
- The system **queues these commands** for execution later (maybe immediately, maybe in a scheduled window)
- The command carries **enough info to perform the task**, and the **executor doesn't need to know any details**

This design brings **reliability, flexibility, and auditability**.

---
