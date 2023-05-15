package com.mjc.school.service.handlerImplementation;

import com.mjc.school.repository.models.ContentModel;
import com.mjc.school.repository.source.DataSource;
import com.mjc.school.service.dtoInterface.RequestInterface;
import com.mjc.school.service.dtoInterface.ResponseInterface;
import com.mjc.school.service.dtomodels.CreateRequest;
import com.mjc.school.service.dtomodels.GetAllRequest;
import com.mjc.school.service.dtomodels.ResponseDTO;
import com.mjc.school.service.optionInteface.OptionHandlerInterface;
import com.mjc.school.service.validators.DtoValidator;
import com.mjc.school.service.validators.ValidatorResponse;
import mapper.MyMapper;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GetAllOptionHandler extends AbstractOptionHandler {
    public GetAllOptionHandler(OptionHandlerInterface successor) {
        super(successor);
    }

    @Override
    public ResponseInterface process(RequestInterface requestDto) {
        ResponseDTO response = new ResponseDTO();
        if (requestDto instanceof GetAllRequest) {
            List<ContentModel> contentModelList = DataSource.getInstance().getContents();
            response = MyMapper.contentModelToResponseDto(contentModelList);
        } else {
            if (getSuccessor() != null)
                return getSuccessor().process(requestDto);
            response.setSuccessful(false);
            response.setMessage("Invalid option");
        }
        return response;
    }
}
