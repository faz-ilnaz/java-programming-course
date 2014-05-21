package model;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.util.List;

public class Question {

    @Id
    private BigInteger id;
    private String text;
    private List<Answer> answers;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
