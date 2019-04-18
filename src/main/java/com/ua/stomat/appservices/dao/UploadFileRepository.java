package com.ua.stomat.appservices.dao;

import com.ua.stomat.appservices.entity.UploadFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadFileRepository extends CrudRepository<UploadFile, Long> {

    UploadFile save(UploadFile uploadFile);

    UploadFile findByFileId(Integer fileId);
}
