package utility.authorization;

public class AuthorizationUtility {
    private final static String API_KEY_NAME = "key";
    private final static String TOKEN_NAME = "token";
    private final static String API_KEY = "d181cfbb8f331288ea6daba4deee80f2";
    private final static String TRELLO_TOKEN = "ATTAb51a2619af17dd0ebf8a54933198f70f745433a2e6675ec3a83a78261dee5594582CF40B";

    public static String getApiKeyName() {
        return API_KEY_NAME;
    }

    public static String getTokenName() {
        return TOKEN_NAME;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public static String getTrelloToken() {
        return TRELLO_TOKEN;
    }
}
