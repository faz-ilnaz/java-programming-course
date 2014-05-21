package repository;

import config.PersistenceTestConfig;
import model.Answer;
import model.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static repository.fixture.TestConstants.QuestionConstants.QUESTION_ANSWERS;
import static repository.fixture.TestConstants.QuestionConstants.QUESTION_TEXT;
import static repository.fixture.TestData.verySimpleQuestion;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class})
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void testFindAll() {
        Question question = verySimpleQuestion();
        questionRepository.save(question);
        Iterable<Question> questions = questionRepository.findAll();
        assertNotNull(questions);
        assertTrue(questions.iterator().hasNext());
        for (Question q : questions) {
            assertNotNull(q);
            assertNotNull(q.getId());
            assertNotNull(q.getAnswers());
            assertTrue(q.getAnswers().iterator().hasNext());
        }
        questionRepository.deleteAll();
    }

    @Test
    public void testCRUD() {
        Question question = verySimpleQuestion();
        questionRepository.save(question);
        question = questionRepository.findOne(question.getId());
        assertEquals(question.getText(), QUESTION_TEXT);
        List<Answer> answers = questionRepository.findOne(question.getId()).getAnswers();
        for(Answer a : answers) {
            assertTrue(QUESTION_ANSWERS.contains(a));
        }
        question.setText("another question");
        questionRepository.save(question);
        assertEquals(questionRepository.findOne(question.getId()).getText(), "another question");
        questionRepository.delete(question);
        assertNull(questionRepository.findOne(question.getId()));
    }

}
