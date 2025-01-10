package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringValidationTest {

    private static final Validator VALIDATOR = new Validator();

    @Test
    public void requiredTest() {
        var schema = VALIDATOR.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));


        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    public void minLengthTest() {
        var schema = VALIDATOR.string().minLength(3);
        assertFalse(schema.isValid("ok"));
        assertTrue(schema.isValid("hello"));
    }

    @Test
    public void containsTest() {
        var schema = VALIDATOR.string().contains("hello");
        assertTrue(schema.isValid("12356547hello"));
        assertFalse(schema.isValid("123"));
    }

}
