import kotlin.math.ceil

class knight(override var name: String, var healthp:Double, var def:Int): Character {
    override var health:Double = healthp

    override fun speshialty(character: Character):Boolean {
        if ((1..9).random()<=3) {
            return true
        }
        return false
    }
    override fun heal(character: Character) {
        if (character.health < 90 && (1..10).random() <=5) {
            var heal = (0..3).random().toInt()
            character.health += heal
            println("[HEAL] $name восстанавливает себе $heal здоровья")
        }
    }
}