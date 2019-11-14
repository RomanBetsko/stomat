package com.ua.stomat.appservices.service.impl;

import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.Permission;
import com.ua.stomat.appservices.service.FileService;
import com.ua.stomat.appservices.service.drive.GoogleDriveUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public File createFolder(String folderIdParent, String folderName) {
        File fileMetadata = new File();

        fileMetadata.setName(folderName);
        fileMetadata.setMimeType("application/vnd.google-apps.folder");

        if (folderIdParent != null) {
            List<String> parents = Collections.singletonList(folderIdParent);
            fileMetadata.setParents(parents);
        }
        try {
            GoogleDriveUtils.getDriveService();
            Drive driveService = GoogleDriveUtils.getDriveService();
            return driveService.files().create(fileMetadata).setFields("id, name").execute();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private File _createGoogleFile(String googleFolderIdParent, String contentType, String customFileName,
                                   AbstractInputStreamContent uploadStreamContent) throws IOException {

        File fileMetadata = new File();
        fileMetadata.setName(customFileName);

        List<String> parents = Collections.singletonList(googleFolderIdParent);
        fileMetadata.setParents(parents);
        //
        Drive driveService = GoogleDriveUtils.getDriveService();
        return driveService.files().create(fileMetadata, uploadStreamContent)
                .setFields("id, webContentLink, webViewLink, parents").execute();
    }

    @Override
    public List<File> getGoogleSubFolderByName(String googleFolderIdParent, String subFolderName) {

        Drive driveService = null;
        try {
            driveService = GoogleDriveUtils.getDriveService();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String pageToken = null;
        List<File> list = new ArrayList<>();

        String query = null;
        if (googleFolderIdParent == null) {
            query = " name = '" + subFolderName + "' " //
                    + " and mimeType = 'application/vnd.google-apps.folder' " //
                    + " and 'root' in parents";
        } else {
            query = " name = '" + subFolderName + "' " //
                    + " and mimeType = 'application/vnd.google-apps.folder' " //
                    + " and '" + googleFolderIdParent + "' in parents";
        }

        do {
            FileList result = null;
            try {
                result = driveService.files().list().setQ(query).setSpaces("drive") //
                        .setFields("nextPageToken, files(id, name, createdTime)")//
                        .setPageToken(pageToken).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        //
        return list;
    }


    @Override
    public File createGoogleFile(String googleFolderIdParent, String contentType, //
                                 String customFileName, byte[] uploadData) {
        //
        AbstractInputStreamContent uploadStreamContent = new ByteArrayContent(contentType, uploadData);
        //
        try {
            return _createGoogleFile(googleFolderIdParent, contentType, customFileName, uploadStreamContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Permission createPublicPermission(String googleFileId) {
        // All values: user - group - domain - anyone
        String permissionType = "anyone";
        // All values: organizer - owner - writer - commenter - reader
        String permissionRole = "reader";

        Permission newPermission = new Permission();
        newPermission.setType(permissionType);
        newPermission.setRole(permissionRole);

        Drive driveService;
        try {
            driveService = GoogleDriveUtils.getDriveService();
            return driveService.permissions().create(googleFileId, newPermission).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<File> getGoogleFilesByName(String fileNameLike) {

        Drive driveService = null;
        try {
            driveService = GoogleDriveUtils.getDriveService();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String pageToken = null;
        List<File> list = new ArrayList<>();

        String query = " name contains '" + fileNameLike + "' " //
                + " and mimeType != 'application/vnd.google-apps.folder' ";

        do {
            FileList result = null;
            try {
                result = driveService.files().list().setQ(query).setSpaces("drive") //
                        // Fields will be assigned values: id, name, createdTime, mimeType
                        .setFields("nextPageToken, files(id, name, createdTime, mimeType)")//
                        .setPageToken(pageToken).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.addAll(Objects.requireNonNull(result).getFiles());
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        return list;
    }


}
