import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    var rules = mutableMapOf<String, Map<String, Int>>()
    File("./7.txt")
            .readLines()
            .forEach {
                val split = it.split("bags contain")
                var subRules = mutableMapOf<String, Int>()
                split[1]
                        .split(",")
                        .forEach {
                            val n = Character.getNumericValue(it.trim().first())
                            val s = it
                                    .replace("\\d|bags?\\.?)".toRegex(), "")
                                    .trim()
                            if (s != "no other") {
                                subRules[s] = n
                            }
                        }
                rules[split[0].trim()] = subRules
            }

    println(countBags("shiny gold", rules) - 1)
}

fun countBags(color: String, rules: Map<String, Map<String, Int>>): Int {
    var counter = 1
    rules[color]?.forEach {
        counter += it.value * countBags(it.key, rules)
    }

    return counter
}

println("took: ${millis}ms")