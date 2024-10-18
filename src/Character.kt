import kotlin.math.abs
import kotlin.math.ceil

interface Character {
    var name:String
    var health:Double
    fun attack(attacker:Character, opponent: Character) {
        var damage:Double = (1..10).random().toDouble()
        var cnt = 0
        if ((1..10).random() <= 4) {
            println("[CRIT DAMAGE] У ${attacker.name} прокает критический урон в ${ceil(damage * 2.25)} единиц")
            damage = ceil(damage * 2.25)
        }
        if (attacker.name == "Robot" && speshialty(attacker)) {
            println("[ROBOT CRIT] ${attacker.name} активирует безынерционный удар, повышая свой урон до ${damage * 2.5 + 1}")
            damage = damage * 2.5 + 1
            cnt++
        }

        if (speshialty(opponent)) {
            if (opponent.name == "Mage") {
                println("[CAST] ${attacker.name} мог бы нанести ${opponent.name} $damage урона, но маг успел поставить щит, поэтому " +
                        "${opponent.name} блокирует весь урон")
                damage = 0.0
                cnt++
            }
            else if (opponent.name == "Knight") {
                println("[DEFENCE] ${attacker.name} мог бы нанести ${opponent.name} $damage урона, но боги сегодня милостивы, поэтому " +
                    "${opponent.name} может получить лишь ${abs(ceil(damage * 0.5-0.5))} урона")
                damage = (ceil(damage * 0.5 - 0.5))
                cnt++
            }
        }

        if (cnt == 0) {
            println("${attacker.name} наносит ${opponent.name} $damage урона")
        }

        opponent.health -= damage
    }
    fun speshialty(character: Character):Boolean
    fun heal(character: Character)
}