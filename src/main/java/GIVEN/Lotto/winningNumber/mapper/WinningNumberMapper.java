package GIVEN.Lotto.winningNumber.mapper;

import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import org.json.JSONObject;
import org.mapstruct.Mapper;

import java.util.Arrays;

@Mapper(componentModel = "spring")
public interface WinningNumberMapper {

    default WinningNumber responseToWinningNumber(String response) {
        // API에서 받은 response를 JSON으로 파싱
        JSONObject json = new JSONObject(response);

        // 로또 번호 mapping
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = (int) json.get("drwtNo" + (i+1));
        }

        WinningNumber winningNumber =
                WinningNumber.builder()
                        .round((int) json.get("drwNo"))
                        .numbers(Arrays.toString(arr).replace("[", "").replace("]", ""))
                        .bonusNumber((int) json.get("bnusNo"))
                        .date((String) json.get("drwNoDate"))
                        .firstWinAmount((Long) json.get("firstWinamnt"))
                        .build();

        return winningNumber;
    }

    // Todo String 번호 6개, 보너스 번호 1개 -> int[]
}
