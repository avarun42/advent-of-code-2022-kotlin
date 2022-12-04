package day04

data class SectionAssignment(val assignmentRange: List<String>) {
    init {
        require(assignmentRange.size == 2)
    }

    private val start = assignmentRange[0].toInt()
    private val end = assignmentRange[1].toInt()

    fun contains(other: SectionAssignment): Boolean {
        return start <= other.start && end >= other.end
    }

    fun overlaps(other: SectionAssignment): Boolean {
        return start <= other.end && end >= other.start
    }
}
