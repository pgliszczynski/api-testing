package utility.url;

public class UrlUtility {
    private final static String BASE_URL = "https://api.trello.com/1/";
    private final static String USER_URL = "members/me";
    private final static String BOARD_URL = "boards";

    public static String getUserUrl() {
        return getBaseUrl() + USER_URL;
    }

    public static String getBoardUrlWithId(String boardId) {
        return getBoardUrl() + "/" + boardId;
    }

    public static String getBoardUrl() {
        return getBaseUrl() + BOARD_URL;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
