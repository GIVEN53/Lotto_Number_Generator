package GIVEN.Lotto.winningNumber.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class WinningNumber { // 토요일마다 당첨된 로또 번호

    @Id
    @Column(name = "WINNING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final int round; // 회차

    private final Date date; // 날짜

    private final String numbers; // DTO에서 배열로 받고 String으로 파싱 -> 번호 6개

    private final int bonus; // 보너스 번호
}
