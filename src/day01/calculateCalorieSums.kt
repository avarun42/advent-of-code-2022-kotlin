package day01

fun calculateCalorieSums(input: List<String>): List<Int> {
    return input.fold(listOf(0)) { acc, s ->
        if (s.isEmpty()) {
            acc + 0
        } else {
            acc.dropLast(1) + (acc.last() + s.toInt())
        }
    }
}
