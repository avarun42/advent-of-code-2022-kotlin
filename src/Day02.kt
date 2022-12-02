enum class Shape {
    Rock,
    Paper,
    Scissors;

    private fun beats(other: Shape): Boolean {
        return when (this) {
            Rock -> other == Scissors
            Paper -> other == Rock
            Scissors -> other == Paper
        }
    }

    fun scoreAgainst(other: Shape): Int {
        return when {
            this.beats(other) -> 6
            this == other -> 3
            else -> 0
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
                "A",
                "X" -> Rock
                "B",
                "Y" -> Paper
                "C",
                "Z" -> Scissors
                else -> throw IllegalArgumentException("Unknown shape: $s")
            }
        }
    }
}

data class Round(val opponent: Shape, val player: Shape) {
    constructor(
        input: List<String>
    ) : this(opponent = Shape.fromString(input[0]), player = Shape.fromString(input[1]))

    fun playerScore(): Int {
        return player.value() + player.scoreAgainst(opponent)
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.split(" ") }.map { Round(it) }.sumOf { it.playerScore() }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
