package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.Attachment;
import org.springframework.data.repository.CrudRepository;

public interface AttachmentRepository extends CrudRepository<Attachment, Long>{

    Attachment findBytitle(String title);
    Attachment findByidAttachment(long id);



}