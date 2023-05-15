package com.mjc.school.service.optionInteface;

import com.mjc.school.service.dtoInterface.RequestInterface;
import com.mjc.school.service.dtoInterface.ResponseInterface;

public interface OptionHandlerInterface {
    ResponseInterface process(RequestInterface requestDto);
}
