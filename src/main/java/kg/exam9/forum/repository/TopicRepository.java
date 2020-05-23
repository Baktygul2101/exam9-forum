package kg.exam9.forum.repository;


import kg.exam9.forum.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Topic findByName(String name);


    Page<Topic> findAllByAuthorId(Integer authorId, Pageable pageable);

    Page<Topic> findAllByNameContainingOrDescriptionContaining(String name, String description, Pageable pageable);
}
