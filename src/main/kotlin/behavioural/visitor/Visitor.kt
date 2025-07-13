package behavioural.visitor


data class MenuItem(val name: String, val price: Double) : FoodItem {
    override fun accept(visitor: FoodVisitor) = visitor.visitMenuItem(this)
}

data class ComboMeal(val items: List<MenuItem>, val discountPercent: Double) : FoodItem {
    override fun accept(visitor: FoodVisitor) = visitor.visitComboMeal(this)
}

data class CorporatePack(val headCount: Int, val pricePerHead: Double) : FoodItem {
    override fun accept(visitor: FoodVisitor) = visitor.visitCorporatePack(this)
}

interface FoodVisitor {
    fun visitMenuItem(item: MenuItem)
    fun visitComboMeal(combo: ComboMeal)
    fun visitCorporatePack(pack: CorporatePack)
}


interface FoodItem {
    fun accept(visitor: FoodVisitor)
}

class TaxVisitor : FoodVisitor {
    override fun visitMenuItem(item: MenuItem) {
        val tax = item.price * 0.05
        println("Tax for ${item.name}: ₹$tax")
    }

    override fun visitComboMeal(combo: ComboMeal) {
        val total = combo.items.sumOf { it.price }
        val tax = (total * (1 - combo.discountPercent / 100)) * 0.05
        println("Tax for combo: ₹$tax")
    }

    override fun visitCorporatePack(pack: CorporatePack) {
        val tax = pack.headCount * pack.pricePerHead * 0.12
        println("Tax for corporate pack: ₹$tax")
    }
}


class HappyHourVisitor : FoodVisitor {
    override fun visitMenuItem(item: MenuItem) {
        val eligible = item.price < 200
        println("Happy Hour: ${item.name} is ${if (eligible) "eligible" else "not eligible"}")
    }

    override fun visitComboMeal(combo: ComboMeal) {
        println("Combo meals are not eligible for happy hour")
    }

    override fun visitCorporatePack(pack: CorporatePack) {
        println("Corporate packs are not eligible for happy hour")
    }
}


fun main() {
    val burger = MenuItem("Cheese Burger", 180.0)
    val fries = MenuItem("Fries", 100.0)
    val combo = ComboMeal(listOf(burger, fries), discountPercent = 10.0)
    val pack = CorporatePack(headCount = 20, pricePerHead = 250.0)

    val cart: List<FoodItem> = listOf(burger, combo, pack)

    val taxVisitor = TaxVisitor()
    val happyHourVisitor = HappyHourVisitor()

    println("🔍 Calculating Tax:")
    cart.forEach { it.accept(taxVisitor) }

    println("\n⏰ Checking Happy Hour Eligibility:")
    cart.forEach { it.accept(happyHourVisitor) }
}
