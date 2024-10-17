//Tests Classes are just typical Java Classes, but it's the METHODS that are special

import com.revature.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*; //Now we have access to all assertions in one line


public class CalculatorTests {

    //NOTE: Ben accidentally gave us JUnit 4! So we have to use "@Before" and and "After"
    //Pls study BeforeEach and AfterEach in JUnit 5 for QC etc (it's all in the notes)

    //Instantiate a Calculator object
    Calculator calc = new Calculator();

    //beforeEach lets us define logic that runs BEFORE EACH test
    @Before
    public void beforeEach() {
        System.out.println("Running a test...Maybe we would open some resources here?");
    }

    //afterEach lets us define logic that runs AFTER EACH test
    @After
    public void afterEach() {
        System.out.println("Test complete. We would close any resources opened for the test here!");
    }

    //Why would we bother before/after each?
    //Typically used to open resources before a test, or close them after a test (DB connection?)

    //positive test for all()
    @Test
    public void testAdd() {
        int result = calc.add(5,10);
        assertEquals(result, 15);
    }

    @Test
    public void testAddNegatives() {
        int result = calc.add(-20,-40);

        //there are other assertions we can use besides assertEquals
        assertEquals(result, -60);
        assertNotEquals(result,60); //make sure that the add() method can handle the negative signs appropriately

        //It's fine to have multiple assertions in one test methods

    }

    @Test
    public void testDivide() {
        double result = calc.divide(15,2);
        assertTrue(result == 7.5);
        assertFalse(result == 7); //make sure divide() doesn't round down
    }

    //negative tests for divide() - remember negative tests test what happens when something goes wrong

    @Test
    public void testDivideByZero() {
        //"assert that an IllegalArgumentException gets thrown when we try to divide by zero"

        assertThrows(IllegalArgumentException.class, () -> calc.divide(5,0));
    }

}
