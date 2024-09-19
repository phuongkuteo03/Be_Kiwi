package com.ikigai.kiwi.rest.controller;

import java.io.File;


import com.ikigai.kiwi.service.UploadService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


@CrossOrigin("*")
@RestController
public class UploadRestController {
    @Autowired
    UploadService uploadservice;

    @PostMapping("/rest/upload/{folder}")
    public JsonNode upload(@PathParam("file") MultipartFile file,
                           @PathVariable("folder") String folder) {
        File savedFile = uploadservice.save(file, folder);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("name", savedFile.getName());
        node.put("size", savedFile.length());
        return node;
    }
}
