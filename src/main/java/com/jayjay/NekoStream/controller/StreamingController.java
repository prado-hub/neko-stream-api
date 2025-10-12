package com.jayjay.NekoStream.controller;

import com.jayjay.NekoStream.dto.request.StreamingRequest;
import com.jayjay.NekoStream.dto.response.StreamingResponse;
import com.jayjay.NekoStream.service.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<StreamingResponse>> listStreaming(){
        List<StreamingResponse> streamingList = streamingService.listStreaming();
        return ResponseEntity.ok(streamingList);
    }

    //get - list streaming by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<StreamingResponse>> listStreamingById(@PathVariable Long id){
        Optional<StreamingResponse> streaming = streamingService.listStreamingById(id);
        return ResponseEntity.ok(streaming);
    }

    // post - register a new streaming
    @PostMapping()
    public ResponseEntity<StreamingResponse> createStreaming(@RequestBody StreamingRequest streaming){
        StreamingResponse streamingCreated = streamingService.createStreaming(streaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(streamingCreated);
    }

    // delete - delete a streaming
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStreaming(@PathVariable Long id){
       streamingService.deleteStreaming(id);
       return ResponseEntity.noContent().build();
    }
}
