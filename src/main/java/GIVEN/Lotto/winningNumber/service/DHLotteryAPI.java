package GIVEN.Lotto.winningNumber.service;

import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import GIVEN.Lotto.winningNumber.mapper.WinningNumberMapper;
import GIVEN.Lotto.winningNumber.repository.WinningNumberRepository;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DHLotteryAPI {

    private final WinningNumberRepository winningNumberRepository;
    private final WebClient webClient;

    private final WinningNumberMapper mapper;

    public DHLotteryAPI(WinningNumberRepository winningNumberRepository, WebClient webClient, WinningNumberMapper mapper) {
        this.winningNumberRepository = winningNumberRepository;
        this.webClient = webClient;
        this.mapper = mapper;
    }

    // Todo 스케줄러
    public WinningNumber saveWinningNumber() {
        int round = winningNumberRepository.findTopByOrderByIdDesc().getRound(); // 이전 회차 얻기
        String response = getNumberFromAPI(round + 1); // 현재 회차 정보

        WinningNumber winningNumber = mapper.responseToWinningNumber(response);
        return winningNumberRepository.save(winningNumber);
    }

    // dhlottery API에서 response 얻기
    private String getNumberFromAPI(int round) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("method", "getLottoNumber");
        params.add("drwNo", String.valueOf(round));

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParams(params)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
