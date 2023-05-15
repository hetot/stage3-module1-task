import com.mjc.school.service.dtoInterface.ResponseInterface;
import com.mjc.school.service.dtomodels.*;
import com.mjc.school.service.service.AppService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AppEngineTest {
    AppService service;

    @BeforeEach
    void setEngine() {
        service = AppService.getInstance();
    }

    @Test
    void testCreate() {
        CreateRequest createRequest = new CreateRequest();
        String content = "my content .........";
        String title = "my title";
        long authorId = 1;
        createRequest.setContent(content);
        createRequest.setTitle(title);
        createRequest.setAuthorId(authorId);
        ResponseDTO responseDTO = (ResponseDTO) service.processOption(createRequest);
        Assertions.assertEquals(responseDTO.getContents().size(), 1);
        Assertions.assertTrue(responseDTO.isSuccessful());
        Assertions.assertEquals(responseDTO.getContents().get(0).author().id(), 1);
        Assertions.assertEquals(responseDTO.getContents().get(0).content(), content);
        Assertions.assertEquals(responseDTO.getContents().get(0).title(), title);
    }

    @Test
    void testUpdate() {
        UpdateRequest updateRequest = new UpdateRequest();
        long id = 1;
        String content = "my content .........";
        String title = "my title";
        long authorId = 1;
        updateRequest.setId(id);
        updateRequest.setContent(content);
        updateRequest.setTitle(title);
        updateRequest.setAuthorId(authorId);
        ResponseDTO responseDTO = (ResponseDTO) service.processOption(updateRequest);
        Assertions.assertEquals(responseDTO.getContents().size(), 1);
        Assertions.assertTrue(responseDTO.isSuccessful());
        Assertions.assertEquals(responseDTO.getContents().get(0).author().id(), 1);
        Assertions.assertEquals(responseDTO.getContents().get(0).content(), content);
        Assertions.assertEquals(responseDTO.getContents().get(0).title(), title);
    }

    @Test
    void testGetAll() {
        GetAllRequest getAllRequest = new GetAllRequest();
        ResponseDTO responseDTO = (ResponseDTO) service.processOption(getAllRequest);
        Assertions.assertTrue(responseDTO.isSuccessful());
        Assertions.assertEquals(responseDTO.getContents().size(), 3);
    }

    @Test
    void testGetById() {
        GetByIdRequest getByIdRequest = new GetByIdRequest(2);
        ResponseDTO responseDTO = (ResponseDTO) service.processOption(getByIdRequest);
        Assertions.assertTrue(responseDTO.isSuccessful());
        Assertions.assertEquals(responseDTO.getContents().size(), 1);
        Assertions.assertEquals(responseDTO.getContents().get(0).id(), 2);
    }
}
