package com.jayjay.AniFlix.service;

import com.jayjay.AniFlix.dto.request.StreamingRequest;
import com.jayjay.AniFlix.dto.response.StreamingResponse;
import com.jayjay.AniFlix.entity.Streaming;
import com.jayjay.AniFlix.mapper.StreamingMapper;
import com.jayjay.AniFlix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;
    private final StreamingMapper streamingMapper;


    public StreamingService(StreamingRepository streamingRepository, StreamingMapper streamingMapper) {
        this.streamingRepository = streamingRepository;
        this.streamingMapper = streamingMapper;
    }

    public List<StreamingResponse> listStreaming(){
        return streamingRepository.findAll()
                .stream()
                .map(streamingMapper::toResponse)
                .toList();
    }

    public Optional<StreamingResponse> listStreamingById(Long id){
        return streamingRepository.findById(id).map(streamingMapper::toResponse);
    }

    public StreamingResponse createStreaming(StreamingRequest streaming){
        Streaming streamingCreated = streamingMapper.toEntity(streaming);
        streamingRepository.save(streamingCreated);
        return streamingMapper.toResponse(streamingCreated);
    }

    public void deleteStreaming(Long id){
        streamingRepository.deleteById(id);
    }
}
