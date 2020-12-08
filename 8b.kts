import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    var index = 0

    val input = File("./8.txt")
            .readLines()

    var result = loopNumber(input, index)
    while (result.first == false) {
        result = loopNumber(input, ++index)
    }

    println(result.second)
}

println("took: ${millis}ms")

fun loopNumber(input: List<String>, replaceIndex: Int): Pair<Boolean, Int> {
    var index = 0
    var nopJmpIndex = 0
    var accumulator = 0
    var visited = mutableListOf<Int>()

    while (index >= 0 && index < input.count() && visited.contains(index).not()) {
        visited.add(index)

        val a = input[index].split(" ")
        val instruction = a[0]
        val value = a[1].toInt()

        when (instruction) {
            "nop" -> {
                if (replaceIndex == nopJmpIndex) index += value
                else index++

                nopJmpIndex++
            }
            "jmp" -> {
                if (replaceIndex == nopJmpIndex) index++
                else index += value

                nopJmpIndex++
            }
            "acc" -> {
                index++
                accumulator += value
            }
        }
    }

    return Pair(index >= input.count(), accumulator)
}