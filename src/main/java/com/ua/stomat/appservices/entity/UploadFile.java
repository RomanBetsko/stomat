package com.ua.stomat.appservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "files_upload")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFile {

    @Id
    @Column(name = "file_id")
    private String fileId;
    @Column(name = "file_name")
    private String fileName;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}