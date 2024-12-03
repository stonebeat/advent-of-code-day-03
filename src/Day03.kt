fun main() {
    fun part1(input: String): Int {
        val regex = Regex("mul\\((?<f1>[0-9]{1,3}),(?<f2>[0-9]{1,3})\\)")
        return regex.findAll(input).map {
            val f1 = it.groups.get("f1")?.value!!.toInt()
            val f2 = it.groups.get("f2")?.value!!.toInt()
            f1 * f2 }.sum()
    }

    fun part2(input: String): Int {
        val regex = Regex("((?<do>(do|don't))\\(\\).*?)?mul\\((?<f1>[0-9]{1,3}),(?<f2>[0-9]{1,3})\\)")
        val matches = regex.findAll(input)
        var mulIsActivated = true
        var sum = 0

        for (match in matches) {
            var instructionDo = match.groups.get("do")?.value
            mulIsActivated = when (instructionDo) {
                "do" -> true
                "don't" -> false
                else -> mulIsActivated
            }

            if (!mulIsActivated) continue

            val f1 = match.groups.get("f1")?.value!!.toInt()
            val f2 = match.groups.get("f2")?.value!!.toInt()
            sum += f1 * f2
        }
        return sum
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInputPart1 = readInput("Day03_test_part1")
    val testInputPart2 = readInput("Day03_test_part2")
    check(part1(testInputPart1) == 161)
    check(part2(testInputPart2) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
