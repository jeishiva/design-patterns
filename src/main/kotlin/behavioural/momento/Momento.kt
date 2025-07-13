package behavioural.momento

// Memento: Represents the saved state
data class ArmySnapshot(
    val armySize: Int,
    val weaponPower: Int,
    val conqueredKingdoms: List<String>
)

// Originator: The main object whose state needs saving/restoring
class Army {
    private var armySize: Int = 1000
    private var weaponPower: Int = 5
    private val kingdoms = mutableListOf<String>()

    fun conquer(kingdom: String) {
        println("Conquered $kingdom!")
        kingdoms.add(kingdom)
        armySize -= (100..300).random()  // simulate losses
        weaponPower += 1
    }

    fun currentStatus() {
        println("ArmySize: $armySize | WeaponPower: $weaponPower | Kingdoms: $kingdoms")
    }

    fun save(): ArmySnapshot {
        return ArmySnapshot(armySize, weaponPower, kingdoms.toList())
    }

    fun restore(snapshot: ArmySnapshot) {
        println("Restoring army state from previous victory...")
        armySize = snapshot.armySize
        weaponPower = snapshot.weaponPower
        kingdoms.clear()
        kingdoms.addAll(snapshot.conqueredKingdoms)
    }
}

// Caretaker: Manages snapshots of the army
class WarHistory {
    private val history = mutableListOf<ArmySnapshot>()

    fun save(snapshot: ArmySnapshot) {
        history.add(snapshot)
    }

    fun getLastCheckpoint(): ArmySnapshot? {
        return history.lastOrNull()
    }

    fun listCheckpoints(): List<ArmySnapshot> = history.toList()
}

// Client
fun main() {
    val army = Army()
    val history = WarHistory()

    println("Initial Army Prepared")
    army.currentStatus()

    // Conquer a few kingdoms and save after each
    val kingdoms = listOf("North", "East", "West")
    for (kingdom in kingdoms) {
        army.conquer(kingdom)
        history.save(army.save())
    }

    println("Attempting to conquer The South...")
    val failed = true
    if (failed) {
        println("Failed to conquer The South")
        val lastCheckpoint = history.getLastCheckpoint()
        lastCheckpoint?.let { army.restore(it) }
    }

    println("Final Army Status:")
    army.currentStatus()
}
