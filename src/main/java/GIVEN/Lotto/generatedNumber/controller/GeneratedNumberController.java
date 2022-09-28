package GIVEN.Lotto.generatedNumber.controller;

import GIVEN.Lotto.generatedNumber.entity.GeneratedNumber;
import GIVEN.Lotto.generatedNumber.service.GeneratedNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generated-number")
public class GeneratedNumberController {
    private final GeneratedNumberService generatedNumberService;

    public GeneratedNumberController(GeneratedNumberService generatedNumberService) {
        this.generatedNumberService = generatedNumberService;
    }

    @GetMapping
    public ResponseEntity GenerateNumber() {
        GeneratedNumber number = generatedNumberService.createRandomNumber();

        return new ResponseEntity<>(number, HttpStatus.OK);
    }
}
