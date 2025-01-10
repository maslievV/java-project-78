package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

        schema.sizeof(2);

        assertFalse(schema.isValid(data));
        data.put("key2", 2);
        assertTrue(schema.isValid(data));
    }

    @Test
    public void shapeTest() {
        var schema = VALIDATOR.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("firstname", VALIDATOR.string().required());
        schemas.put("lastname", VALIDATOR.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, String> human1 = Map.of(
                "firstname", "John",
                "lastname", "Smith"
        );
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = Map.of(
                "firstname", "John",
                "lastname", ""
        );
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = Map.of(
                "firstname", "John",
                "lastname", "S"
        );
        assertFalse(schema.isValid(human3));
    }


}
