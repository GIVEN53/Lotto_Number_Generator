package GIVEN.Lotto.generatedNumber.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratedNumber { // 생성된 로또 번호

    @Id
    @Column(name = "GENERATED_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numbers; // 배열을 String으로 파싱 -> 번호 7개

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private int round;

    // 멤버
}
