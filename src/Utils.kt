import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/** Reads lines from the given input txt file. */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/** Converts string to md5 hash. */
fun String.md5() =
    BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
        .toString(16)
        .padStart(32, '0')

/** Splits each char sequence in a collection into a list of strings, using the given delimiter. */
fun Collection<CharSequence>.splitEach(delimiter: String): List<List<String>> {
    return this.map { it.split(delimiter) }
}

/** Converts a List of length 2 to a Pair. */
fun <T> List<T>.toPair(): Pair<T, T> {
    require(this.size == 2) { "List is not of length 2!" }
    val (a, b) = this
    return Pair(a, b)
}
