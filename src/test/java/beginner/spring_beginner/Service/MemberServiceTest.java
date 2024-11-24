package beginner.spring_beginner.Service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beginner.spring_beginner.Controller.domain.Member;
import beginner.spring_beginner.Controller.repository.MemoryMemberRepository;

class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;

	@BeforeEach
	public void beforeEach()
	{
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}


	@AfterEach
	public void afterEach()
	{
		memberRepository.clearStore(); // 돌때마다 메모리가 클리어됨!
	}

	@Test
	void 회원가입() {
		//given (이 데이터를 기반으로)
		Member member = new Member();
		member.setName("spring");
		//when (어떤것을 검증하는 지)
		Long saveId = memberService.join(member);
		//then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());


		// 정상 flow
	}

	@Test
	public void 중복_회원_예외()
	{
		//given
		Member member1 = new Member();
		Member member2 = new Member();
		member1.setName("spring");
		member2.setName("spring");
		//when
		memberService.join(member1);
		// assertThrows(IllegalStateException.class, ()->memberService.join(member2));
		IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

		// try{
		// 	memberService.join(member2);
		// 	// fail();
		// } catch (IllegalStateException e)
		// {
		// 	assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		// }

		//then

	}




	@Test
	void findMembers() {
	}

	@Test
	void findOne() {
	}
}