import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("./3.txt").readLines()
    val moveByX = 3
    val movebyY = 1
    var x = moveByX
    var y = movebyY
    var hits = 0

    do {
        if (x >= input.first().length) x -= input.first().length

        if (input[y][x] == '#') hits++

        x += moveByX
        y += movebyY
    } while (y + movebyY < input.count())

    println("$hits")
}

println("took: ${millis}ms")