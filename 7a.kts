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
                            subRules[s] = n
                        }
                rules[split[0].trim()] = subRules
            }

    var count = 0
    rules.keys.forEach {
        if (find("shiny gold", it, rules)) count++
    }
    println(count)
}

fun find(color: String, inColor: String, rules: Map<String, Map<String, Int>>): Boolean {
    val rule = rules[inColor]
    if (rule?.contains(color) == true) {
        return true
    } else {
        rule?.forEach {
            if (find(color, it.key, rules)) {
                return true
            }
        }
    }
    return false
}

println("took: ${millis}ms")