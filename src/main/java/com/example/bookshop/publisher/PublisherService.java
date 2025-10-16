package com.example.bookshop.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getAllPublishers(){return this.publisherRepository.findAll();}
    public Optional<Publisher> getPublisherById(Long id){
        return this.publisherRepository.findById(id);
    }
    public Publisher createPublisher(Publisher publisher){
        return this.publisherRepository.save(publisher);
    }
    public void deletePublisher(Long id){
        if(this.publisherRepository.existsById(id)){
            this.publisherRepository.deleteById(id);
        }else{
            throw new RuntimeException("Publisher not found");
        }
    }
}
