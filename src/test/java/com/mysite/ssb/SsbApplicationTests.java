package com.mysite.ssb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mysite.ssb.answer.Answer;
import com.mysite.ssb.answer.AnswerRepository;
import com.mysite.ssb.question.Question;
import com.mysite.ssb.question.QuestionRepository;
import com.mysite.ssb.question.QuestionService;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SsbApplicationTests {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void contextLoads() {
        for (int i = 20 ; i < 100 ; i++) {
            String subject = String.format("테스트 데이터입니다.[%03d]", i);
            String content = "이 땅에 영광 있으리라";
            this.questionService.create(subject, content, null);
        }
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        List<Answer> answers = q.getAnswerList();
//        assertEquals(1, answers.size());
//        assertEquals("네 자동으로 생성 됩니다.", answers.get(0).getContent());
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성 됩니다.");
//        a.setQuestion(q);
//        a.setCreatedDate(LocalDateTime.now());
//        this.answerRepository.save(a);


//        Question q1 = new Question();
//        q1.setSubject("sbb가 뭔데");
//        q1.setContent("알려줄 사람?");
//        q1.setCreatedDate(LocalDateTime.now());
//        this.questionRepository.save(q1);
//
//        Question q2 = new Question();
//        q2.setSubject("알빠노 ㅋㅋ");
//        q2.setContent("spring boot board 줄임말이다 임마");
//        q2.setCreatedDate(LocalDateTime.now());
//        this.questionRepository.save(q2);
    }

}
