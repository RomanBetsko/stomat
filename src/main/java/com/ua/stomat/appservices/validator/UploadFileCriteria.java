package com.ua.stomat.appservices.validator;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;


public class UploadFileCriteria {

    private String clientId;
    private MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public UploadFileCriteria() {
    }

    public UploadFileCriteria(String clientId, MultipartFile[] files) {
        this.clientId = clientId;
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UploadFileCriteria)) return false;

        UploadFileCriteria that = (UploadFileCriteria) o;

        if (getClientId() != null ? !getClientId().equals(that.getClientId()) : that.getClientId() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getFiles(), that.getFiles());

    }

    @Override
    public int hashCode() {
        int result = getClientId() != null ? getClientId().hashCode() : 0;
        result = 31 * result + Arrays.hashCode(getFiles());
        return result;
    }

    @Override
    public String toString() {
        return "UploadFileCriteria{" +
                "clientId='" + clientId + '\'' +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
