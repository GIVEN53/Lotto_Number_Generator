package GIVEN.Lotto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;

@Configuration
public class AppConfig {

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create("https://www.dhlottery.co.kr/common.do");
    }
}
