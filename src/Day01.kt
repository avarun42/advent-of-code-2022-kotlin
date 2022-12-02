fun main() {
    fun calculateCalorieSums(input: List<String>): List<Int> {
        return input.fold(listOf(0)) { acc, s ->
            if (s.isEmpty()) {
                acc + 0
            } else {
                acc.dropLast(1) + (acc.last() + s.toInt())
            }
        }
    }

    fun part1(input: List<String>): Int {
        return calculateCalorieSums(input).max()
    }

    fun part2(input: List<String>): Int {
        return calculateCalorieSums(input).sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
