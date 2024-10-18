class Mage(override var name: String,var healthp:Double, var Mana:Int): Character {
    override var health:Double = healthp

    override fun speshialty(character: Character):Boolean {
        if ((1..10).random() == 1 && Mana > 0){
            Mana --
            return true }
        return false
    }

    override fun heal(character: Character) {
        if (health < 90 && (1..2).random() == 1) {
            var heal = (0..5).random().toInt()
            var healmana = (1..2).random()
            health += heal
            Mana += healmana
            println("[HEAL] $name восстанавливает себе $heal здоровья и $healmana маны")
        }
    }
}