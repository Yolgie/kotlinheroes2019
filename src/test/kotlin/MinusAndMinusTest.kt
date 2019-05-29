import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import MinusAndMinus.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class MinusAndMinusTest {

    val minusAndMinus = MinusAndMinus()

    @TestFactory
    fun solveProblem() = listOf(
        Problem(0, "", "") to Solution(true),
        Problem(0, "+", "+") to Solution(true),
        Problem(0, "--", "+") to Solution(true),
        Problem(0, "+--", "++") to Solution(true),
        Problem(0, "+--", "+--") to Solution(true),
        Problem(0, "++", "++") to Solution(true),
        Problem(0, "--+", "++") to Solution(true),
        Problem(0, "--+--", "++--") to Solution(true),
        Problem(0, "--+--", "--++") to Solution(true),
        Problem(0, "--+--", "+++") to Solution(true),
        Problem(0, "--+-", "++-") to Solution(true),
        Problem(0, "-+--", "-++") to Solution(true),
        Problem(0, "---+--+-", "-++++-") to Solution(true)

    )
        .map { (problem, solution) ->
            DynamicTest.dynamicTest("getting ${problem.target} from ${problem.original} is${if (solution.possible) "" else " not"} possible") {
                Assertions.assertEquals(
                    solution,
                    minusAndMinus.solveProblem(problem)
                )
            }
        }
}