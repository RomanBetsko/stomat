package com.ua.stomat.appservices.validator;

/**
 * Created by victor.zablotskiy on 17.04.2019.
 */
public class DownloadFileCriteria {

    private Integer fileId;
    private String fileName;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DownloadFileCriteria)) return false;

        DownloadFileCriteria that = (DownloadFileCriteria) o;

        if (getFileId() != null ? !getFileId().equals(that.getFileId()) : that.getFileId() != null) return false;
        return getFileName() != null ? getFileName().equals(that.getFileName()) : that.getFileName() == null;

    }

    @Override
    public int hashCode() {
        int result = getFileId() != null ? getFileId().hashCode() : 0;
        result = 31 * result + (getFileName() != null ? getFileName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DownloadFileCriteria{" +
                "fileId='" + fileId + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
