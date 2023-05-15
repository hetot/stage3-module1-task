package com.mjc.school.service.handlerImplementation;

import com.mjc.school.repository.models.ContentModel;
import com.mjc.school.repository.source.DataSource;
import com.mjc.school.service.dtoInterface.RequestInterface;
import com.mjc.school.service.dtoInterface.ResponseInterface;
import com.mjc.school.service.dtomodels.CreateRequest;
import com.mjc.school.service.dtomodels.ResponseDTO;
import com.mjc.school.service.optionInteface.OptionHandlerInterface;
import com.mjc.school.service.validators.DtoValidator;
import com.mjc.school.service.validators.ValidatorResponse;
import mapper.MyMapper;

public class CreateHandler extends AbstractOptionHandler {

    public CreateHandler(OptionHandlerInterface successor) {
        super(successor);
    }

    @Override
    public ResponseInterface process(RequestInterface requestDto) {
        ResponseDTO response = new ResponseDTO();
        if (requestDto instanceof CreateRequest) {
            ValidatorResponse validatorResponse = DtoValidator.validate(requestDto);
            if (validatorResponse.isValid()) {
                response.setSuccessful(false);
                response.setMessage(validatorResponse.getMessage());
            } else {
                ContentModel createModel = MyMapper.dtoToModel(requestDto);
                ContentModel dataSourceResponseModel = DataSource.getInstance().addContent(createModel);
                response = MyMapper.contentModelToResponseDto(dataSourceResponseModel);
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
