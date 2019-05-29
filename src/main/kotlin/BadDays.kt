class BadDays {

    data class Problem(val statistics: List<Int>)

    data class Solution(val count: Int) {
        override fun toString(): String {
            return "$count\n"
        }
    }

    fun readProblem(): Problem {
        readLine()!!
        return Problem(readLine()!!.split(" ").map(String::toInt))
    }

    fun solveProblem(problem: Problem): Solution {
        val history = mutableListOf<Int>(0, 0)
        var count = 0
        for (day in problem.statistics) {
            if (history.all { it > day }) {
                count++
            } else {
                history.remove(history.min()!!)
                history.add(day)
            }
        }
        return Solution(count)
    }
}

fun main() {
    val problem = BadDays()
    listOf(problem.readProblem())
        .map(problem::solveProblem)
        .onEach(::print)
}
