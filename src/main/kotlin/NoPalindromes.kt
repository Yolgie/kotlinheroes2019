class NoPalindromes {
    data class Problem(val id: Int, val original: String)

    data class Solution(val solution: String) {
        override fun toString(): String {
            return "$solution\n"
        }
    }

    fun readProblem(problemId: Int): Problem {
        return Problem(problemId, readLine()!!.trim())
    }

    fun solveProblem(problem: Problem): Solution {
        print(problem.original)
        val sortedString = problem.original.toCharArray().sorted().toString()
        print(sortedString)
        return if (sortedString == sortedString.reversed()) {
            Solution("-1")
        } else {
            Solution(sortedString)
        }
    }
}

fun main() {
    val diceRolling = NoPalindromes()
    val n = readLine()!!.toInt()
    (1..n).map(diceRolling::readProblem)
        .map(diceRolling::solveProblem)
        .onEach(::print)
}
