
class ThreeIntegersAgain {
    data class Problem(val id: Int, val sums: List<Int>)

    data class Solution(val integers: List<Int>) {
        override fun toString(): String {
            return "${integers.joinToString(" ")}\n"
        }
    }

    fun readProblem(problemId: Int): Problem {
        return Problem(problemId, readLine()!!.trim().split(" ").map(String::toInt))
    }

    fun solveProblem(problem: Problem): Solution {
        assert(problem.sums.size == 2)
        if (problem.sums[0] == problem.sums[1]) {
            return Solution(listOf(problem.sums[0]-1, 1, 1))
        } else {
            return Solution(listOf(1, problem.sums.min()!!-1, problem.sums.max()!!-problem.sums.min()!!+1))
        }
    }
}

fun main() {
    val problem = ThreeIntegersAgain()
    val n = readLine()!!.toInt()
    (1..n).map(problem::readProblem)
        .map(problem::solveProblem)
        .onEach(::print)
}
