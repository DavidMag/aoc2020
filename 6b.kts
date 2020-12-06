import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    var total = 0
    File("./6.txt")
            .readText()
            .split("\n\n")
            .forEach {
                val rows = it.split("\n")
                var firstRow = rows.first().toMutableList()

                for (i in 1 until rows.count()) {
                    val currentRow = rows[i]
                    firstRow.removeAll { currentRow.contains(it).not() }
                }
                total += firstRow.count()
            }

    println(total)
}


println("took: ${millis}ms")