package beginner.spring_beginner.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beginner.spring_beginner.Controller.domain.Member;
import beginner.spring_beginner.Controller.repository.MemberRepository;
import beginner.spring_beginner.Controller.repository.MemoryMemberRepository;


public class MemberService {
	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	//회원가입
	public Long join(Member member)
	{
		// 같은 이름이 있는 중복회원
		validateDuplicateMember(member);
		Member save = memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m->{
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	//전체 회원 조회
	public List<Member> findMembers()
	{
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId)
	{
		return memberRepository.findById(memberId);
	}
}
