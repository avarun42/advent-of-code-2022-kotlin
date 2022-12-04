package day03

data class Rucksack(val items: List<Item>) {
    init {
        assert(items.size % 2 == 0)
    }

    val uniqueItems = items.toSet()

    private val left = Compartment(items.take(items.size / 2))
    private val right = Compartment(items.takeLast(items.size / 2))

    val sharedItem
        get() = left.sharedItemWith(right)

    class Compartment(items: List<Item>) {
        private val uniqueItems = items.toSet()

        fun sharedItemWith(other: Compartment): Item {
            val intersection = uniqueItems.intersect(other.uniqueItems)
            assert(intersection.size == 1)
            return intersection.first()
        }
    }
}

fun List<Rucksack> .sharedItem(): Item {
    val intersection = this.map { it.uniqueItems }.reduce { acc, set -> acc.intersect(set) }
    assert(intersection.size == 1)
    return intersection.first()
}
