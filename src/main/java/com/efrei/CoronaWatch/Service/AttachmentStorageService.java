package com.efrei.CoronaWatch.Service;

import com.efrei.CoronaWatch.Entities.Attachment;
import com.efrei.CoronaWatch.Repositories.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AttachmentStorageService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    public Attachment store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());

        return attachment;
    }

    public Attachment getAttachment(long id) {
        return attachmentRepository.findByidAttachment(id);
    }

}