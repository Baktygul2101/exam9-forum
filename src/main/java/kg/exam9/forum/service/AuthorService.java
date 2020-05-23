package kg.exam9.forum.service;

import kg.exam9.forum.dto.AuthorDTO;
import kg.exam9.forum.exception.AuthorAlreadyRegisteredException;
import kg.exam9.forum.exception.AuthorNotFoundException;
import kg.exam9.forum.model.Author;
import kg.exam9.forum.model.AuthorRegisterForm;
import kg.exam9.forum.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;
    private final PasswordEncoder encoder;

    public AuthorDTO register(AuthorRegisterForm form) {
        if (repository.existsByEmail(form.getEmail())) {
            throw new AuthorAlreadyRegisteredException();
        }

        var user = Author.builder()
                .email(form.getEmail())
                .fullname(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        repository.save(user);

        return AuthorDTO.from(user);
    }

    public AuthorDTO getByEmail(String email) {
        var user = repository.findByEmail(email)
                .orElseThrow(AuthorNotFoundException::new);

        return AuthorDTO.from(user);
    }
}
