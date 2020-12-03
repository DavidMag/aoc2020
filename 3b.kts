import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("./3.txt").readLines()
    val moveInstructions = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
    var ans = 1

    moveInstructions.forEach { instructions ->
        var x = instructions.first
        var y = instructions.second
        var hits = 0

        do {
            if (x >= input.first().length) x -= input.first().length

            if (input[y][x] == '#') hits++

            x += instructions.first
            y += instructions.second
        } while (y + instructions.second < input.count())

        ans *= hits
    }

    println("$ans")
}

println("took: ${millis}ms")