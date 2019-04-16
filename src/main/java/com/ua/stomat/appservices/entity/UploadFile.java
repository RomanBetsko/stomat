package com.ua.stomat.appservices.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "files_upload")
public class UploadFile {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private long fileId;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_data")
    private byte[] data;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public UploadFile() {
    }

    public UploadFile(String fileName, byte[] data, Client client) {
        this.fileName = fileName;
        this.data = data;
        this.client = client;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadFile)) return false;

        UploadFile that = (UploadFile) o;

        if (getFileId() != that.getFileId()) return false;
        if (getFileName() != null ? !getFileName().equals(that.getFileName()) : that.getFileName() != null)
            return false;
        if (!Arrays.equals(getData(), that.getData())) return false;
        return getClient() != null ? getClient().equals(that.getClient()) : that.getClient() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getFileId() ^ (getFileId() >>> 32));
        result = 31 * result + (getFileName() != null ? getFileName().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getData());
        result = 31 * result + (getClient() != null ? getClient().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UploadFile{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", data=" + Arrays.toString(data) +
                ", client=" + client +
                '}';
    }
}