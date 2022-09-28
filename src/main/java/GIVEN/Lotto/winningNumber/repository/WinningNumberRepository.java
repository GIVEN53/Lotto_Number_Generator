package GIVEN.Lotto.winningNumber.repository;

import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WinningNumberRepository extends JpaRepository<WinningNumber, Long> {

    WinningNumber findTopByOrderByIdDesc();

    Optional<WinningNumber> findByRound(int round);
}
