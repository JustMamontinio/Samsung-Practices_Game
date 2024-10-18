abstract class Human(
    var power: Int,
    var health: Int
) {
    abstract fun attack(human:Human):Int
    abstract fun heal():Int
    abstract fun damage(var i:Int):Int
}