package GIVEN.Lotto.winningNumber.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WinningNumber { // 토요일마다 당첨된 로또 번호

    @Id
    @Column(name = "WINNING_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int round; // 회차

    private String date; // 날짜

    private String numbers; // 로또 번호 6개 String으로 파싱

    private int bonus; // 보너스 번호 1개
}
