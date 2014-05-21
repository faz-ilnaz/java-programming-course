package service.impl;

import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.QuestionRepository;
import service.QuestionService;

import java.math.BigInteger;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    @Transactional
    public Question getQuestionById(BigInteger id) {
        return questionRepository.findOne(id);
    }
}
