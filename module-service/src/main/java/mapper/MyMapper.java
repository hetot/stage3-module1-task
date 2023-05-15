package mapper;

import com.mjc.school.repository.implementation.models.AuthorModel;
import com.mjc.school.repository.implementation.models.ContentModel;
import com.mjc.school.repository.implementation.DataSource;
import com.mjc.school.service.dtoInterface.RequestInterface;
import com.mjc.school.service.dtomodels.*;

import java.util.Date;
import java.util.List;

public class MyMapper {
    public static ContentModel dtoToModel(RequestInterface requestDto) {
        ContentModel contentModel = null;
        if (requestDto instanceof CreateRequest) {
            contentModel = createDtoToModel((CreateRequest) requestDto);
        } else if (requestDto instanceof UpdateRequest) {
            contentModel = updateDtoToModel((UpdateRequest) requestDto);
        }
        return contentModel;
    }

    private static ContentModel updateDtoToModel(UpdateRequest requestDto) {
        ContentModel contentModel = new ContentModel();
        long id = requestDto.getId();
        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        long authorId = requestDto.getAuthorId();
        contentModel.setId(id);
        contentModel.setLastUpdateDate(new Date());
        contentModel.setContent(content);
        contentModel.setTitle(title);
        AuthorModel author = DataSource.getInstance().getAuthors()
                .stream()
                .filter(authorModel -> authorModel.id() == authorId)
                .findFirst()
                .get();
        contentModel.setAuthor(author);
        return contentModel;
    }

    private static ContentModel createDtoToModel(CreateRequest requestDto) {
        ContentModel contentModel = new ContentModel();
        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        long authorId = requestDto.getAuthorId();
        contentModel.setCreateDate(new Date());
        contentModel.setLastUpdateDate(new Date());
        contentModel.setContent(content);
        contentModel.setTitle(title);
        AuthorModel author = DataSource.getInstance().getAuthors()
                .stream()
                .filter(authorModel -> authorModel.id() == authorId)
                .findFirst()
                .get();
        contentModel.setAuthor(author);
        return contentModel;
    }

    public static ResponseDTO contentModelToResponseDto(ContentModel contentModel) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.getContents().add(contentModelToDto(contentModel));
        return responseDTO;
    }

    public static ResponseDTO contentModelToResponseDto(List<ContentModel> contentModels) {
        ResponseDTO responseDTO = new ResponseDTO();
        for (ContentModel contentModel : contentModels) {
            responseDTO.getContents().add(contentModelToDto(contentModel));
        }
        return responseDTO;
    }

    public static ContentDTO contentModelToDto(ContentModel contentModel) {
        return new ContentDTO(
                contentModel.getId(),
                contentModel.getTitle(),
                contentModel.getContent(),
                contentModel.getCreateDate(),
                contentModel.getLastUpdateDate(),
                authorModelToDto(contentModel.getAuthor())
        );
    }

    public static AuthorDTO authorModelToDto(AuthorModel authorModel) {
        return new AuthorDTO(
                authorModel.id(),
                authorModel.name()
        );
    }
}
