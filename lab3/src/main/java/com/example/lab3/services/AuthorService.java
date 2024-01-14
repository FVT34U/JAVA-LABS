package com.example.lab3.services;

import com.example.lab3.models.AuthorEntity;
import com.example.lab3.models.dto.AuthorRequest;
import com.example.lab3.repositories.AuthorRepository;
import com.example.lab3.utils.ObjectToDomTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;
import java.util.UUID;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final ObjectMapper objectMapper;

    private final AuthorRepository authorRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(authorRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(AuthorRequest directorRequest){
        AuthorEntity author = new AuthorEntity(randomUUID(), directorRequest.getName());
        authorRepository.save(author);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID authorID) {
        authorRepository.deleteById(authorID);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public String getAuthors(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("authors");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<AuthorEntity> authors = authorRepository.findAll();
        for (AuthorEntity author : authors) {

            transformer.transform(element, author, "author");
        }

        model.addAttribute("authors", element);
        return "authors";
    }

}
