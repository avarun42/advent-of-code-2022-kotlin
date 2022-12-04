import day03.Item
import day03.Rucksack
import day03.sharedItem

fun main() {
    fun part1(input: List<String>): Int {
        return input
            .asSequence()
            .map { rucksackItems -> rucksackItems.map { Item.fromChar(it) } }
            .map { Rucksack(it) }
            .sumOf { it.sharedItem.priority }
    }

    fun part2(input: List<String>): Int {
        return input
            .asSequence()
            .map { rucksackItems -> rucksackItems.map { Item.fromChar(it) } }
            .map { Rucksack(it) }
            .chunked(3)
            .map { it.sharedItem() }
            .sumOf { it.priority }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("day03")
    println(part1(input))
    println(part2(input))
}
