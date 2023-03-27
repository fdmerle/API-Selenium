package jsonObj;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Credentials {
    private static final String NAME_OF_DIC = "credentials";
    Map<String, Map<String, Map<String,String>>> details = new LinkedHashMap<>();
    @JsonAnySetter
    void setDetail(String key, Map<String, Map<String,String>> value) {
        details.put(key, value);
    }
    public Map<String,String> getCred(String group){
        return details.get(NAME_OF_DIC).get(group);
    }
}
