package com.example.app.attachment;

import com.example.app.dto.attachment.AttachmentUploadDataDto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.app.constants.FileConstant.*;

public enum AttachmentParent {
    POST{
        @Override
        public String getFolderPath() {
            return POST_FOLDER;
        }

        @Override
        public AttachmentUploadDataDto createAttachmentUploadDataWithParentId(Long parentId) {
            return AttachmentUploadDataDto.newInstance().withPostId(parentId);
        }
    },
    CHANNEL{
        @Override
        public String getFolderPath() {
            return CHANNEL_FOLDER;
        }

        @Override
        public AttachmentUploadDataDto createAttachmentUploadDataWithParentId(Long parentId) {
            return AttachmentUploadDataDto.newInstance().withChannelId(parentId);
        }
    },
    COMMENT{
        @Override
        public String getFolderPath() {
            return COMMENT_FOLDER;
        }

        @Override
        public AttachmentUploadDataDto createAttachmentUploadDataWithParentId(Long parentId) {
            return AttachmentUploadDataDto.newInstance().withCommentId(parentId);
        }
    };

    protected abstract String getFolderPath();
    protected abstract AttachmentUploadDataDto createAttachmentUploadDataWithParentId(Long parentId);


    public AttachmentUploadDataDto createAttachmentUploadData(Long parentId, MultipartFile file){
        AttachmentUploadDataDto result = createAttachmentUploadDataWithParentId(parentId);

        Path folder = Paths.get(getFolderPath() + parentId + File.separator +"attachments");
        result.setFileCreationPath(folder.resolve(file.getOriginalFilename()).toAbsolutePath().toString());
        result.setOriginalFileName(file.getOriginalFilename());

        return result;
    }

    public void createFolderIfAbsent(Long parentId) throws IOException {
        Path folder = Paths.get(getFolderPath() + parentId + File.separator +"attachments");
        if (!Files.exists(folder)){
            Files.createDirectories(folder);
        }
    }

    public void checkIfFileExists(Long parentId, MultipartFile file) throws FileAlreadyExistsException {
        Path folder = Paths.get(getFolderPath() + parentId + File.separator +"attachments");
        if (Files.exists(folder.resolve(file.getOriginalFilename()))) {
            throw new FileAlreadyExistsException("Fajl " + file.getOriginalFilename() + " vec postoji!!!");
        }
    }

    public void copyFileToDestination(Long parentId, MultipartFile file) throws IOException {
        Path folder = Paths.get(getFolderPath() + parentId + File.separator +"attachments");
        Files.copy(file.getInputStream(),
                folder.resolve(file.getOriginalFilename()));
    }

    public ByteArrayResource findFileByParentIdAndFileName(Long parentId, String fileName) throws IOException {
        System.out.println(getFolderPath() + parentId + File.separator +"attachments" + File.separator + fileName);
        File file = new File(getFolderPath() + parentId + File.separator +"attachments" + File.separator + fileName);
        if(!file.exists()){
            throw new FileNotFoundException("Requested file not found");
        }

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return resource;
    }

    public void deleteFile(Long parentId, String fileName){
        File file = new File(getFolderPath() + parentId + File.separator +"attachments" + File.separator + fileName);
        boolean deleteSignal = file.delete();
        if(!deleteSignal){
            throw new RuntimeException("File not deleted."); // TODO: Attachment not deleted exception
        }
    }
}
