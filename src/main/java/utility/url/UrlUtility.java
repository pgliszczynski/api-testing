package utility.url;

public class UrlUtility {
    private final static String USER_URL = "https://api.trello.com/1/members/me";

    public static String getUserUrl() {
        return USER_URL;
    }
}
