package GIVEN.Lotto.member.entity;

import GIVEN.Lotto.audit.Auditable;
import GIVEN.Lotto.generatedNumber.entity.GeneratedNumber;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends Auditable {

    @Id
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "GENERATED_ID")
    private GeneratedNumber generatedNumber;
}
