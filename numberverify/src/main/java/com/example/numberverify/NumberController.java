package com.example.numberverify;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/validate-number")

public class NumberController {
    private final NumberService numberService;

    @PostMapping
    public ResponseEntity<NumberResponse> validate (@RequestBody NumRequest request) throws Exception {
        return numberService.validate(request.number());
    }
}
