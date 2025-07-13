# 🧩 Flyweight Pattern

### **Pattern Type:** Structural

---

## 📖 Origin Story – A Forest Full of Mango Trees

Imagine we're building a **forest animation** where thousands of **mango trees** need to be rendered on screen. Each tree has the same:
- Leaf shape
- Trunk texture
- Bark color
- Fruit details

But what’s different? Just the **coordinates** where each tree appears.

In a naive approach, we might create **thousands of full object instances**, repeating the same properties over and over — completely bloating memory. This becomes a serious issue in **games**, **video rendering**, or **map visualizations**.

To fix this, we use the **Flyweight Pattern**.

---

## 🎯 The Core Problem It Solves

How do you represent a **large number of similar objects efficiently**, when most of their data is shared?

The Flyweight Pattern:
- **Extracts shared (intrinsic) state** and stores it only once
- **Externalizes unique (extrinsic) state** like position or timestamp
- Returns **reused objects** instead of creating duplicates

---

## 💡 Real-World Examples

1. **Game Object Rendering**  
   Trees, enemies, NPCs, bullets — reuse textures, shapes, or styles while changing position or rotation per instance.

2. **Map & Simulation Engines**  
   Rendering 100K+ road signs with shared metadata but unique coordinates.

3. **Animation Pipelines**  
   Repeating particles, frames, or visual components with minimal memory footprint.

---

## 🧠 Intrinsic vs Extrinsic State

| Type            | Example (Mango Tree)         |
|-----------------|------------------------------|
| **Intrinsic**   | Leaf type, trunk texture, color, shape |
| **Extrinsic**   | X/Y position, rotation, scaling, timestamp |

Flyweight stores **intrinsic** data once and **injects extrinsic** data at runtime when rendering or interacting.

---

## 🚫 When Not to Use

- When added complexity outweighs memory savings
- When objects differ too much — no real shared state to extract

---
