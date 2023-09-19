package utility.response.handler.exception;

public class TrelloUserEmptyResponse extends RuntimeException {
    public TrelloUserEmptyResponse() {
        super("Trello did not respond with ");
    }
}
