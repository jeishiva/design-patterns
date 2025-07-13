# 🛰️ Mediator Pattern

## **Pattern Type:** Behavioral

---

## 📖 The Origin Story

In a global intelligence setup, spies are stationed across different countries. These spies must stay in contact with their central agency for updates and instructions. Meanwhile, the central agency sends mission briefs, and in turn, receives field reports from spies. If a spy’s message is flagged as suspicious, it is redirected to a validation team for scrutiny.

In such a system, letting spies directly communicate with each other, the agency, and the validator would lead to tight coupling and chaotic flows. Instead, a **central coordinator** — a **Mediator** — is introduced to handle all communications smartly.

---

## ✅ What Problem Does It Solve?

Without the Mediator pattern, components (like spies, agencies, validators) would have direct knowledge of and dependencies on one another. This becomes harder to manage as more participants are added.

The **Mediator pattern centralizes** the communication between objects, promoting **loose coupling** and more **manageable interactions**.

---

## 💡 Real-World Applications

1. **Messaging systems** – chatroom routers, moderation flows
2. **Air traffic control systems** – all aircraft communicate through the tower
3. **Rocket launch coordination** – telemetry, navigation, and control systems interact via a mediator
4. **Form validation engines** – sections of a form update based on changes in others, via a mediator
5. **UI components** – buttons, text inputs, and sliders coordinated without knowing about each other

---

## 🎮 Real-World Analogy: Spy Communication

- The **Agency** sends instructions to **all spies**
- **Spies** report back only to the **Agency**
- If a spy sends a **suspicious message**, the **Validation Unit** intercepts it
- All routing and decision-making is done via the **Mediator**, not directly by participants

This maintains **clear separation of concerns**, and each participant can focus on its own role.

---

## 🚦 When to Use Mediator Over Observer?

| Feature                     | Mediator                                      | Observer                                     |
|----------------------------|-----------------------------------------------|----------------------------------------------|
| **Communication Type**     | Controlled, centralized                       | Broadcast-like, decoupled                    |
| **Participants**           | Peer-to-peer via mediator                     | One-to-many from subject to observers        |
| **Knowledge**              | Components know only the mediator             | Observers register with subject              |
| **Control Logic**          | Mediator contains business/routing logic      | Subject has no say in how observers react    |
| **Best For**               | Coordinated workflows, UI, messaging systems  | Notifications, subscriptions, UI events      |

➡️ **Use Mediator** when interactions are complex and interdependent  
➡️ **Use Observer** when many parts need to react to changes from a single source

---
