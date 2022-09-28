package GIVEN.Lotto.generatedNumber.service;

import GIVEN.Lotto.generatedNumber.entity.GeneratedNumber;
import GIVEN.Lotto.generatedNumber.mapper.GeneratedNumberMapper;
import GIVEN.Lotto.generatedNumber.repository.GeneratedNumberRepository;
import GIVEN.Lotto.winningNumber.repository.WinningNumberRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

@Service
public class GeneratedNumberService {

    private final GeneratedNumberRepository generatedNumberRepository;

    private final WinningNumberRepository winningNumberRepository;

    private final GeneratedNumberMapper mapper;
    private final Random random;

    public GeneratedNumberService(GeneratedNumberRepository generatedNumberRepository, WinningNumberRepository winningNumberRepository, GeneratedNumberMapper mapper, Random random) {
        this.generatedNumberRepository = generatedNumberRepository;
        this.winningNumberRepository = winningNumberRepository;
        this.mapper = mapper;
        this.random = random;
    }

    // 7개의 번호 생성
    public GeneratedNumber createRandomNumber() {
        int[] arr = generateRandomNumber();
        int round = winningNumberRepository.findTopByOrderByIdDesc().getRound(); // 현재 회차

        GeneratedNumber generatedNumber = GeneratedNumber.builder()
                .numbers(mapper.arrayToStringNumbers(arr))
                .round(round)
                .build();

        return generatedNumberRepository.save(generatedNumber);
    }

    // Todo modify parameter MemberId
    public GeneratedNumber findGeneratedNumber(long generatedNumberId) {
        GeneratedNumber generatedNumber = findVerifiedNumber(generatedNumberId);
        System.out.println(Arrays.toString(mapper.stringNumbersToArray(generatedNumber.getNumbers())));
        return generatedNumber;
    }

    private int[] generateRandomNumber() {
        int[] arr = new int[7];

        for (int i = 0; i < 7; i++) {
            arr[i] = random.nextInt(45)+1;
            if (deduplication(arr, i)) {
                i--;
            }
        }
        Arrays.sort(arr);
        return arr;
    }

    // 중복 검사
    private boolean deduplication(int[] arr, int targetIdx) {
        for (int j = 0; j < targetIdx; j++) {
            if (arr[targetIdx] == arr[j]) {
                return true;
            }
        }
        return false;
    }

    // Todo Modify
    private GeneratedNumber findVerifiedNumber(long generatedNumberId) {
        Optional<GeneratedNumber> optionalNumber = generatedNumberRepository.findById(generatedNumberId);
        GeneratedNumber generatedNumber = optionalNumber.orElseThrow(() -> new RuntimeException());

        return generatedNumber;
    }
}
