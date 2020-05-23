package kg.exam9.forum.controller;


import kg.exam9.forum.dto.AnswerDTO;
import kg.exam9.forum.exception.ResourceNotFoundException;
import kg.exam9.forum.model.Topic;
import kg.exam9.forum.repository.TopicRepository;
import kg.exam9.forum.service.AnswerService;
import kg.exam9.forum.service.PropertiesService;
import kg.exam9.forum.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
class AnswerController {


    private final PropertiesService propertiesService;
    private final TopicService topicService;
    private final AnswerService answerService;
    private final TopicRepository topicRepository;

    @GetMapping("/topics/{id}/answers")
    public String answers(@PathVariable String id, Model model){
        List<AnswerDTO> answers = answerService.getAnswerByTopicId(Integer.parseInt(id));
        if(!answers.isEmpty()){
            model.addAttribute("items", answers);
        }
        Optional<Topic> topic = topicRepository.findById(Integer.parseInt(id));
        model.addAttribute("topic", topic);
        return "answer";
    }

    @PostMapping("/answers/{id}")
    public String review(@PathVariable Integer id, @RequestParam String text, Authentication authentication){

        answerService.answer(id, text, authentication);

        return "redirect:/topics/{id}/answers";
    }

      

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {

        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }
}
