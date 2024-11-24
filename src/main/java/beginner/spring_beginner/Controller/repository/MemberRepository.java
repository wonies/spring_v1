package beginner.spring_beginner.Controller.repository;

import java.util.List;
import java.util.Optional;

import beginner.spring_beginner.Controller.domain.Member;

public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
	void clearStore();
}
