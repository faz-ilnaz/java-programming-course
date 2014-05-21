package repository;

import model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface QuestionRepository extends MongoRepository<Question, BigInteger>{
}
