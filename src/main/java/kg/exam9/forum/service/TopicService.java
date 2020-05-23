package kg.exam9.forum.service;


import kg.exam9.forum.dto.TopicDTO;
import kg.exam9.forum.model.Topic;
import kg.exam9.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository repository;

    public Topic saveTopic(Topic topic){
        return repository.save(topic);
    }

    public Page<TopicDTO> getAll(Pageable pageable){
        return repository.findAll(pageable).map(TopicDTO::from);
    }


    public Optional<TopicDTO> getTopicById(int id){
        return repository.findById(id).map(TopicDTO::from);
    }

    public Topic getTopicByName(String name){
        return repository.findByName(name);
    }


    public String deleteTopic(int id){
        repository.deleteById(id);
        return "topic removed!!"+id;
    }

    public Topic updateTopic(Topic topic){
        Topic existingProduct=repository.findById(topic.getId()).orElse(null);
        existingProduct.setName(topic.getName());
        existingProduct.setDescription(topic.getDescription());
        existingProduct.setDate(topic.getDate());
        return repository.save(existingProduct);
    }



    public Page<TopicDTO> getAllByAuthorId(Integer id, Pageable pageable){
        return repository.findAllByAuthorId(id, pageable).map(TopicDTO::from);
    }

    public Page<TopicDTO> search(String name, String description, Pageable pageable){
        return repository.findAllByNameContainingOrDescriptionContaining(name, description, pageable)
                .map(TopicDTO::from);
    }



}

