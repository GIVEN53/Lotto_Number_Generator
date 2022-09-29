package GIVEN.Lotto.member.service;

import GIVEN.Lotto.generatedNumber.entity.GeneratedNumber;
import GIVEN.Lotto.generatedNumber.service.GeneratedNumberService;
import GIVEN.Lotto.member.entity.Member;
import GIVEN.Lotto.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final GeneratedNumberService generatedNumberService;

    public MemberService(MemberRepository memberRepository, GeneratedNumberService generatedNumberService) {
        this.memberRepository = memberRepository;
        this.generatedNumberService = generatedNumberService;
    }

    public Member createMember(Member member) {
        // Todo
        return null;
    }

    public Member createGeneratedNumber(long memberId) {
        Member member = findMember(memberId);

        GeneratedNumber generatedNumber = generatedNumberService.saveGeneratedNumber(member.getGeneratedNumber());
        member.setGeneratedNumber(generatedNumber);
        return memberRepository.save(member);
    }

    public Member findMember(long memberId) {
        return findVerifiedMember(memberId);
    }

    private Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(() -> new RuntimeException());
        return findMember;
    }
}
