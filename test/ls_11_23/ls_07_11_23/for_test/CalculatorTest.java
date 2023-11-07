package ls_11_23.ls_07_11_23.for_test;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class CalculatorTest {

    /*@BeforeClass
    public static void beforeAllTests() {
        System.out.println("Before all tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("After all tests");
    }

    @Before
    public void beforeEachTest() {
        System.out.println("Before each test");
    }

    @After
    public void afterEachTest() {
        System.out.println("After each test");
    }*/

    @Rule
    public ExpectedException ee = ExpectedException.none();

    @Test
    public void shouldReturnSumValues() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(4, 5);

        Assert.assertEquals("Should return 9", 9, sum);
    }

    @Test
    public void shouldReturnSumValues1() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(4, 5);

        Assert.assertEquals("Should return 9", 9, sum);

//        Assert.assertTrue(true);
    }

    @Test
    public void shouldReturnDivideValuesWhenSecondParamIsNotZero() {
        Calculator calculator = new Calculator();

        double result = calculator.divide(10, 5);

        Assert.assertEquals("Should return 2", 2, (int)result);

    }

    @Test
    public void shouldReturnDivideValuesWhenSecondParamIsZero() {
        Calculator calculator = new Calculator();

        double result = calculator.divide(10, 0);

        Assert.assertEquals("Should return -1", -1, (int)result);
    }

    @Test(expected = IOException.class)
    public void shouldThrowExceptionWithoutRule() throws IOException {
        Calculator calculator = new Calculator();

        calculator.throwException();
    }

    @Test(timeout = 1)
    public void shouldThrowExceptionWithRule() throws IOException {
        Calculator calculator = new Calculator();

        ee.expect(IOException.class);
        ee.expectMessage("Incorrect file extension");

        calculator.throwException();
    }
}
