package kg.exam9.forum.service;

import kg.exam9.forum.dto.AnswerDTO;
import kg.exam9.forum.exception.AuthorNotFoundException;
import kg.exam9.forum.exception.TopicNotFoundException;
import kg.exam9.forum.model.Answer;
import kg.exam9.forum.model.Author;
import kg.exam9.forum.model.Topic;
import kg.exam9.forum.repository.AnswerRepository;
import kg.exam9.forum.repository.AuthorRepository;
import kg.exam9.forum.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final AuthorRepository authorRepository;
    private final TopicRepository topicRepository;



    public List<AnswerDTO> getAnswerByTopicId(Integer id){
        List<Answer> answers = answerRepository.findAllByTopicId(id);
        List<AnswerDTO> listAns = answers.stream().map(AnswerDTO::from).collect(Collectors.toList());
        return listAns;
    }

    public void answer (Integer id, String text, Authentication authentication){

        Topic topic = topicRepository.findById(id).orElseThrow(TopicNotFoundException::new);
        Author author = authorRepository.findByEmail(authentication.getName()).orElseThrow(AuthorNotFoundException::new);

        if(answerRepository.existsByAuthorId(author.getId())){
            Answer answer = Answer.builder().author(author)
                    .topic(topic)
                    .text(text)
                    .build();
            answerRepository.save(answer);
        }
    }


}
