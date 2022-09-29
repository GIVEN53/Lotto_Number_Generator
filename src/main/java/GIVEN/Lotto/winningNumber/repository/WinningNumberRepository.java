package GIVEN.Lotto.winningNumber.repository;

import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WinningNumberRepository extends JpaRepository<WinningNumber, Integer> {

    WinningNumber findTopByOrderByRoundDesc();
    Optional<WinningNumber> findByRound(int round);
}
