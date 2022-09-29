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
    private int round; // 회차

    @Column(nullable = false, updatable = false)
    private String numbers; // 로또 번호 6개 String으로 파싱

    @Column(nullable = false, updatable = false)
    private int bonusNumber; // 보너스 번호 1개

    @Column(nullable = false, updatable = false, unique = true)
    private String date; // 날짜

    @Column(nullable = false, updatable = false)
    private long firstWinAmount; // 당첨금
}
