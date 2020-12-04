import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("./4.txt")
            .readText()
            .split("\n\n")
    var valid = 0

    input.forEach {
        val dict = it
                .replace("\n", " ")
                .split(" ")
                .associateBy({ it.substringBefore(":") }, { it.substringAfter(":") })

        if (dict.count() == 8 || (dict.count() == 7 && dict.keys.contains("cid").not())) valid++
    }

    println(valid)
}

println("took: ${millis}ms")