package com.kltn.api.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
@CrossOrigin(origins =  "${client.url}")
public class AWSRest {

    @Autowired
    private AWSService awsService;

    @PostMapping("/")
    public ResponseEntity<String> upLoadFile(@RequestPart(value="file")MultipartFile file){
        try {
        	System.out.println("ôhhjgg");
            return ResponseEntity.ok(awsService.uploadFile(file));
        }
        catch (Exception e){
        	throw e;
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
    @DeleteMapping("/{fileName}")
    public ResponseEntity<Boolean> deleteFile(@PathVariable(value="fileName")String fileName){
        try {
            return ResponseEntity.ok(awsService.deleteFile(fileName));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
    

}

