import kotlin.math.abs
import kotlin.math.ceil

class robot(override var name: String, var healthp:Double, var batteryCharge:Int): Character {
    override var health:Double = healthp

    override fun speshialty(character: Character):Boolean {
        if ((1..2).random() == 1 && batteryCharge > 0) {
            batteryCharge --
            return true
        }
        return false
    }

    override fun heal(character: Character) {
        if (health < 90 && (1..10).random() <=5) {
            var heal = (0..5).random().toInt()
            var healBattery = (1..2).random()
            health += heal
            batteryCharge += healBattery
            println("[HEAL] $name восстанавливает себе $heal здоровья и $healBattery заряда батареи")
        }
    }


}