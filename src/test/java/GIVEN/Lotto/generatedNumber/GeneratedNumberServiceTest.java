package GIVEN.Lotto.generatedNumber;

import GIVEN.Lotto.generatedNumber.entity.GeneratedNumber;
import GIVEN.Lotto.generatedNumber.repository.GeneratedNumberRepository;
import GIVEN.Lotto.generatedNumber.service.GeneratedNumberService;
import GIVEN.Lotto.helper.StubData;
import GIVEN.Lotto.winningNumber.repository.WinningNumberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class GeneratedNumberServiceTest {

    @Autowired
    private GeneratedNumberService generatedNumberService;

    @Autowired
    private GeneratedNumberRepository generatedNumberRepository;

    @Autowired
    private WinningNumberRepository winningNumberRepository;

    @Test
    public void createRandomNumberTest() {
        winningNumberRepository.save(StubData.MockNumber.getWinningNumber(1034)); // 현재 회차정보 미리 저장

        GeneratedNumber generatedNumber = generatedNumberService.createRandomNumber();
        System.out.println(generatedNumber.getNumbers());
        System.out.println(generatedNumber.getCreatedAt());
    }

    // Todo modify
    @Test
    public void findGeneratedNumberTest() {
        long numberId = 1L;

        generatedNumberRepository.save(StubData.MockNumber.getGeneratedNumber(numberId)); // 생성 번호 미리 저장

        GeneratedNumber generatedNumber = generatedNumberService.findGeneratedNumber(numberId);
    }
}
