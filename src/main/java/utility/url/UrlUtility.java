package utility.url;

public class UrlUtility {
    private final static String USER_URL = "https://api.trello.com/1/members/me";
    private final static String BOARD_URL = "https://api.trello.com/1/boards";

    public static String getUserUrl() {
        return USER_URL;
    }

    public static String geBoardUrl() {
        return BOARD_URL;
    }
}
