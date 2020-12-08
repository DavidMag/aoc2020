import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    var index = 0
    var accumulator = 0
    var visited = mutableListOf<Int>()
    val input = File("./8.txt")
            .readLines()

    while (index >= 0 && index < input.count() && visited.contains(index).not()) {
        visited.add(index)

        val a = input[index].split(" ")
        val instruction = a[0]
        val value = a[1].toInt()

        when (instruction) {
            "nop" -> index++
            "jmp" -> index += value
            "acc" -> {
                index++
                accumulator += value
            }
        }
    }

    println(accumulator)
}

println("took: ${millis}ms")