package structural.composite

// Common interface for all taxpayers
interface TaxPayer {
    fun collectTax(): Int
}

// Leaf: Individual
class Individual(private val name: String, private val annualTax: Int) : TaxPayer {
    override fun collectTax(): Int {
        println("Collecting ₹$annualTax from Individual: $name")
        return annualTax
    }
}

// Leaf: Corporate
class Corporate(private val name: String, private val corporateTax: Int) : TaxPayer {
    override fun collectTax(): Int {
        println("Collecting ₹$corporateTax from Corporate: $name")
        return corporateTax
    }
}

// Composite: Holding company or umbrella group
class HoldingCompany(private val name: String) : TaxPayer {
    private val members = mutableListOf<TaxPayer>()

    fun addMember(taxPayer: TaxPayer) {
        members.add(taxPayer)
    }

    override fun collectTax(): Int {
        println("Collecting from Holding Company: $name")
        var total = 0
        for (member in members) {
            total += member.collectTax()
        }
        println("Total collected from $name: ₹$total\n")
        return total
    }
}
