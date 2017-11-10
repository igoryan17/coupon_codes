package com.podliva.web.converrters;

import com.podliva.models.CodeInformation;
import com.podliva.web.models.CodeInformationDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeInformationEntityToDtoConverter implements Converter<CodeInformation, CodeInformationDto> {
    @Override
    public CodeInformationDto convert(CodeInformation codeInformation) {
        CodeInformationDto result = new CodeInformationDto();
        result.setId(codeInformation.getId());
        result.setName(codeInformation.getName());
        result.setCode(codeInformation.getCode());
        return result;
    }

    public List<CodeInformationDto> convert(List<CodeInformation> codeInformations) {
        return codeInformations.parallelStream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
