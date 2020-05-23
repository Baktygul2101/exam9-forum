package kg.exam9.forum.dto;

import kg.exam9.forum.model.Topic;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TopicDTO {
    public static TopicDTO from(Topic topic){
        return TopicDTO.builder()
                .id(topic.getId())
                .name(topic.getName())
                .description(topic.getDescription())
                .date(topic.getDate())
                .author(AuthorDTO.from(topic.getAuthor()))
                .qtyAnswer(topic.getQtyAnswer())
                .build();
    }

    private Integer id;
    private String name;
    private String description;
    private LocalDateTime date;
    private AuthorDTO author;
    private int qtyAnswer;
}
