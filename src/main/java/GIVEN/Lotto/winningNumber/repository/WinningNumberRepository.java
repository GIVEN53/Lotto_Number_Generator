package GIVEN.Lotto.winningNumber.repository;

import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WinningNumberRepository extends JpaRepository<WinningNumber, Long> {
}
