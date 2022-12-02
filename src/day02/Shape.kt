package day02

enum class Shape {
    Rock,
    Paper,
    Scissors;

    fun beats(): Shape {
        return when (this) {
            Rock -> Scissors
            Paper -> Rock
            Scissors -> Paper
        }
    }

    fun losesTo(): Shape {
        return when (this) {
            Rock -> Paper
            Paper -> Scissors
            Scissors -> Rock
        }
    }

    fun scoreAgainst(other: Shape): Int {
        return when (other) {
            this.beats() -> 6
            this -> 3
            this.losesTo() -> 0
            else -> throw IllegalArgumentException("Unknown shape: $this")
        }
    }

    fun value(): Int {
        return when (this) {
            Rock -> 1
            Paper -> 2
            Scissors -> 3
        }
    }

    companion object {
        fun fromString(s: String): Shape {
            return when (s) {
                "A" -> Rock
                "B" -> Paper
                "C" -> Scissors
                else -> throw IllegalArgumentException("Unknown shape: $s")
            }
        }

        fun fromPlayerString(s: String): Shape {
            return when (s) {
                "X" -> Rock
                "Y" -> Paper
                "Z" -> Scissors
                else -> throw IllegalArgumentException("Unknown shape: $s")
            }
        }
    }
}
