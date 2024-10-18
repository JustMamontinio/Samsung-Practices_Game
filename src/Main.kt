import java.awt.Robot

fun main() {
    val Robot = robot("Robot", 100.0, 3)
    val Knight = knight("Knight", 100.0, 50)
    val Mage = Mage("Mage", 100.0, 3)
    var characterArray = arrayOf(Robot, Knight, Mage)
    var turn = 0
    var dead = 0

    while (dead == 0) {
        var attacker = characterArray[turn % characterArray.size]
        //var opponent = characterArray[(turn + 1) % characterArray.size]
        var k:Int = 1
        while (BladeMale()) {
            ++k
            println("[MISS] ${characterArray[(turn + k - 1) % characterArray.size].name} уклоняется от урона и " +
                    "удар направляется в ${characterArray[(turn + k) % characterArray.size].name}")
        }
        var opponent = characterArray[(turn + k) % characterArray.size]
        if (attacker.name == "Robot" || attacker.name == "Mage") {
            if (attacker.name == "Robot" && Robot.batteryCharge <= 0){
                println("[NO_ENERGY] У ${attacker.name} недостаточно заряда батареи, поэтому он пропускает ход и восстанавливает" +
                        " себе 1 заряд")
                Robot.batteryCharge ++
                turn ++
                println()
                continue
            }
            if (attacker.name == "Mage" && Mage.Mana <= 0){
                println("[NO_MANA] У ${attacker.name} недостаточно маны для каста, поэтому он пропускает ход и восстанавливает" +
                        " себе 1 ману")
                Mage.Mana ++
                turn ++
                println()
                continue
            }
        }
        attacker.attack(attacker, opponent)
        if (attacker.name == "Robot" || attacker.name == "Mage") {
            if (attacker.name == "Robot") {
                Robot.batteryCharge --
            }
            else {
                Mage.Mana --
            }
        }
        if (opponent.health <= 0) {
            println("[DEAD] Оппонент ${opponent.name} повержен")
            dead += 1
            break
        }
        else {
            attacker.heal(attacker)
        }
        println("У робота ${Robot.health} хр, у рыцаря ${Knight.health},у мага ${Mage.health}")
        turn++
        println()
    }
    println("[GAME_OVER] Игра закончена")
}

fun BladeMale():Boolean {
    if ((1..10).random() <= 2) {
        return true
    }
    return false
}