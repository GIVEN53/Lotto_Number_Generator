package GIVEN.Lotto.generatedNumber.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class GeneratedNumber { // 생성된 로또 번호

    @Id
    @Column(name = "GENERATED_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int probability; // 당첨번호에 맞은 확률

    private String numbers; // 배열을 String으로 파싱 -> 번호 6개

    // 멤버
}
