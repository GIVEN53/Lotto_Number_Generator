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
        Map<String, String> map = StringToMap(response);

        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(map.get("drwtNo" + (i+1)));
        }
        WinningNumber winningNumber =
                WinningNumber.builder()
                        .numbers(Arrays.toString(arr))
                        .bonus(Integer.parseInt(map.get("bnusNo")))
                        .date(map.get("drwNoDate"))
                        .round(Integer.parseInt(map.get("drwNo")))
                        .build();

        return winningNumber;
    }

    private Map<String, String> StringToMap(String response) {
        JSONObject json = new JSONObject(response); // API에서 받은 response를 JSON으로 변환
        Map<String, String> map = new HashMap<>();

        Iterator<String> iterator = json.keys();
        while (iterator.hasNext()) {
            String key = iterator.next();
            map.put(key, json.get(key).toString());
        }
        return map;
    }
}
