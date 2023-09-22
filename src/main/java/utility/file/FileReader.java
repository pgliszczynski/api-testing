package utility.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.stream.Collectors;

public abstract class FileReader {
    private final static Logger LOGGER = LoggerFactory.getLogger("File Reader");

    public static String getData(String parameterName, String fileName) {
        try(BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(new File(fileName))))) {
            String line = bufferedReader.lines()
                    .filter(l -> l.startsWith(parameterName + "="))
                    .collect(Collectors.joining());

            return line.replaceAll(parameterName + "=", "");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return "";
    }
}
