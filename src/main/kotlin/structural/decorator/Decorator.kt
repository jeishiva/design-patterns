package structural.decorator

// Component interface
interface ImageEditor {
    fun edit(image: String): String // In real world this would be a Bitmap
}

// Concrete Component – original image
class RawImageEditor : ImageEditor {
    override fun edit(image: String): String {
        println("🖼️ Loading raw image...")
        return image
    }
}

// Abstract Decorator
abstract class ImageEditorDecorator(private val base: ImageEditor) : ImageEditor {
    override fun edit(image: String): String {
        return base.edit(image)
    }
}

// Concrete Decorator – Brightness Enhancement
class BrightnessDecorator(base: ImageEditor) : ImageEditorDecorator(base) {
    override fun edit(image: String): String {
        val edited = super.edit(image)
        println("🔆 Applying brightness adjustment")
        return "$edited -> [Brightness Applied]"
    }
}

// Concrete Decorator – Sharpness Enhancement
class SharpnessDecorator(base: ImageEditor) : ImageEditorDecorator(base) {
    override fun edit(image: String): String {
        val edited = super.edit(image)
        println("✨ Enhancing sharpness")
        return "$edited -> [Sharpness Applied]"
    }
}

// Concrete Decorator – Filter (like Instagram effect)
class FilterDecorator(base: ImageEditor, private val filterName: String) : ImageEditorDecorator(base) {
    override fun edit(image: String): String {
        val edited = super.edit(image)
        println("🎨 Applying filter: $filterName")
        return "$edited -> [Filter: $filterName Applied]"
    }
}
