package structural.flyweight

sealed class TreeSize {
    data object Small : TreeSize()
    data object Medium : TreeSize()
    data object Tall : TreeSize()
}

/**
 *  Shared Intrinsic State
 */
data class MangoTreeType(
    val leafTexture: String,
    val barkColor: String,
    val size: TreeSize
) {
    fun render(x: Int, y: Int) {
        println("🌳 Drawing Mango Tree at ($x, $y) with bark=$barkColor, texture=$leafTexture, size=$size")
    }
}

/**
 *  Flyweight Factory – stores shared instances
 */
object TreeFactory {
    private val treeTypes = mutableMapOf<String, MangoTreeType>()

    fun getMangoTreeType(leafTexture: String, barkColor: String, size: TreeSize): MangoTreeType {
        val key = "$leafTexture|$barkColor|$size"
        return treeTypes.getOrPut(key) {
            println("✅ Creating new MangoTreeType: $key")
            MangoTreeType(leafTexture, barkColor, size)
        }
    }
}


/**
 *  Context – holds extrinsic state
 */
data class MangoTree(
    val x: Int,
    val y: Int,
    val type: MangoTreeType
) {
    fun draw() = type.render(x, y)
}

// Demo
fun main() {
    val forest = mutableListOf<MangoTree>()

    val sharedType = TreeFactory.getMangoTreeType("DenseLeaves", "Brown", TreeSize.Medium)

    // Create 1000 trees in random positions using the same tree type
    for (i in 1..1000) {
        val x = (0..1000).random()
        val y = (0..1000).random()
        forest.add(MangoTree(x, y, sharedType))
    }

    println("\n🌲 Rendering 5 sample trees...\n")
    forest.take(5).forEach { it.draw() }

    println("\n🌲 Total trees created: ${forest.size}")
}
