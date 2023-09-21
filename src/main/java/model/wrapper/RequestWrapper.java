package model.wrapper;

import utility.authorization.AuthorizationUtility;

import java.util.Map;
import java.util.Objects;

public class RequestWrapper {
    private final int id;
    private final Map<String, String> queryParameters;

    public static class Builder {
        private int id;
        private Map<String, String> queryParameters;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder addAuthorization() {
            addParameter(
                    AuthorizationUtility.getApiKeyName(),
                    AuthorizationUtility.getApiKey()
            );
            addParameter(
                    AuthorizationUtility.getTokenName(),
                    AuthorizationUtility.getTrelloToken()
            );
            return this;
        }

        public Builder addParameter(String name, String value) {
            this.queryParameters.put(name, value);
            return this;
        }

        public RequestWrapper build() {
            return new RequestWrapper(this);
        }
    }

    private RequestWrapper(Builder builder) {
        this.id = builder.id;
        this.queryParameters = builder.queryParameters;
    }

    public int getId() {
        return id;
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestWrapper that = (RequestWrapper) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(queryParameters, that.queryParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, queryParameters);
    }

    @Override
    public String toString() {
        return "RequestWrapper{" +
                "body=" + id +
                ", queryParameters=" + queryParameters +
                '}';
    }
}
