package utility.httpclient;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import model.Board;
import model.User;
import model.response.ResponseDto;
import utility.mapper.RestAssuredMapper;
import utility.request.RestAssuredRequestBuilder;
import utility.request.RestAssuredRequestSender;
import utility.response.builder.RestAssuredResponseBuilder;
import utility.response.validator.RestAssuredResponseValidator;

import static io.restassured.RestAssured.given;

public class RestAssuredHttpClient implements HttpClient {
    private static RequestSpecification request;
    private static ResponseSpecification response;
    private RestAssuredRequestSender requestSender;

    @Override
    public ResponseDto<User> getUserRequest() {
        createUserRequest();
        createRequestSender();

        Response actualResponse = requestSender.sendGetRequest();

        RestAssuredResponseValidator.verifyResponse(actualResponse, response);
        return RestAssuredMapper.mapToUserResponse(actualResponse);
    }

    @Override
    public ResponseDto<Board> postNewBoard() {
        createBoardPostRequest();
        createRequestSender();

        Response actualResponse = requestSender.sendPostRequest();

        RestAssuredResponseValidator.verifyResponse(actualResponse, response);
        return RestAssuredMapper.mapToBoardResponse(actualResponse);
    }

    @Override
    public ResponseDto<Board> getBoardById(String boardId) {
        return null;
    }

    @Override
    public ResponseDto<Board> updateBoard(String boardId) {
        return null;
    }

    @Override
    public ResponseDto<Board> deleteBoard(String boardId) {
        return null;
    }

    private void createUserRequest() {
        RequestSpecification requestSpecification = RestAssuredRequestBuilder.buildGetUserRequest();
        updateRequest(requestSpecification);
        response = RestAssuredResponseBuilder.buildUserResponse();
    }

    private void createBoardPostRequest() {
        RequestSpecification requestSpecification = RestAssuredRequestBuilder.buildGetBoardRequest();
        updateRequest(requestSpecification);
        response = RestAssuredResponseBuilder.buildBoardResponse();
    }

    private void createRequestSender() {
        requestSender = new RestAssuredRequestSender(request);
    }

    private void updateRequest(RequestSpecification requestSpecification) {
        request = given().spec(requestSpecification);
    }
}
