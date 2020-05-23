package kg.exam9.forum.controller;


import kg.exam9.forum.dto.TopicDTO;
import kg.exam9.forum.exception.ResourceNotFoundException;
import kg.exam9.forum.model.Topic;
import kg.exam9.forum.repository.TopicRepository;
import kg.exam9.forum.service.PropertiesService;
import kg.exam9.forum.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class TopicController {

    private final TopicService topicService;
    private final PropertiesService propertiesService;
    private final TopicRepository repo;

    @GetMapping
    public String main(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var topics = topicService.getAll(pageable);
        String uri = uriBuilder.getRequestURI();
        PropertiesService.constructPageable(topics, propertiesService.getDefaultPageSize(), model, uri);
        return "index";
    }

    @RequestMapping("/topics")
    public String getTopics(Model model) {
        model.addAttribute("topics", repo.findAll());
        return "topics";
    }
    @GetMapping("/addTopic")
    public String addition() {
        return "addTopic";
    }

    @PostMapping("/addTopic")
    public String formPost(Topic topic, Model model) {
        model.addAttribute("topic",topic);
        topicService.saveTopic(topic);
        return "result";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTopic(@PathVariable Integer id, Model model) {
        model.addAttribute("id",id);
        topicService.deleteTopic(id);
        return "result";
    }


    @RequestMapping("/topic/{id}")
    public String getTopicById(@PathVariable Integer id, Model model) {
        model.addAttribute("product", topicService.getTopicById(id));
        return "topic";
    }



    @GetMapping("/search={text}")
    public List<TopicDTO> search(@PathVariable String text, Pageable pageable){
        return topicService.search(text, text, pageable).getContent();
    }
    @GetMapping("/id={authorId}")
    public List<TopicDTO> getTopicsByAuthorId(@PathVariable String authorId, Pageable pageable){
        return topicService.getAllByAuthorId(Integer.parseInt(authorId), pageable).getContent();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {

        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }

}
