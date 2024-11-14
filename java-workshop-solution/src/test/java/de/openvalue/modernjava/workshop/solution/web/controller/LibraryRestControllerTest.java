package de.openvalue.modernjava.workshop.solution.web.controller;

import de.openvalue.modernjava.workshop.solution.service.AudioBookService;
import de.openvalue.modernjava.workshop.solution.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibraryRestController.class)
class LibraryRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean private BookService bookService;
    @MockBean private AudioBookService audioBookService;

    @Test
    void createBookValidation() throws Exception {
        String json = """
                        {
                            "title": "",
                            "author": "some-author"
                        }
                        """;


        mockMvc
                .perform(
                        post("/book")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createBook() throws Exception {
        String json = """
                        {
                            "title": "some-title",
                            "author": "some-author"
                        }
                        """;

        when(bookService.createBook(any(), any())).thenReturn(1L);

        mockMvc
                .perform(
                        post("/book")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(1)));
    }

    @Test
    void createAudioBookValidation() throws Exception {
        String json = """
                        {
                            "title": "",
                            "author": "some-author",
                            "speaker": "some-speaker"
                        }
                        """;

        mockMvc
                .perform(
                        post("/audiobook")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createAudioBook() throws Exception {
        String json = """
                        {
                            "title": "some-title",
                            "author": "some-author",
                            "speaker": "some-speaker"
                        }
                        """;

        when(audioBookService.createAudioBook(any(), any(), any())).thenReturn(1L);

        mockMvc
                .perform(
                        post("/audiobook")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(1)));
    }
}