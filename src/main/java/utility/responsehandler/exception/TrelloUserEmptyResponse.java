package utility.responsehandler.exception;

public class TrelloUserEmptyResponse extends RuntimeException {
    public TrelloUserEmptyResponse() {
        super("Trello did not respond with ");
    }
}
