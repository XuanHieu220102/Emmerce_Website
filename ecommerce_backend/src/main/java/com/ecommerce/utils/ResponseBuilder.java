package com.ecommerce.utils;

import lombok.experimental.UtilityClass;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@UtilityClass
public class ResponseBuilder {
    public ResponseEntity createErrorResponse (HttpStatus status, String message, String errorDetail) {
        JSONObject resBody = new JSONObject();
        resBody.put("time", new Date());
        resBody.put("message", message);
        resBody.put("error_details", errorDetail);

        return ResponseEntity
                .status(status)
                .body(resBody);
    }

    public ResponseEntity createSuccessResponse (HttpStatus status, String message) {
        JSONObject resBody = new JSONObject();
        resBody.put("time", new Date());
        resBody.put("message", message);

        return ResponseEntity
                .status(status)
                .body(resBody);
    }


}
