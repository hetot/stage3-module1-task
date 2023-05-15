package com.mjc.school.service.handlerImplementation;

import com.mjc.school.repository.implementation.models.ContentModel;
import com.mjc.school.repository.implementation.source.DataSource;
import com.mjc.school.service.dtoInterface.RequestInterface;
import com.mjc.school.service.dtoInterface.ResponseInterface;
import com.mjc.school.service.dtomodels.GetByIdRequest;
import com.mjc.school.service.dtomodels.ResponseDTO;
import com.mjc.school.service.optionInteface.OptionHandlerInterface;
import mapper.MyMapper;

import java.util.Optional;

public class GetByIdOptionHandler extends AbstractOptionHandler {
    public GetByIdOptionHandler(OptionHandlerInterface successor) {
        super(successor);
    }

    @Override
    public ResponseInterface process(RequestInterface requestDto) {
        ResponseDTO response = new ResponseDTO();
        if (requestDto instanceof GetByIdRequest) {
            Optional<ContentModel> optionalContentModel = DataSource.getInstance().getContents().stream().filter(c -> c.getId() == ((GetByIdRequest) requestDto).getId()).findFirst();
            if (optionalContentModel.isPresent()) {
                ContentModel contentModel = optionalContentModel.get();
                response = MyMapper.contentModelToResponseDto(contentModel);
            }
        } else {
            if (getSuccessor() != null)
                return getSuccessor().process(requestDto);
            response.setSuccessful(false);
            response.setMessage("Invalid option");
        }
        return response;
    }
}
