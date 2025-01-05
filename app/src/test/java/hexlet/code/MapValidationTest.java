package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapValidationTest {

    private static final Validator VALIDATOR = new Validator();

    @Test
    public void requiredTest() {
        var schema = VALIDATOR.map();
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
    }

    @Test
    public void sizeOfTest() {
        var schema = VALIDATOR.map();
        var data = new HashMap<String, Integer>();
        data.put("key1", 1);
        assertTrue(schema.isValid(data));

        schema.sizeOf(2);

        assertFalse(schema.isValid(data));
        data.put("key2", 2);
        assertTrue(schema.isValid(data));
    }


}
