package com.mysite.ssb.question;
import com.mysite.ssb.DataNotFoundException;

import com.mysite.ssb.user.SiteUser;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getQuestions() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(int id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        }
        else {
            throw new DataNotFoundException("question not found");
        }
    }

    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createdDate"));
        Pageable pageable = PageRequest.of(page, 7, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    public void create(String subject, String content, SiteUser author) {
        Question question = Question.builder()
                .subject(subject)
                .content(content)
                .createdDate(LocalDateTime.now())
                .author(author)
                .build();
        this.questionRepository.save(question);
    }

    public void modify(Question question, String subject, String content) {
        Question updatedQuestion = question.toBuilder()
                .subject(subject)
                .content(content)
                .modifiedDate(LocalDateTime.now())
                .build();
        this.questionRepository.save(updatedQuestion);
    }

    public void delete(Question question) {
        this.questionRepository.delete(question);
    }
}
