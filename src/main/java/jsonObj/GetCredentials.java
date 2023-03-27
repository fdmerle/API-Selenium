package jsonObj;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.NoSuchElementException;

public class GetCredentials {
    private Map<String,String> getCredentials(String group) {
        String pathStr = "Libs/credentials.json";
        Path filePath = Path.of(pathStr);
        String json = null;
        try {
            json = Files.readString(filePath);
        } catch (IOException e) {
            throw new NoSuchElementException(e);
        }
        Credentials pairOfCred = new Credentials();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            pairOfCred = objectMapper.readValue(json, Credentials.class);
        } catch (JsonProcessingException e) {
            throw new NoSuchElementException(e);
        }
        return pairOfCred.getCred(group);
    }

    public String getName(String group){
        String name = "name";
        return getCredentials(group).get(name);
    }

    public String getPass(String group){
        String name = "password";
        return getCredentials(group).get(name);
    }
}
