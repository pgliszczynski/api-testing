package retrofit.client.parameters;

import utility.authorization.AuthorizationUtility;

import java.util.HashMap;
import java.util.Map;

public class ParametersBuilder {
    private final Map<String, String> queryParameters;

    public ParametersBuilder() {
        queryParameters = new HashMap<>();
    }

    public ParametersBuilder addAuthorization() {
        queryParameters.put(
                "key",
                AuthorizationUtility.getApiKey()
        );
        queryParameters.put(
                "token",
                AuthorizationUtility.getTrelloToken()
        );
        return this;
    }

    public Map<String, String> build() {
        return queryParameters;
    }
}
