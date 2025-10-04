package com.jayjay.AniFlix.controller;

import com.jayjay.AniFlix.dto.request.StreamingRequest;
import com.jayjay.AniFlix.dto.response.StreamingResponse;
import com.jayjay.AniFlix.entity.Streaming;
import com.jayjay.AniFlix.service.StreamingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/streaming")
public class StreamingController {

    private final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    // get - list all streamings
    @GetMapping()
    public List<StreamingResponse> listStreaming(){
        return streamingService.listStreaming();
    }

    //get - list streaming by id
    @GetMapping("/{id}")
    public Optional<StreamingResponse> listStreamingById(@PathVariable Long id){
        return streamingService.listStreamingById(id);
    }

    // post - register a new streaming
    @PostMapping()
    public StreamingResponse createStreaming(@RequestBody StreamingRequest streaming){
        return streamingService.createStreaming(streaming);
    }

    // delete - delete a streaming
    @DeleteMapping("/{id}")
    public void deleteStreaming(@PathVariable Long id){
       streamingService.deleteStreaming(id);
    }
}
