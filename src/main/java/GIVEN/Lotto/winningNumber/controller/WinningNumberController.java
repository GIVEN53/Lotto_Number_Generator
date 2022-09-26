package GIVEN.Lotto.winningNumber.controller;

import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import GIVEN.Lotto.winningNumber.service.InDhLottery;
import GIVEN.Lotto.winningNumber.service.WinningNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
