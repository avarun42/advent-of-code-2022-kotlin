package day03

data class Rucksack(val items: List<Item>) {
    init {
        assert(items.size % 2 == 0)
    }

    val left = Compartment(items.take(items.size / 2))
    val right = Compartment(items.takeLast(items.size / 2))

    val sharedItem
        get() = left.sharedItemWith(right)

    class Compartment(val items: List<Item>) {
        val itemTypes = items.toSet()

        fun sharedItemWith(other: Compartment): Item {
            val intersection = itemTypes.intersect(other.itemTypes)
            assert(intersection.size == 1)
            return intersection.first()
        }
    }
}
