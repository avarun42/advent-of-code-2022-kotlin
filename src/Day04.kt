import day04.SectionAssignment

fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { elfPair -> elfPair.split(",").map { SectionAssignment(it.split("-")) }.toPair() }
            .count { (elf1, elf2) -> elf1.contains(elf2) || elf2.contains(elf1) }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { elfPair -> elfPair.split(",").map { SectionAssignment(it.split("-")) }.toPair() }
            .count { (elf1, elf2) -> elf1.overlaps(elf2) || elf2.overlaps(elf1) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("day04")
    println(part1(input))
    println(part2(input))
}
