package com.mysite.ssb.answer;

import com.mysite.ssb.question.Question;
import com.mysite.ssb.user.SiteUser;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdDate;

    @ManyToOne
    private Question question;

    @ManyToOne
    private SiteUser author;

    @Column
    private LocalDateTime modifiedDate;
}
