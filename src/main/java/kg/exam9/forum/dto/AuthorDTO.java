package kg.exam9.forum.dto;


import kg.exam9.forum.model.Author;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDTO {
    private int id;
    private String fullname;
    private String email;

    public static AuthorDTO from(Author user) {
        return builder()
                .id(user.getId())
                .fullname(user.getFullname())
                .email(user.getEmail())
                .build();
    }
}
