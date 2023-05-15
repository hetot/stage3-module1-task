package com.mjc.school.service.handlerImplementation;

import com.mjc.school.repository.implementation.models.ContentModel;
import com.mjc.school.repository.implementation.DataSource;
import com.mjc.school.service.dtoInterface.RequestInterface;
import com.mjc.school.service.dtoInterface.ResponseInterface;
import com.mjc.school.service.dtomodels.ResponseDTO;
import com.mjc.school.service.dtomodels.UpdateRequest;
import com.mjc.school.service.optionInteface.OptionHandlerInterface;
import com.mjc.school.service.validators.DtoValidator;
import com.mjc.school.service.validators.ValidatorResponse;
import mapper.MyMapper;

public class UpdateHandler extends AbstractOptionHandler {
    public UpdateHandler(OptionHandlerInterface successor) {
        super(successor);
    }

    @Override
    public ResponseInterface process(RequestInterface requestDto) {
        ResponseDTO response = new ResponseDTO();
        if (requestDto instanceof UpdateRequest) {
            ValidatorResponse validatorResponse = DtoValidator.validate(requestDto);
            if (validatorResponse.isValid()) {
                response.setSuccessful(false);
                response.setMessage(validatorResponse.getMessage());
            } else {
                ContentModel updateModel = MyMapper.dtoToModel(requestDto);
                ContentModel dataSourceResponseModel = DataSource.getInstance().updateContent(updateModel);
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
