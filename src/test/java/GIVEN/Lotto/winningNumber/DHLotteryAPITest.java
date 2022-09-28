package GIVEN.Lotto.winningNumber;

import GIVEN.Lotto.helper.StubData;
import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import GIVEN.Lotto.winningNumber.repository.WinningNumberRepository;
import GIVEN.Lotto.winningNumber.service.DHLotteryAPI;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class DHLotteryAPITest {

    @Autowired
    private DHLotteryAPI dhLotteryAPI;

//    @MockBean
    @Autowired
    private WinningNumberRepository winningNumberRepository;

    @DisplayName("apiWinningNumber Method Test")
    @Test
    public void lotteryAPITest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int round = 1034;

        // private 메서드 사용
        Method getNumberFromAPI = dhLotteryAPI.getClass().getDeclaredMethod("getNumberFromAPI", int.class);
        getNumberFromAPI.setAccessible(true);
        String response = getNumberFromAPI.invoke(dhLotteryAPI, round).toString();

        // json으로 파싱
        JSONObject json = new JSONObject(response);

        assertThat((int) json.get("drwNo"), is(equalTo(round)));
        assertThat(json.get("drwNoDate"), is(equalTo("2022-09-24")));
        assertThat((int) json.get("bnusNo"), is(equalTo(11)));
    }

    @DisplayName("saveWinningNumber Method Test")
    @Test
    @Transactional
    public void saveWinningNumberTest() {
        winningNumberRepository.save(StubData.MockNumber.getWinningNumber(1033)); // 이전 회차정보 미리 저장
        WinningNumber winningNumber = dhLotteryAPI.saveWinningNumber();

        assertThat(winningNumber.getRound(), is(1034));
    }

}
