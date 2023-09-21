package restassured.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import model.client.HttpClient;
import model.domain.Board;
import model.domain.User;
import model.wrapper.ResponseWrapper;
import utility.config.BoardConfig;
import restassured.mapper.ResponseMapper;
import restassured.request.RequestBuilder;
import restassured.request.RequestSender;
import restassured.response.ResponseBuilder;
import restassured.response.validator.ResponseValidator;

import static io.restassured.RestAssured.given;

public class RestAssuredClient implements HttpClient {
    private static RequestSpecification request;
    private static ResponseSpecification response;
    private RequestSender requestSender;

    @Override
    public ResponseWrapper<User> getUserRequest() {
        createUserRequest();
        createRequestSender();

        Response actualResponse = requestSender.sendGetRequest();

        ResponseValidator.verifyResponse(actualResponse, response);
        return ResponseMapper.mapToUserResponse(actualResponse);
    }

    @Override
    public ResponseWrapper<Board> postNewBoard() {
        createBoardPostRequest();
        createRequestSender();

        Response actualResponse = requestSender.sendPostRequest();

        ResponseValidator.verifyResponse(actualResponse, response);
        return ResponseMapper.mapToBoardResponse(actualResponse);
    }

    @Override
    public ResponseWrapper<Board> getBoardById(String boardId) {
        createBoardGetByIdRequest(boardId);
        createRequestSender();

        Response actualResponse = requestSender.sendGetByIdRequest(boardId);

        ResponseValidator.verifyResponse(actualResponse, response);
        return ResponseMapper.mapToBoardResponse(actualResponse);
    }

    @Override
    public ResponseWrapper<Board> updateBoard(String boardId) {
        createBoardPutRequest(boardId);
        createRequestSender();

        Response actualResponse = requestSender.sendPutRequest(boardId);

        ResponseValidator.verifyResponse(actualResponse, response);
        return ResponseMapper.mapToBoardResponse(actualResponse);
    }

    @Override
    public ResponseWrapper<Board> deleteBoard(String boardId) {
        createBoardDeleteRequest();
        createRequestSender();

        Response actualResponse = requestSender.sendDeleteRequest(boardId);

        ResponseValidator.verifyResponse(actualResponse, response);
        return ResponseMapper.mapToBoardResponse(actualResponse);
    }

    private void createUserRequest() {
        RequestSpecification requestSpecification = RequestBuilder.buildUserRequest();
        updateRequest(requestSpecification);
        response = ResponseBuilder.buildUserResponse();
    }

    private void createBoardPostRequest() {
        RequestSpecification requestSpecification = RequestBuilder.buildBoardWithNameRequest(
                BoardConfig.getCreatedBoardName()
        );
        updateRequest(requestSpecification);
        response = ResponseBuilder.buildBoardResponse();
    }

    private void createBoardGetByIdRequest(String boardId) {
        RequestSpecification requestSpecification = RequestBuilder.buildBoardRequest();
        updateRequest(requestSpecification);
        response = ResponseBuilder.buildBoardResponseWithId(
                boardId,
                BoardConfig.getCreatedBoardName());
    }

    private void createBoardPutRequest(String boardId) {
        RequestSpecification requestSpecification = RequestBuilder.buildBoardWithNameRequest(
                BoardConfig.getUpdatedBoardName()
        );
        updateRequest(requestSpecification);
        response = ResponseBuilder.buildBoardResponseWithId(
                boardId,
                BoardConfig.getUpdatedBoardName());
    }


    private void createBoardDeleteRequest() {
        RequestSpecification requestSpecification = RequestBuilder.buildBoardRequest();
        updateRequest(requestSpecification);
        response = ResponseBuilder.buildEmptyResponse();
    }

    private void createRequestSender() {
        requestSender = new RequestSender(request);
    }

    private void updateRequest(RequestSpecification requestSpecification) {
        request = given().spec(requestSpecification);
    }
}
