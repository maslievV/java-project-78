package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<Object> lambda = m -> m instanceof Map;
        addCheck(CheckNames.REQUIRED, lambda);
    }

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeOf(int limit) {
        Predicate<Object> lambda = m -> ((Map) m).size() == limit;
        addCheck(CheckNames.SIZE_OF, lambda);
        return this;
    }

    public MapSchema shape(Map<Object, BaseSchema> schemas) {
        Predicate<Object> lambda = m -> schemas.entrySet().stream()
                        .allMatch(o -> o.getValue().isValid(((Map) m).get(o.getKey())));
        addCheck(CheckNames.SHAPE, lambda);
        return this;
    }


}
