class ChristmasOrnaments {

    data class Problem(val yellow: Int, val blue: Int, val red: Int)

    data class Solution(val count: Int) {
        override fun toString(): String {
            return "$count\n"
        }
    }

    fun readProblem(): Problem {
        val counts = readLine()!!.split(" ").map { it.toInt() }
        assert(counts.size == 3)
        return Problem(counts[0], counts[1], counts[2])
    }

    fun solveProblem(problem: Problem): Solution {
        // yellow, blue+1, red+2
        val yellow = minOf(problem.yellow, problem.blue - 1, problem.red - 2)
        return Solution(yellow * 3 + 3)
    }
}

fun main() {
    val christmasOrnaments = ChristmasOrnaments()
    listOf(christmasOrnaments.readProblem())
        .map(christmasOrnaments::solveProblem)
        .onEach(::print)
}
