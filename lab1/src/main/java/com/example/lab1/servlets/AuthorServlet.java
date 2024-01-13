package com.example.lab1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.lab1.services.AuthorService;
import com.example.lab1.models.dto.AuthorRequest;
import com.example.lab1.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "authorServlet", value = "/authors")
public class AuthorServlet extends HttpServlet {
    private ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private AuthorService authorService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/json");

        try(PrintWriter out = response.getWriter()){
            out.print(objectMapper.writeValueAsString(authorService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        try (InputStream is = req.getInputStream()){
            AuthorRequest authorRequest = objectMapper.readValue(is, AuthorRequest.class);
            authorService.create(authorRequest);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp){
        UUID authorID = UUID.fromString(req.getPathInfo().substring(1));
        authorService.delete(authorID);
    }
}
