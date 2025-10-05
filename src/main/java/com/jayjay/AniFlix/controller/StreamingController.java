package com.jayjay.AniFlix.controller;

import com.jayjay.AniFlix.dto.request.StreamingRequest;
import com.jayjay.AniFlix.dto.response.StreamingResponse;
import com.jayjay.AniFlix.entity.Streaming;
import com.jayjay.AniFlix.service.StreamingService;
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
        return ResponseEntity.ok(streamingService.listStreaming());
    }

    //get - list streaming by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<StreamingResponse>> listStreamingById(@PathVariable Long id){
        return ResponseEntity.ok(streamingService.listStreamingById(id));
    }

    // post - register a new streaming
    @PostMapping()
    public ResponseEntity<StreamingResponse> createStreaming(@RequestBody StreamingRequest streaming){
        return ResponseEntity.status(HttpStatus.CREATED).body(streamingService.createStreaming(streaming));
    }

    // delete - delete a streaming
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStreaming(@PathVariable Long id){
       streamingService.deleteStreaming(id);
       return ResponseEntity.noContent().build();
    }
}
