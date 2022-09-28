package GIVEN.Lotto.winningNumber.controller;

import GIVEN.Lotto.winningNumber.service.WinningNumberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/winning-number")
public class WinningNumberController {

    private final WinningNumberService winningNumberService;

    public WinningNumberController(WinningNumberService winningNumberService) {
        this.winningNumberService = winningNumberService;
    }
}
