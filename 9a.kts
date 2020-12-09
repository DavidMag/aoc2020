import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("./9.txt")
            .readLines()
            .map { it.toLong() }
    var faultyNumber: Long = 0

    outerLoop@ for (i in 25 until input.count()) {
        var target = input[i]
        var numbers = input.subList(i - 25, i)

        for (j in 0 until numbers.count()) {
            var subTarget = target - numbers[j]
            if (subTarget != numbers[j] && numbers.contains(subTarget)) {
                continue@outerLoop
            }
        }

        faultyNumber = target
    }

    println(faultyNumber)
}

println("took: ${millis}ms")