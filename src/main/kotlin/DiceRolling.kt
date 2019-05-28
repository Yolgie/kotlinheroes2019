import kotlin.math.sign

data class Problem(val id: Int, val target: Int)

data class Solution(val count: Int) {
    override fun toString(): String {
        return "$count\n"
    }
}

fun readProblem(problemId: Int): Problem {
    return Problem(problemId, readLine()!!.toInt())
}

fun solveProblem(problem: Problem): Solution {
    return Solution(problem.target / 7 + (problem.target % 7).sign)
}

fun main() {
    val n = readLine()!!.toInt()
    (1..n).map(::readProblem)
        .map(::solveProblem)
        .onEach(::print)
}
