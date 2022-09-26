package GIVEN.Lotto.winningNumber.service;

import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import GIVEN.Lotto.winningNumber.repository.WinningNumberRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class WinningNumberService {

    private final WinningNumberRepository winningNumberRepository;


    public WinningNumberService(WinningNumberRepository winningNumberRepository) {
        this.winningNumberRepository = winningNumberRepository;
    }

    private WinningNumber findVerifiedWinningNumber(long winningId) {
        Optional<WinningNumber> optionalWinningNumber = winningNumberRepository.findById(winningId);
        WinningNumber winningNumber =
                optionalWinningNumber.orElseThrow(() -> new RuntimeException());

        return winningNumber;
    }
}
