package model.creators;

import model.wrapper.RequestWrapper;

public class RequestCreator {

    public static RequestWrapper getBasicRequest() {
        return new RequestWrapper.Builder()
                .addAuthorization()
                .build();
    }

    public static RequestWrapper getRequestWithName(String name) {
        return new RequestWrapper.Builder()
                .addParameter("name", name)
                .addAuthorization()
                .build();
    }

    public static RequestWrapper getRequestWithId(String id) {
        return new RequestWrapper.Builder()
                .id(id)
                .addAuthorization()
                .build();
    }

    public static RequestWrapper getRequestWithIdAndName(String id, String name) {
        return new RequestWrapper.Builder()
                .id(id)
                .addParameter("name", name)
                .addAuthorization()
                .build();
    }
}
