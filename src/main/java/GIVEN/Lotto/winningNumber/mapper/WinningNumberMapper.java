package GIVEN.Lotto.winningNumber.mapper;

import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import org.json.JSONObject;
import org.mapstruct.Mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface WinningNumberMapper {

    default WinningNumber responseToWinningNumber(String response) {
        JSONObject json = new JSONObject(response); // API에서 받은 response를 JSON으로 변환

        // 로또 번호 mapping
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = (int) json.get("drwtNo" + (i+1));
        }

        WinningNumber winningNumber =
                WinningNumber.builder()
                        .numbers(Arrays.toString(arr).replace("[", "").replace("]", ""))
                        .bonus((int) json.get("bnusNo"))
                        .date((String) json.get("drwNoDate"))
                        .round((int) json.get("drwNo"))
                        .build();

        return winningNumber;
    }

    // Todo String 번호 6개, 보너스 번호 1개 -> int[]
}
