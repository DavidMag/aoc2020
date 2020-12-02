import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("./1.txt")
    val inputAsArray = input.readLines().map { it.toInt() }
    var answer = 0

    outerLoop@ for (i in 0 until inputAsArray.count()) {
        for (j in i + 1 until inputAsArray.count()) {
            for (k in j + 1 until inputAsArray.count()) {
                if (inputAsArray[i] + inputAsArray[j] + inputAsArray[k] == 2020) {
                    answer = inputAsArray[i] * inputAsArray[j] * inputAsArray[k]
                    break@outerLoop
                }
            }
        }
    }

    println("$answer")
}

println("took: ${millis}ms")