package day02

data class Round(val opponent: Shape, val player: Shape) {
    constructor(
        input: List<String>
    ) : this(opponent = Shape.fromString(input[0]), player = Shape.fromPlayerString(input[1]))

    companion object {
        fun fromOutcome(input: List<String>): Round {
            val outcome = Outcome.fromString(input[1])
            val opponent = Shape.fromString(input[0])
            val player = outcome.toShapeWhenOpponentIs(opponent)

            return Round(opponent, player)
        }
    }

    fun playerScore(): Int {
        return player.value() + player.scoreAgainst(opponent)
    }
}
