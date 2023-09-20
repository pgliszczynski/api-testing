package utility.config;

public class BoardConfig {
    private static final String CREATED_BOARD_NAME = "ApiTestBoard";
    private static final String UPDATED_BOARD_NAME = "UpdateApiTestBoard";

    public static String getCreatedBoardName() {
        return CREATED_BOARD_NAME;
    }

    public static String getUpdatedBoardName() {
        return UPDATED_BOARD_NAME;
    }
}
