package spring_init.spring_init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring_init.spring_init.repository.MemberRepository;
import spring_init.spring_init.repository.MemoryMemberRepository;
import spring_init.spring_init.service.MemberService;

@Configuration
public class SpringConfig {
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
}
