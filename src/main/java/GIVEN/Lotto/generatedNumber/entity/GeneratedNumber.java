package GIVEN.Lotto.generatedNumber.entity;

import GIVEN.Lotto.audit.CreateOnlyAuditable;
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

    private String numbers; // 배열을 String으로 파싱 -> 번호 7개

    private int round;

    // Todo Member
}
