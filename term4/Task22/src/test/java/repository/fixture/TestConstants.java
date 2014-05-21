package repository.fixture;

import model.Answer;

import java.util.Arrays;
import java.util.List;

public interface TestConstants {

    interface QuestionConstants {
        String QUESTION_TEXT = "What is the answer to life the universe and everything";

        List<Answer> QUESTION_ANSWERS = Arrays.asList(new Answer[]{new Answer(1L, "Answer 1"), new Answer(2L, "Answer 2"),
                new Answer(3L, "42", true), new Answer(4L, "Answer 3")});
    }
}
