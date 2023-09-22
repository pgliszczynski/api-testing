package utility.url;

import utility.file.FileReader;

public class UrlUtility extends FileReader {
    private final static String PARAMETER_BASE_URL = "BaseUrl";
    private final static String PARAMETER_USER_URL = "UserUrl";
    private final static String PARAMETER_BOARD_URL = "BoardUrl";
    private final static String FILE_NAME = "src/main/resource/url.config";

    public static String getUserUrl() {
        return getBaseUrl() + getData(PARAMETER_USER_URL, FILE_NAME);
    }

    public static String getBoardUrlWithId(String boardId) {
        return getBoardUrl() + "/" + boardId;
    }

    public static String getBoardUrl() {
        return getBaseUrl() + getData(PARAMETER_BOARD_URL, FILE_NAME);
    }

    public static String getBaseUrl() {
        return getData(PARAMETER_BASE_URL, FILE_NAME);
    }
}
