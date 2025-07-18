package com.juntralala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
public class UploadController {

    @PostMapping(path = "/upload/profile", consumes = {MULTIPART_FORM_DATA_VALUE})
    @ResponseBody
    public String upload(
            @RequestParam(name = "name") String name,
            @RequestPart(name = "profile") MultipartFile profile
    ) throws IOException {
        Path targetPath = Path.of("upload/" + profile.getOriginalFilename());
        profile.transferTo(targetPath); // <- melakukan copy file dengan inputstream dan outputstream
        return "Success save profile " + name + " to " + targetPath;
    }

}
