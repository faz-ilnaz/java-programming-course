package repository.fixture;

import model.Question;

import static repository.fixture.TestConstants.QuestionConstants.QUESTION_ANSWERS;
import static repository.fixture.TestConstants.QuestionConstants.QUESTION_TEXT;

public class TestData {


    public static Question verySimpleQuestion() {
        Question question = new Question();
        question.setText(QUESTION_TEXT);
        question.setAnswers(QUESTION_ANSWERS);
        return question;

    }

}
