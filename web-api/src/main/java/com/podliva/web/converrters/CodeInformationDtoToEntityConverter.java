package com.podliva.web.converrters;

import com.podliva.web.models.CodeInformationDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.podliva.models.CodeInformation;

@Component
public class CodeInformationDtoToEntityConverter implements Converter<CodeInformationDto, CodeInformation> {
    @Override
    public CodeInformation convert(CodeInformationDto codeInformationDto) {
        return new CodeInformation(codeInformationDto.getName(), codeInformationDto.getCode());
    }
}
