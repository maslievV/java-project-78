package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberValidationTest {

    private static final Validator VALIDATOR = new Validator();

    @Test
    public void requiredTest() {
        var schema = VALIDATOR.number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
    }

    @Test
    public void positiveTest() {
        var schema = VALIDATOR.number().positive();
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-5));
    }

    @Test
    public void rangeTest() {
        var schema = VALIDATOR.number().range(5, 10);
        assertFalse(schema.isValid(4));
        assertTrue(schema.isValid(8));
        assertFalse(schema.isValid(11));
    }

}
