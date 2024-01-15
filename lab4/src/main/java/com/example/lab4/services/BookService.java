package com.example.lab4.services;

import com.example.lab4.models.AuditEvent;
import com.example.lab4.models.AuthorEntity;
import com.example.lab4.models.BookEntity;
import com.example.lab4.models.dto.BookRequest;
import com.example.lab4.repositories.BookRepository;
import com.example.lab4.utils.EventLogger;
import com.example.lab4.utils.ObjectToDomTransformer;
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
public class BookService {

    private final ObjectMapper objectMapper;

    private final BookRepository bookRepository;

    private final EventLogger eventLogger;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(bookRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(BookRequest bookRequest){
        BookEntity book = new BookEntity(randomUUID(), bookRequest.getTitle(), bookRequest.getLitGenre(), bookRequest.getAuthorID());
        eventLogger.log(book, AuditEvent.CREATE);
        bookRepository.save(book);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID bookID) {
        BookEntity bookEntity = new BookEntity(bookID, bookRepository.getReferenceById(bookID).getTitle(),
                bookRepository.getReferenceById(bookID).getLitGenre(),
                bookRepository.getReferenceById(bookID).getAuthorID());
        eventLogger.log(bookEntity, AuditEvent.DELETE);
        bookRepository.deleteById(bookID);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public String getBooks(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("books");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<BookEntity> books = bookRepository.findAll();
        for (BookEntity book : books) {

            transformer.transform(element, book, "book");
        }

        model.addAttribute("books", element);
        return "books";
    }

}
