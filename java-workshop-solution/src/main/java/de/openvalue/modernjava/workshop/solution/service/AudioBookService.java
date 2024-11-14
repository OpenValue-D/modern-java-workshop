package de.openvalue.modernjava.workshop.solution.service;

import de.openvalue.modernjava.workshop.solution.domain.repository.AudioBookRepository;
import de.openvalue.modernjava.workshop.solution.domain.model.AudioBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioBookService {
    private final AudioBookRepository audioBookRepository;

    public AudioBookService(AudioBookRepository audioBookRepository) {
        this.audioBookRepository = audioBookRepository;
    }

    public Long createAudioBook(String title, String author, String speaker) {
        var audioBook = new AudioBook();
        audioBook.setTitle(title);
        audioBook.setAuthor(author);
        audioBook.setSpeaker(speaker);
        audioBookRepository.save(audioBook);
        return audioBook.getId();
    }

    public void deleteById(long id) {
        audioBookRepository.deleteById(id);
    }

    public List<AudioBook> findAllAvailable() {
        return audioBookRepository.findAllAvailable();
    }
}
