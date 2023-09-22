package utility.config;

import utility.file.FileReader;

public class UserConfig extends FileReader {
    private final static String PARAMETER_ID = "Id";
    private final static String PARAMETER_FULL_NAME = "FullName";
    private final static String PARAMETER_USERNAME = "Username";
    private final static String PARAMETER_EMAIL = "Email";
    private final static String FILE_NAME = "src/main/resource/user.config";

    public static String getId() {
        return getData(PARAMETER_ID, FILE_NAME);
    }

    public static String getFullName() {
        return getData(PARAMETER_FULL_NAME, FILE_NAME);
    }

    public static String getUsername() {
        return getData(PARAMETER_USERNAME, FILE_NAME);
    }

    public static String getEmail() {
        return getData(PARAMETER_EMAIL, FILE_NAME);
    }
}
