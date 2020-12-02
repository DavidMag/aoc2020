import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("2.txt").readLines()
    var valid = 0

    input.forEach {
        val splits = it.split(' ')
        val indexes = splits[0].split('-').map { it.toInt() }
        val password = splits[2]
        val char = splits[1].first()
        var counter = 0

        indexes.forEach { i ->
            val wrongIndexedIndex = i - 1

            if ((wrongIndexedIndex >= 0 || wrongIndexedIndex < password.count()) &&
                    password[wrongIndexedIndex] == char) {
                counter++
            }
        }

        if (counter == 1) {
            valid++
        }
    }

    println(valid)
}

println("took: ${millis}ms")