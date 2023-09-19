package utility.authorization;

public class AuthorizationUtility {
    private final static String API_KEY = "b62bb764cf339a96a65de5f0de87797e";
    private final static String TRELLO_TOKEN = "ATTA1f67913eefc974bad052034cd15bd0d65c807a415900d79b347137ce97a99b05175E9406";

    public static String getApiKey() {
        return API_KEY;
    }

    public static String getTrelloToken() {
        return TRELLO_TOKEN;
    }
}
