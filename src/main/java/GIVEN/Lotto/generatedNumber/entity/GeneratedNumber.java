package GIVEN.Lotto.generatedNumber.entity;

import GIVEN.Lotto.audit.CreateOnlyAuditable;
import GIVEN.Lotto.member.entity.Member;
import GIVEN.Lotto.probability.entity.Probability;
import GIVEN.Lotto.winningNumber.entity.WinningNumber;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratedNumber extends CreateOnlyAuditable { // 생성된 로또 번호

    @Id
    @Column(name = "GENERATED_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numbers; // 배열을 String으로 파싱 -> 번호 7개

    @ManyToOne
    @JoinColumn(name = "ROUND", nullable = false)
    private WinningNumber winningNumber;

    // @OneToMany 하기 위함, 외래키만 관리하고 null
    @ManyToOne
    @JoinColumn(name = "PROBABILITY_ID")
    private Probability probability;

    @OneToOne(mappedBy = "generatedNumber")
    private Member member;
}
