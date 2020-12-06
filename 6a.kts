import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    var total = 0

    File("./6.txt")
            .readText()
            .split("\n\n")
            .forEach {
                total += it
                        .replace("\n", "")
                        .toCharArray()
                        .toSet()
                        .count()
            }

    println(total)
}

println("took: ${millis}ms")