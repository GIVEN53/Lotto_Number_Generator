package GIVEN.Lotto.generatedNumber.service;

import GIVEN.Lotto.generatedNumber.entity.GeneratedNumber;
import GIVEN.Lotto.generatedNumber.repository.GeneratedNumberRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class GeneratedNumberService {

    private final GeneratedNumberRepository generatedNumberRepository;
    private final Random random;

    public GeneratedNumberService(GeneratedNumberRepository generatedNumberRepository, Random random) {
        this.generatedNumberRepository = generatedNumberRepository;
        this.random = random;
    }

    public GeneratedNumber generateRandomNumber() { // 7개의 번호 생성
        GeneratedNumber generatedNumber = new GeneratedNumber();
        int[] arr = new int[7];

        for (int i = 0; i < 7; i++) {
            arr[i] = random.nextInt(45)+1;
            if (deduplication(arr, i)) {
                i--;
            }
        }
        Arrays.sort(arr);

        generatedNumber.setNumbers(Arrays.toString(arr));
        return generatedNumberRepository.save(generatedNumber);
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
}
