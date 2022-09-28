package GIVEN.Lotto.helper;

import GIVEN.Lotto.generatedNumber.entity.GeneratedNumber;
import GIVEN.Lotto.winningNumber.entity.WinningNumber;

import java.util.Arrays;

public class StubData {

    public static class MockNumber {
        public static WinningNumber getWinningNumber(int round) {
            int[] arr = {26, 31, 32, 33, 38, 40};

            WinningNumber winningNumber =
                    WinningNumber.builder()
                            .id(1L)
                            .round(round)
                            .date("2022-09-24")
                            .numbers(Arrays.toString(arr).replace("[", "").replace("]", ""))
                            .bonus(11)
                            .build();

            return winningNumber;
        }

        // Todo modify parameter
        public static GeneratedNumber getGeneratedNumber(long id) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7};

            GeneratedNumber generatedNumber =
                    GeneratedNumber.builder()
                            .id(id)
                            .numbers(Arrays.toString(arr).replace("[", "").replace("]", ""))
                            .round(1034)
                            .build();

            return generatedNumber;
        }
    }
}
