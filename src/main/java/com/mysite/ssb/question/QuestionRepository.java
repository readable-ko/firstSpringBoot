package com.mysite.ssb.question;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Optional<Question> findBySubjectAndContent(String s, String content);
    List<Question> findBySubjectLike(String str);
    Page<Question> findAll(Pageable pageable);
}
