package day03

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
