package GIVEN.Lotto.winningNumber.service;

import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import GIVEN.Lotto.winningNumber.repository.WinningNumberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WinningNumberService {

    private final WinningNumberRepository winningNumberRepository;


    public WinningNumberService(WinningNumberRepository winningNumberRepository) {
        this.winningNumberRepository = winningNumberRepository;
    }

    // 현재 회차정보
    public WinningNumber findCurrentWinningNumber() {
        return winningNumberRepository.findTopByOrderByRoundDesc(); // 현재 회차정보
    }

    // 원하는 회차정보 찾을 때
    public WinningNumber findWinningNumber(int round) {
        return findVerifiedWinningNumber(round);
    }

    private WinningNumber findVerifiedWinningNumber(int round) {
        Optional<WinningNumber> optionalWinningNumber = winningNumberRepository.findByRound(round);
        WinningNumber winningNumber =
                optionalWinningNumber.orElseThrow(() -> new RuntimeException());

        return winningNumber;
    }
}
