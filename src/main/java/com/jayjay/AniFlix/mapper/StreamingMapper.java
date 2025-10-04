package com.jayjay.AniFlix.mapper;

import com.jayjay.AniFlix.dto.request.StreamingRequest;

import com.jayjay.AniFlix.dto.response.GenreResponse;
import com.jayjay.AniFlix.dto.response.StreamingResponse;
import com.jayjay.AniFlix.entity.Streaming;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class StreamingMapper {

    public Streaming toEntity(StreamingRequest streamingRequest){
        Streaming streaming = new Streaming();
        streaming.setName(streamingRequest.name());
        return streaming;
    }

    public StreamingResponse toResponse(Streaming streaming){
        return new StreamingResponse(streaming.getId(),streaming.getName());
    }
}
