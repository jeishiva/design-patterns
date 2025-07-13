# 🧩 Decorator Pattern

### **Pattern Type:** Structural

---

## 🧭 The Origin – Auto-Editing Gets Smarter

A Gallery app launches its new **Auto-Edit** feature. In the first version, it only brightens images. But over time, product and design teams want to layer more enhancements:

- 🔆 Brightness adjustments
- ✨ Sharpness enhancement
- 🎨 Filters (e.g., "Vintage", "Warm", "Noir")
- 📐 Resizing, cropping, watermarking

These features need to **wrap around the original image** and should be **stackable** — one after another — without rewriting or bloating the core image editor.

That’s when the engineering team uses the **Decorator Pattern**.

---

## 🧩 The Problem It Solves

How do you **add new behavior to an object dynamically** — without modifying the original class or using inheritance?

The **Decorator Pattern** lets you:
- Add features one layer at a time
- Wrap behavior around existing logic
- Avoid subclass explosion

---

## 🛠️ Real-World Applications

1. **Gallery & Camera Apps**  
   Auto-enhance images step-by-step: brightness, sharpness, filters — with a clean, dynamic pipeline.

2. **LLM Input Processing**  
   Wrap and chain user input through: sanitization → profanity check → spell correction → enrichment.

---

## ⚠️ When Not to Use
- When all behaviors are tightly coupled or need to be applied together every time
- When the object graph becomes too complex to debug (too many layers)

---

## 💡 Key Concepts

| Role               | Kotlin Class                | Description                               |
|--------------------|-----------------------------|-------------------------------------------|
| `Component`        | `ImageEditor`               | Base interface                            |
| `ConcreteComponent`| `RawImageEditor`            | Starts with the original image            |
| `Decorator`        | `ImageEditorDecorator`      | Wraps and extends base editor             |
| `ConcreteDecorator`| `BrightnessDecorator`, `SharpnessDecorator`, `FilterDecorator` | Each adds one enhancement |

---

