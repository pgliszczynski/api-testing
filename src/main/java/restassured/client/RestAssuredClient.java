package restassured.client;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import model.client.HttpClient;
import model.domain.Board;
import model.domain.User;
import model.wrapper.RequestWrapper;
import model.wrapper.ResponseWrapper;
import restassured.request.RequestBuilder;
import restassured.mapper.ResponseMapper;
import restassured.request.RequestSender;
import restassured.response.ResponseBuilder;
import restassured.response.validator.ResponseValidator;
import utility.config.BoardConfig;

public class RestAssuredClient implements HttpClient {
    private final RequestBuilder requestBuilder;
    private final RequestSender requestSender;
    private final ResponseBuilder responseBuilder;

    public RestAssuredClient(RequestWrapper requestWrapper) {
        this.requestBuilder = new RequestBuilder(requestWrapper);
        this.requestSender = new RequestSender();
        this.responseBuilder = new ResponseBuilder();
    }

    @Override
    public ResponseWrapper<User> getUserRequest() {
        ResponseSpecification expectedResponse = responseBuilder.buildUserResponse();
        Response actualResponse = requestSender.sendGetRequest(
                requestBuilder.createUserRequest());

        ResponseValidator.verifyResponse(actualResponse, expectedResponse);
        return ResponseMapper.mapToUserResponse(actualResponse);
    }

    @Override
    public ResponseWrapper<Board> postNewBoard() {
        ResponseSpecification expectedResponse = responseBuilder.buildBoardResponse(
                BoardConfig.getCreatedBoardName());
        Response actualResponse = requestSender.sendPostRequest(
                requestBuilder.createBoardRequest());

        ResponseValidator.verifyResponse(actualResponse, expectedResponse);
        return ResponseMapper.mapToBoardResponse(actualResponse);
    }

    @Override
    public ResponseWrapper<Board> getBoardById(String boardId) {
        ResponseSpecification expectedResponse = responseBuilder.buildBoardResponseWithId(
                boardId,
                BoardConfig.getCreatedBoardName());
        Response actualResponse = requestSender.sendGetByIdRequest(
                boardId,
                requestBuilder.createBoardRequest());

        ResponseValidator.verifyResponse(actualResponse, expectedResponse);
        return ResponseMapper.mapToBoardResponse(actualResponse);
    }

    @Override
    public ResponseWrapper<Board> updateBoard(String boardId) {
        ResponseSpecification expectedResponse = responseBuilder.buildBoardResponseWithId(
                boardId,
                BoardConfig.getUpdatedBoardName());
        Response actualResponse = requestSender.sendPutRequest(
                boardId,
                requestBuilder.createBoardRequest());

        ResponseValidator.verifyResponse(actualResponse, expectedResponse);
        return ResponseMapper.mapToBoardResponse(actualResponse);
    }

    @Override
    public ResponseWrapper<Board> deleteBoard(String boardId) {
        ResponseSpecification expectedResponse = responseBuilder.buildEmptyResponse();
        Response actualResponse = requestSender.sendDeleteRequest(
                boardId,
                requestBuilder.createBoardRequest());

        ResponseValidator.verifyResponse(actualResponse, expectedResponse);
        return ResponseMapper.mapToBoardResponse(actualResponse);
    }
}
