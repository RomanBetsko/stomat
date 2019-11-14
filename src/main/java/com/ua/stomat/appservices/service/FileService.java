package com.ua.stomat.appservices.service;

import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;

import java.io.IOException;
import java.util.List;

public interface FileService {

    File createFolder(String folderIdParent, String folderName);

    List<File> getGoogleSubFolderByName(String googleFolderIdParent, String subFolderName);

    File createGoogleFile(String googleFolderIdParent, String contentType, String customFileName, byte[] uploadData);

    Permission createPublicPermission(String googleFileId);

    List<File> getGoogleFilesByName(String fileNameLike);
}
