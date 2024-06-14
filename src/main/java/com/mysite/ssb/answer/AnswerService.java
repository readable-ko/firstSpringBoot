package com.mysite.ssb.answer;

import com.mysite.ssb.question.Question;
import com.mysite.ssb.user.SiteUser;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreatedDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        answerRepository.save(answer);
    }
}
