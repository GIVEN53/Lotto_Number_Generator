package GIVEN.Lotto.generatedNumber.service;

import GIVEN.Lotto.generatedNumber.entity.GeneratedNumber;
import GIVEN.Lotto.generatedNumber.mapper.GeneratedNumberMapper;
import GIVEN.Lotto.generatedNumber.repository.GeneratedNumberRepository;
import GIVEN.Lotto.member.service.MemberService;
import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import GIVEN.Lotto.winningNumber.service.WinningNumberService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

@Service
public class GeneratedNumberService {

    private final GeneratedNumberRepository generatedNumberRepository;

    private final WinningNumberService winningNumberService;

    private final GeneratedNumberMapper mapper;
    private final Random random;

    public GeneratedNumberService(GeneratedNumberRepository generatedNumberRepository,
                                  WinningNumberService winningNumberService,
                                  GeneratedNumberMapper mapper,
                                  Random random) {
        this.generatedNumberRepository = generatedNumberRepository;
        this.winningNumberService = winningNumberService;
        this.mapper = mapper;
        this.random = random;
    }

    // 7개의 번호 생성
    public GeneratedNumber saveGeneratedNumber(GeneratedNumber prevGeneratedNumber) {
        WinningNumber curWinningNumber = winningNumberService.findCurrentWinningNumber();
        int[] arr = generateRandomNumber();

        // 이전 생성 번호 삭제 -> 한 멤버 당 하나의 번호만 생성할 수 있음
        if (prevGeneratedNumber != null) {
            deleteGeneratedNumber(prevGeneratedNumber.getId());
        }

        // 새로운 번호 생성
        GeneratedNumber generatedNumber = GeneratedNumber.builder()
                .numbers(mapper.arrayToStringNumbers(arr))
                .winningNumber(curWinningNumber)
                .build();

        return generatedNumberRepository.save(generatedNumber);
    }

    public void deleteGeneratedNumber(long numberId) {
        GeneratedNumber findGeneratedNumber = findVerifiedNumber(numberId);

        generatedNumberRepository.delete(findGeneratedNumber);
    }

    // Todo Modify Exception
    private GeneratedNumber findVerifiedNumber(long numberId) {
        Optional<GeneratedNumber> optionalNumber = generatedNumberRepository.findById(numberId);
        GeneratedNumber findGeneratedNumber = optionalNumber.orElseThrow(() -> new RuntimeException());

        return findGeneratedNumber;
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
}
