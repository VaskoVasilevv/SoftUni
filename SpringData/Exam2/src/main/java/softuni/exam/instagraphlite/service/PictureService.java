package softuni.exam.instagraphlite.service;

import softuni.exam.instagraphlite.models.entity.Picture;

import java.io.IOException;

public interface PictureService {
    Boolean areImported();
    String readFromFileContent() throws IOException;
    String importPictures() throws IOException;
    String exportPictures();

    boolean findPictureByFilePath(String profilePicture);

    Picture getPictureByFilePath(String profilePicture);

    boolean existPictureByPath(String path);
}
