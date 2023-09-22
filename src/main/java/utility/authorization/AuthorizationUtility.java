package utility.authorization;

import utility.file.FileReader;

public class AuthorizationUtility extends FileReader {
    private final static String PARAMETER_API_KEY = "key";
    private final static String PARAMETER_TOKEN = "token";
    private final static String FILE_NAME = "src/main/resource/authorization.config";

    public static String getApiKeyName() {
        return PARAMETER_API_KEY;
    }

    public static String getTokenName() {
        return PARAMETER_TOKEN;
    }

    public static String getApiKey() {
        return getData(PARAMETER_API_KEY, FILE_NAME);
    }

    public static String getTrelloToken() {
        return getData(PARAMETER_TOKEN, FILE_NAME);
    }
}
