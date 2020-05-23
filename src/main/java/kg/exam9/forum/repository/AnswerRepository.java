package kg.exam9.forum.repository;

import kg.exam9.forum.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    
    List<Answer> findAllByTopicId(Integer id);

    boolean existsByAuthorId(Integer id);
}