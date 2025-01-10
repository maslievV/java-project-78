package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<Map> lambda = m -> m == null || m instanceof Map;
        addCheck("required", lambda);
    }

    public MapSchema required() {
        Predicate<Map> lambda = m -> m != null;
        addCheck("required", lambda);
        return this;
    }

    public MapSchema sizeof(int limit) {
        Predicate<Map> lambda = m -> m == null || m.size() == limit;
        addCheck("sizeof", lambda);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        Predicate<Map> lambda = m -> schemas.entrySet().stream()
                        .allMatch(o -> o.getValue().isValid((m).get(o.getKey())));
        addCheck("shape", lambda);
        return this;
    }


}
