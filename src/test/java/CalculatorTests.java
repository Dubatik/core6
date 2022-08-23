import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
    Calculator sut;

    @BeforeEach
    public void init() {
        System.out.println("start");
        sut = new Calculator();
    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
        sut = null;
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @Test
    public void testAdd() {
        System.out.println("testing sum");
        int x = 1, y = 2, expected = 3;
        int result = sut.plus.apply(x, y);
        assertEquals(expected, result);
    }

    @Test
    public void testMinus() {
        System.out.println("testing minus");
        int x = 2, y = 2, expected = 0;
        int result = sut.minus.apply(x, y);
        assertEquals(expected, result);

    }

    @Test
    public void testDivide() {
        System.out.println("testing divide");
        int x = 15, y = 2, expected = 7;
        int result = sut.devide.apply(x, y);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testAdd(int x, int y, int expected) {
        int result = sut.plus.apply(x, y);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(1, 2, 3), Arguments.of(3, 5, 8));

    }

}

