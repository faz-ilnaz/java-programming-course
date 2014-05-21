package service;

import model.Question;

import java.math.BigInteger;

public interface QuestionService {
    Question getQuestionById(BigInteger id);
}
