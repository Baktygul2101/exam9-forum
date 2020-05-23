package kg.exam9.forum.dto;


import kg.exam9.forum.model.Answer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AnswerDTO {

    private int id;
    private TopicDTO topic;
    private AuthorDTO author;
    private String text;
    private LocalDateTime date;


    public static AnswerDTO from(Answer answer){
        return AnswerDTO.builder()
                .id(answer.getId())
                .topic(TopicDTO.from(answer.getTopic()))
                .author(AuthorDTO.from(answer.getAuthor()))
                .text(answer.getText())
                .date(answer.getDate())
                .build();
    }
}
