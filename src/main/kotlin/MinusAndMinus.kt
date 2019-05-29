
class MinusAndMinus {
    data class Problem(val id: Int, val original: String, val target: String)

    data class Solution(val possible: Boolean) {
        override fun toString(): String {
            return "${if (possible) "YES" else "NO"}\n"
        }
    }

    fun readProblem(problemId: Int): Problem {
        return Problem(problemId, readLine()!!, readLine()!!)
    }

    fun solveProblem(problem: Problem): Solution {
        if (problem.target.length > problem.original.length) {
            return Solution(false)
        }
        if (problem.target.length == problem.original.length && problem.target != problem.original) {
            return Solution(false)
        }
        if (problem.target == problem.original) {
            return Solution(true)
        }
        var index = 0
        for (target in problem.target) {
            if (problem.original.length > index && target != problem.original[index]) {
                if (target == '+' && problem.original.length > index+1 && problem.original[index] == '-' && problem.original[index+1] == '-') {
                    index++
                } else {
                    return Solution(false)
                }
            }
            index++
        }
        if (problem.original.length > index) {
            return Solution(false)
        }
        return Solution(true)
    }
}

fun main() {
    val problem = MinusAndMinus()
    val n = readLine()!!.toInt()
    (1..n).map(problem::readProblem)
        .map(problem::solveProblem)
        .onEach(::print)
}
