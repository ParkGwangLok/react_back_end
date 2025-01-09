package com.pkr.project.notice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "ExampleController", description = "예제 컨트롤러")
public class ExampleController {

    @GetMapping("/example")
    @Operation(summary = "예제 엔드포인트", description = "예제 엔드포인트에 대한 자세한 설명")
    public String exampleEndpoint() {
        return "Hello, Swagger!";
    }
}