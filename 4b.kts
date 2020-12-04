import java.io.File
import kotlin.system.measureTimeMillis
import kotlin.collections.HashMap

val millis = measureTimeMillis {
    val input = File("./4.txt").readText().split("\n\n")
    val eyeColors = arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    var valid = 0

    input.forEach {
        var validArgs = 0
        var dict = mutableMapOf<String, String>()

        it.replace("\n", " ").split(" ").forEach { string ->
            dict[string.substringBefore(":")] = string.substringAfter(":")
        }

        it.replace("\n", " ").split(" ").associateBy { string ->
            dict[string.substringBefore(":")] = stringgit .substringAfter(":")
        }

        dict.forEach {
            when (it.key) {
                "byr" -> {
                    val number = it.value.toInt()
                    if (number <= 2002 && number >= 1920) validArgs++
                }
                "iyr" -> {
                    val number = it.value.toInt()
                    if (number <= 2020 && number >= 2010) validArgs++
                }
                "eyr" -> {
                    val number = it.value.toInt()
                    if (number <= 2030 && number >= 2020) validArgs++
                }
                "hgt" -> {
                    var min = 150
                    var max = 193
                    if (it.value.contains("in")) {
                        min = 59
                        max = 76
                    }

                    val number = it.value.replace("in", "").replace("cm", "").toInt()
                    if (number <= max && number >= min && (it.value.endsWith("cm") || it.value.endsWith("in"))) validArgs++
                }
                "hcl" -> {
                    val n = it.value.replace("#", "").toLongOrNull(16)
                    if (it.value.startsWith("#") && it.value.count() == 7 && n != null) validArgs++
                }
                "ecl" -> {
                    if (eyeColors.contains(it.value)) validArgs++
                }
                "pid" -> {
                    val n = it.value.toIntOrNull()
                    if (it.value.length == 9 && n != null) validArgs++
                }
            }
        }

        if (validArgs == 7) valid++
    }

    println(valid)

}

println("took: ${millis}ms")