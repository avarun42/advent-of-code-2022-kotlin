import day02.Round

fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.split(" ") }.map { Round(it) }.sumOf { it.playerScore() }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.split(" ") }.map { Round.fromOutcome(it) }.sumOf { it.playerScore() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("day02")
    println(part1(input))
    println(part2(input))
}
