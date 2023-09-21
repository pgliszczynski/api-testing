package apache.parameters;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParametersMapper {

    public static List<NameValuePair> mapToList(Map<String, String> parameters) {
        return parameters.entrySet().stream()
                .map(entry -> new BasicNameValuePair(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
