import java.io.File
import kotlin.math.max
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("./5.txt").readLines()
    var highest = 0
    var lowest = 1023
    var numbers = MutableList<Int>(1023) { it }


    input.forEach {
        var minRow = 0.0
        var maxRow = 127.0
        var minColumn = 0.0
        var maxColumn = 7.0

        for (i in 0 until 6) {
            if (it[i] == 'B') minRow = Math.ceil((minRow + maxRow) / 2.0)
            else maxRow = Math.floor((minRow + maxRow) / 2.0)
        }

        for (i in 7 until 9) {
            if (it[i] == 'R') minColumn = Math.ceil((minColumn + maxColumn) / 2.0)
            else maxColumn = Math.floor((minColumn + maxColumn) / 2.0)
        }

        val row =
                if (it[6] == 'F') minRow.toInt()
                else maxRow.toInt()
        val col =
                if (it[9] == 'L') minColumn.toInt()
                else maxColumn.toInt()

        val id = row * 8 + col

        numbers.remove(id)
        highest = Math.max(highest, id)
        lowest = Math.min(lowest, id)
    }

    numbers.removeAll { it < lowest || it > highest }
    println(numbers)
}

println("took: ${millis}ms")