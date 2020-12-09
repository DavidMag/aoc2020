import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("./9.txt")
            .readLines()
            .map { it.toLong() }
    var faultyNumber: Long = 0
    var numberRange = emptyList<Long>()

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
        break@outerLoop
    }

    outerLoop@ for (i in 0 until input.count()) {
        var acc = mutableListOf<Long>(input[i])
        var j = i + 1

        while (acc.sum() < faultyNumber) {
            acc.add(input[j++])

            if (acc.sum() == faultyNumber) {
                numberRange = acc.sorted()
                break@outerLoop
            }
        }
    }

    println(faultyNumber)
    println("${numberRange.first()} + ${numberRange.last()} = ${numberRange.first() + numberRange.last()}")
}

println("took: ${millis}ms")