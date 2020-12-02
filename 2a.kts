import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("2.txt").readLines()
    var valid = 0

    input.forEach {
        val splits = it.split(' ')
        val min = splits[0].split('-')[0].toInt()
        val max = splits[0].split('-')[1].toInt()
        val char = splits[1].first()

        var counter = 0
        splits[2].forEach {
            if (it == char) {
                counter++
            }
        }

        if (counter in min..max) {
            valid++
        }
    }

    println(valid)
}

println("took: ${millis}ms")