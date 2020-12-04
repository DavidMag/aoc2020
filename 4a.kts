import java.io.File
import kotlin.system.measureTimeMillis
import kotlin.collections.HashMap

val millis = measureTimeMillis {
    val input = File("./4.txt").readText().split("\n\n")

    var valid = 0

    input.forEach {
        println(it)
        var dict = HashMap<String, String>()

        it.replace("\n", " ").split(" ").forEach { string ->
            //println(string)
            dict[string.substringBefore(":")] = string.substringAfter(":")
        }
        println("counr:  ${dict.keys.count()}")
        if (dict.keys.count() >= 8 || (dict.keys.count() >= 7 && dict.keys.contains("cid").not())) valid++
    }

    println(valid)

}

println("took: ${millis}ms")