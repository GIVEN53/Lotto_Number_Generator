package GIVEN.Lotto.generatedNumber.repository;

import GIVEN.Lotto.generatedNumber.entity.GeneratedNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneratedNumberRepository extends JpaRepository<GeneratedNumber, Long> {
}
