fun main() {
    fun part1(input: String): Int {
        val regex = Regex("mul\\(([0-9]{1,3}),([0-9]{1,3})\\)")
        return regex.findAll(input).map { it.groupValues[1].toInt() * it.groupValues[2].toInt() }.sum()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
//    part2(input).println()
}
