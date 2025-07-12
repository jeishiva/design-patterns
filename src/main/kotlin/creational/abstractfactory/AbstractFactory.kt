package creational.abstractfactory


// Interfaces
interface Weapon {
    fun attack()
}

interface Defense {
    fun protect()
}

// Medieval implementations
class Sword : Weapon {
    override fun attack() { /* Slash with sword */ }
}

class IronShield : Defense {
    override fun protect() { /* Block with shield */ }
}

// Modern implementations
class Gun : Weapon {
    override fun attack() { /* Fire bullets */ }
}

class Grenade : Defense {
    override fun protect() { /* Defensive explosion */ }
}

// Futuristic implementations
class LaserGun : Weapon {
    override fun attack() { /* Fire laser */ }
}

class EnergyShield : Defense {
    override fun protect() { /* Activate energy field */ }
}

// Factory Interface
interface WeaponFactory {
    fun createWeapon(): Weapon
    fun createDefense(): Defense
}

// Concrete Factories
class MedievalFactory : WeaponFactory {
    override fun createWeapon(): Weapon = Sword()
    override fun createDefense(): Defense = IronShield()
}

class ModernFactory : WeaponFactory {
    override fun createWeapon(): Weapon = Gun()
    override fun createDefense(): Defense = Grenade()
}

class FuturisticFactory : WeaponFactory {
    override fun createWeapon(): Weapon = LaserGun()
    override fun createDefense(): Defense = EnergyShield()
}

// Sealed class with embedded factory creation
sealed class Era {
    abstract fun create(): WeaponFactory

    data object Medieval : Era() {
        override fun create(): WeaponFactory = MedievalFactory()
    }

    data object Modern : Era() {
        override fun create(): WeaponFactory = ModernFactory()
    }

    data object Futuristic : Era() {
        override fun create(): WeaponFactory = FuturisticFactory()
    }
}

// Usage
fun main() {
    val era: Era = Era.Medieval
    val factory = era.create()

    val weapon = factory.createWeapon()
    val defense = factory.createDefense()

    weapon.attack()
    defense.protect()
}
