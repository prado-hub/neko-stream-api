package com.jayjay.AniFlix.service;

import com.jayjay.AniFlix.entity.Genre;
import com.jayjay.AniFlix.entity.Streaming;
import com.jayjay.AniFlix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }

    public List<Streaming> listStreaming(){
        return streamingRepository.findAll();
    }

    public Streaming createStreaming(Streaming streaming){
        return streamingRepository.save(streaming);
    }

    public void deleteStreaming(Long id){
        streamingRepository.deleteById(id);
    }

    public Streaming updateStreaming(Long id, Streaming streamingAtt){
        Optional<Streaming> streamingVerify = streamingRepository.findById(id);
        if(streamingVerify.isEmpty()){
            return null;
        }else{
            streamingAtt.setId(id);
            return streamingRepository.save(streamingAtt);
        }
    }
}
