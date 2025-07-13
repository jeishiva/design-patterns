# 🧩 Observer Pattern

## **Pattern Type:** Behavioral

---

## 🛰️ The Origin – Real-Time Threat Alerts via Surveillance Drones

In a national defense surveillance system, **autonomous drones** patrol borders and restricted zones. When a threat is detected — say, a **missile launch** or **unauthorized vehicle movement** — the drone must **notify multiple systems** at once:

- 🪖 Army Command
- 💻 Cyber Intelligence
- 📡 Communications Center

Each of these response units needs to act immediately, **without the drone knowing their internal logic**. The drone simply broadcasts an **encrypted message**, and each unit handles it its own way.

This is exactly what the **Observer Pattern** enables: a **publisher** (subject) notifies all **subscribed observers** about a change in state, in real time.

---

## 🧩 The Problem It Solves

> How do you inform many parts of your system about a change without tightly coupling them?

With the Observer Pattern:

- Subjects keep a list of observers (subscribers)
- When something changes, the subject notifies all observers
- Observers decide how to handle the update

---

## 💡 Real-World Applications

1. **Mobile Downloads**  
   Notify UI components when a download completes, fails, or progresses.

2. **Firebase / Pub-Sub Messaging**  
   Broadcast messages across services — only interested listeners respond.

3. **Stock Market Tickers**  
   Traders, dashboards, and bots subscribe to price changes in real-time.

4. **File Watchers**  
   Tools like IDEs or CI/CD runners react when files are updated.

---

