package com.jayjay.NekoStream.mapper;

import com.jayjay.NekoStream.dto.request.StreamingRequest;

import com.jayjay.NekoStream.dto.response.StreamingResponse;
import com.jayjay.NekoStream.entity.Streaming;
import org.springframework.stereotype.Component;

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
