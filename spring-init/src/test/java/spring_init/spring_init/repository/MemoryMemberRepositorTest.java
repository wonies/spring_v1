package spring_init.spring_init.repository;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;
import static spring_init.spring_init.repository.MemoryMemberRepository.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import spring_init.spring_init.domain.Member;

public class MemoryMemberRepositorTest {
	MemberRepository repository = new MemoryMemberRepository();

	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}

	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		repository.save(member);
		Member res = repository.findById(member.getId()).get();

		// System.out.println("result: " + (res == member));
		assertEquals(member, res);
		assertThat(member).isEqualTo(res);
	}

	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		Member res = repository.findByName("spring1").get();
		assertThat(res).isEqualTo(member1);
	}

	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		List<Member> res = repository.findAll();
		assertThat(res.size()).isEqualTo(2);
	}

}
