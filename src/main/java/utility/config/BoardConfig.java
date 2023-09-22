package utility.config;

import utility.file.FileReader;

public class BoardConfig extends FileReader {
    private static final String PARAMETER_CREATED_BOARD = "CreatedBoard";
    private static final String PARAMETER_UPDATED_BOARD = "UpdatedBoard";
    private static final String FILE_NAME = "src/main/resource/board.config";

    public static String getCreatedBoardName() {
        return getData(PARAMETER_CREATED_BOARD, FILE_NAME);
    }

    public static String getUpdatedBoardName() {
        return getData(PARAMETER_UPDATED_BOARD, FILE_NAME);
    }
}
