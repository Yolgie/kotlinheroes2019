import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class DiceRollingTest {
    val diceRolling = DiceRolling()

    @Test
    fun testSolution() {
        Assertions.assertEquals(1, diceRolling.solveProblem(DiceRolling.Problem(0,7)).count)
    }
}