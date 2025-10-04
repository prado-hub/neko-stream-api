package com.jayjay.AniFlix.controller;

import com.jayjay.AniFlix.entity.Streaming;
import com.jayjay.AniFlix.service.StreamingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streaming")
public class StreamingController {

    private final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    // get - list all streamings
    @GetMapping("/")
    public List<Streaming> listStreaming(){
        return streamingService.listStreaming();
    }

    // post - register a new streaming
    @PostMapping("/")
    public Streaming createStreaming(@RequestBody Streaming streaming){
        return streamingService.createStreaming(streaming);
    }

    // delete - delete a streaming
    @DeleteMapping("/{id}")
    public void deleteStreaming(@PathVariable Long id){
       streamingService.deleteStreaming(id);
    }

    // update - update a streaming
    @PutMapping("/{id}")
    public Streaming updateStreaming(@PathVariable Long id,@RequestBody Streaming streamingAtt){
        return streamingService.updateStreaming(id,streamingAtt);
    }
}
