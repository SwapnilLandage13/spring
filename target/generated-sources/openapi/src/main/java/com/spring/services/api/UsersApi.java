/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.spring.services.api;

import com.spring.services.model.User;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-22T10:22:25.930911300+05:30[Asia/Calcutta]")
@Validated
@Api(value = "users", description = "the users API")
public interface UsersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /users/addUser : add user details
     *
     * @param user User details (required)
     * @return Success (status code 200)
     *         or Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint. (status code 401)
     *         or Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager. (status code 403)
     *         or The origin server did not find a current representation for the target resource or is not willing to disclose that one exists. (status code 404)
     *         or The method received in the request-line is known by the origin server but not supported by the target resource. (status code 405)
     *         or The server encountered an unexpected condition that prevented it from fulfilling the request. (status code 500)
     *         or The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay (status code 503)
     *         or Unexpected ErrorResponse (status code 200)
     */
    @ApiOperation(value = "add user details", nickname = "usersAddUserPost", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint."),
        @ApiResponse(code = 403, message = "Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager."),
        @ApiResponse(code = 404, message = "The origin server did not find a current representation for the target resource or is not willing to disclose that one exists."),
        @ApiResponse(code = 405, message = "The method received in the request-line is known by the origin server but not supported by the target resource."),
        @ApiResponse(code = 500, message = "The server encountered an unexpected condition that prevented it from fulfilling the request."),
        @ApiResponse(code = 503, message = "The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay"),
        @ApiResponse(code = 200, message = "Unexpected ErrorResponse") })
    @PostMapping(
        value = "/users/addUser",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> _usersAddUserPost(@ApiParam(value = "User details" ,required=true )  @Valid @RequestBody User user) {
        return usersAddUserPost(user);
    }

    // Override this method
    default  ResponseEntity<Void> usersAddUserPost(User user) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /users/deleteById : delete user By Id
     *
     * @param userId Delete User By Id (required)
     * @return Success (status code 200)
     *         or Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint. (status code 401)
     *         or Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager. (status code 403)
     *         or The origin server did not find a current representation for the target resource or is not willing to disclose that one exists. (status code 404)
     *         or The method received in the request-line is known by the origin server but not supported by the target resource. (status code 405)
     *         or The server encountered an unexpected condition that prevented it from fulfilling the request. (status code 500)
     *         or The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay (status code 503)
     *         or Unexpected ErrorResponse (status code 200)
     */
    @ApiOperation(value = "delete user By Id", nickname = "usersDeleteByIdDelete", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint."),
        @ApiResponse(code = 403, message = "Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager."),
        @ApiResponse(code = 404, message = "The origin server did not find a current representation for the target resource or is not willing to disclose that one exists."),
        @ApiResponse(code = 405, message = "The method received in the request-line is known by the origin server but not supported by the target resource."),
        @ApiResponse(code = 500, message = "The server encountered an unexpected condition that prevented it from fulfilling the request."),
        @ApiResponse(code = 503, message = "The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay"),
        @ApiResponse(code = 200, message = "Unexpected ErrorResponse") })
    @DeleteMapping(
        value = "/users/deleteById"
    )
    default ResponseEntity<Void> _usersDeleteByIdDelete(@NotNull @ApiParam(value = "Delete User By Id", required = true) @Valid @RequestParam(value = "userId", required = true) Integer userId) {
        return usersDeleteByIdDelete(userId);
    }

    // Override this method
    default  ResponseEntity<Void> usersDeleteByIdDelete(Integer userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /users : Get user details
     *
     * @return Success (status code 200)
     *         or Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint. (status code 401)
     *         or Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager. (status code 403)
     *         or The origin server did not find a current representation for the target resource or is not willing to disclose that one exists. (status code 404)
     *         or The method received in the request-line is known by the origin server but not supported by the target resource. (status code 405)
     *         or The server encountered an unexpected condition that prevented it from fulfilling the request. (status code 500)
     *         or The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay (status code 503)
     *         or Unexpected ErrorResponse (status code 200)
     */
    @ApiOperation(value = "Get user details", nickname = "usersGet", notes = "", response = User.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = User.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint."),
        @ApiResponse(code = 403, message = "Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager."),
        @ApiResponse(code = 404, message = "The origin server did not find a current representation for the target resource or is not willing to disclose that one exists."),
        @ApiResponse(code = 405, message = "The method received in the request-line is known by the origin server but not supported by the target resource."),
        @ApiResponse(code = 500, message = "The server encountered an unexpected condition that prevented it from fulfilling the request."),
        @ApiResponse(code = 503, message = "The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay"),
        @ApiResponse(code = 200, message = "Unexpected ErrorResponse") })
    @GetMapping(
        value = "/users",
        produces = { "application/json" }
    )
    default ResponseEntity<List<User>> _usersGet() {
        return usersGet();
    }

    // Override this method
    default  ResponseEntity<List<User>> usersGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"updated_on\" : \"2021-01-30T08:30:00Z\", \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"is_deleted\" : \"is_deleted\", \"city\" : \"city\", \"created_on\" : \"2021-01-30T08:30:00Z\", \"userId\" : 0, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /users/getUserById : Get User details By Id
     *
     * @param userId user id (required)
     * @return Success (status code 200)
     *         or Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint. (status code 401)
     *         or Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager. (status code 403)
     *         or The origin server did not find a current representation for the target resource or is not willing to disclose that one exists. (status code 404)
     *         or The method received in the request-line is known by the origin server but not supported by the target resource. (status code 405)
     *         or The server encountered an unexpected condition that prevented it from fulfilling the request. (status code 500)
     *         or The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay (status code 503)
     *         or Unexpected ErrorResponse (status code 200)
     */
    @ApiOperation(value = "Get User details By Id", nickname = "usersGetUserByIdGet", notes = "", response = User.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = User.class),
        @ApiResponse(code = 401, message = "Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint."),
        @ApiResponse(code = 403, message = "Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager."),
        @ApiResponse(code = 404, message = "The origin server did not find a current representation for the target resource or is not willing to disclose that one exists."),
        @ApiResponse(code = 405, message = "The method received in the request-line is known by the origin server but not supported by the target resource."),
        @ApiResponse(code = 500, message = "The server encountered an unexpected condition that prevented it from fulfilling the request."),
        @ApiResponse(code = 503, message = "The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay"),
        @ApiResponse(code = 200, message = "Unexpected ErrorResponse") })
    @GetMapping(
        value = "/users/getUserById",
        produces = { "application/json" }
    )
    default ResponseEntity<User> _usersGetUserByIdGet(@NotNull @ApiParam(value = "user id", required = true) @Valid @RequestParam(value = "userId", required = true) Integer userId) {
        return usersGetUserByIdGet(userId);
    }

    // Override this method
    default  ResponseEntity<User> usersGetUserByIdGet(Integer userId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"updated_on\" : \"2021-01-30T08:30:00Z\", \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"password\" : \"password\", \"is_deleted\" : \"is_deleted\", \"city\" : \"city\", \"created_on\" : \"2021-01-30T08:30:00Z\", \"userId\" : 0, \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /users/updateUser : update user details
     *
     * @param user User details (required)
     * @return Success (status code 200)
     *         or Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint. (status code 401)
     *         or Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager. (status code 403)
     *         or The origin server did not find a current representation for the target resource or is not willing to disclose that one exists. (status code 404)
     *         or The method received in the request-line is known by the origin server but not supported by the target resource. (status code 405)
     *         or The server encountered an unexpected condition that prevented it from fulfilling the request. (status code 500)
     *         or The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay (status code 503)
     *         or Unexpected ErrorResponse (status code 200)
     */
    @ApiOperation(value = "update user details", nickname = "usersUpdateUserPost", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "Not authenticated. All activities are logged per user, so users must be authenticated before they can call this endpoint."),
        @ApiResponse(code = 403, message = "Not authorized for any data. Note this is not the case if user has a role of Administrator or Manager."),
        @ApiResponse(code = 404, message = "The origin server did not find a current representation for the target resource or is not willing to disclose that one exists."),
        @ApiResponse(code = 405, message = "The method received in the request-line is known by the origin server but not supported by the target resource."),
        @ApiResponse(code = 500, message = "The server encountered an unexpected condition that prevented it from fulfilling the request."),
        @ApiResponse(code = 503, message = "The server is currently unable to handle the request due to a temporary overload or scheduled maintenance, which will likely be alleviated after some delay"),
        @ApiResponse(code = 200, message = "Unexpected ErrorResponse") })
    @PostMapping(
        value = "/users/updateUser",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> _usersUpdateUserPost(@ApiParam(value = "User details" ,required=true )  @Valid @RequestBody User user) {
        return usersUpdateUserPost(user);
    }

    // Override this method
    default  ResponseEntity<Void> usersUpdateUserPost(User user) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
