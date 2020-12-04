import java.io.File
import kotlin.system.measureTimeMillis

val millis = measureTimeMillis {
    val input = File("./4.txt").readText().split("\n\n")
    val eyeColors = arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    var valid = 0

    input.forEach {
        var validArgs = 0
        it
                .replace("\n", " ")
                .split(" ")
                .forEach {
                    val value = it.substringAfter(":")

                    when (it.substringBefore(":")) {
                        "byr" -> if (IntRange(1920, 2002).contains(value.toInt())) validArgs++
                        "iyr" -> if (IntRange(2010, 2020).contains(value.toInt())) validArgs++
                        "eyr" -> if (IntRange(2020, 2030).contains(value.toInt())) validArgs++
                        "ecl" -> if (eyeColors.contains(value)) validArgs++
                        "pid" -> if (value.length == 9 && value.toIntOrNull() != null) validArgs++
                        "hcl" -> {
                            val n = value.replace("#", "").toLongOrNull(16)
                            if (value.startsWith("#") && value.count() == 7 && n != null) validArgs++
                        }
                        "hgt" -> {
                            val range = when {
                                value.endsWith("in") -> IntRange(59, 76)
                                value.endsWith("cm") -> IntRange(150, 193)
                                else -> IntRange(-1, -1)
                            }

                            val number = value.replace("in", "").replace("cm", "").toInt()
                            if (range.contains(number)) validArgs++
                        }
                    }
                }

        if (validArgs == 7) valid++
    }

    println(valid)
}

println("took: ${millis}ms")