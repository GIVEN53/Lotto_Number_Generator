package GIVEN.Lotto.generatedNumber.mapper;

import org.mapstruct.Mapper;

import java.util.Arrays;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface GeneratedNumberMapper {

    default String arrayToStringNumbers(int[] arr) {
        return Arrays.toString(arr).replace("[", "").replace("]", "");
    }

    default int[] stringNumbersToArray(String numbers) {
        int[] arr = Stream.of(numbers.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        return arr;
    }
}
