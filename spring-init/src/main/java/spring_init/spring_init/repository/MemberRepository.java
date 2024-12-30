package spring_init.spring_init.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;

import spring_init.spring_init.domain.Member;

public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
	void clearStore();
}
