package com.pkr.project.notice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    @Operation(
        summary = "Greet the user",
        description = "Returns a greeting message for the user",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved greeting"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
        }
    )
    public String greeting(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
}