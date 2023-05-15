package com.mjc.school.service.handlerImplementation;

import com.mjc.school.repository.implementation.models.ContentModel;
import com.mjc.school.repository.implementation.DataSource;
import com.mjc.school.service.dtoInterface.RequestInterface;
import com.mjc.school.service.dtoInterface.ResponseInterface;
import com.mjc.school.service.dtomodels.RemoveRequest;
import com.mjc.school.service.dtomodels.ResponseDTO;
import com.mjc.school.service.optionInteface.OptionHandlerInterface;

import java.util.Optional;

public class RemoveOptionHandler extends AbstractOptionHandler {
    public RemoveOptionHandler(OptionHandlerInterface successor) {
        super(successor);
    }

    @Override
    public ResponseInterface process(RequestInterface requestDto) {
        ResponseDTO response = new ResponseDTO();
        if (requestDto instanceof RemoveRequest) {
            Optional<ContentModel> optionalContentModel = DataSource.getInstance().getContents().stream().filter(c -> c.getId() == ((RemoveRequest) requestDto).getId()).findFirst();
            if (optionalContentModel.isPresent()) {
                ContentModel contentModel = optionalContentModel.get();
                DataSource.getInstance().remove(contentModel);
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
