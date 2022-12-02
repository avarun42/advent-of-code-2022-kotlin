package day02

enum class Outcome {
    Lose,
    Draw,
    Win;

    fun toShapeWhenOpponentIs(opponent: Shape): Shape {
        return when (this) {
            Lose -> opponent.beats()
            Draw -> opponent
            Win -> opponent.losesTo()
        }
    }

    companion object {
        fun fromString(s: String): Outcome {
            return when (s) {
                "X" -> Lose
                "Y" -> Draw
                "Z" -> Win
                else -> throw IllegalArgumentException("Unknown outcome: $s")
            }
        }
    }
}
