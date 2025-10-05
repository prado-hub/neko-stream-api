package com.jayjay.NekoStream.service;

import com.jayjay.NekoStream.dto.request.StreamingRequest;
import com.jayjay.NekoStream.dto.response.StreamingResponse;
import com.jayjay.NekoStream.entity.Streaming;
import com.jayjay.NekoStream.mapper.StreamingMapper;
import com.jayjay.NekoStream.repository.StreamingRepository;
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
