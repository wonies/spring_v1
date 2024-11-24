package beginner.spring_beginner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import beginner.spring_beginner.Controller.domain.Member;
import beginner.spring_beginner.Controller.repository.MemberRepository;
import beginner.spring_beginner.Controller.repository.MemoryMemberRepository;
import beginner.spring_beginner.Service.MemberService;

@Configuration
public class SpringConfig {

	@Bean
	public MemberService memberService()
	{
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository()
	{
		return new MemoryMemberRepository();
	}
}
