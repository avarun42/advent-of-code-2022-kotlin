package day03

data class Rucksack(val items: String) {
    init {
        assert(items.length % 2 == 0)
    }

    val left = Compartment(items.take(items.length / 2))
    val right = Compartment(items.takeLast(items.length / 2))

    val sharedItem
        get() = Item.fromChar(left.sharedItemWith(right))

    data class Item(val priority: Int, val name: Char) {
        companion object {
            fun fromChar(char: Char): Item {
                return Item(
                    when {
                        char.isUpperCase() -> char.code - 'A'.code + 27
                        char.isLowerCase() -> char.code - 'a'.code + 1
                        else -> throw IllegalArgumentException("Invalid item name: $char")
                    },
                    char
                )
            }
        }
    }

    class Compartment(val items: String) {
        val itemTypes = items.toSet()

        fun sharedItemWith(other: Compartment): Char {
            val intersection = itemTypes.intersect(other.itemTypes)
            assert(intersection.size == 1)
            return intersection.first()
        }
    }
}
