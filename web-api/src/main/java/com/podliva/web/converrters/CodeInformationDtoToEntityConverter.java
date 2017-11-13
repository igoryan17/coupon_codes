package com.podliva.web.converrters;

import com.podliva.web.models.CodeInformationDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.podliva.db.models.CodeInformation;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeInformationDtoToEntityConverter implements Converter<CodeInformationDto, CodeInformation> {
    @Override
    public CodeInformation convert(CodeInformationDto codeInformationDto) {
        return new CodeInformation(codeInformationDto.getId(), codeInformationDto.getName(), codeInformationDto.getCode());
    }

    public List<CodeInformation> convert(List<CodeInformationDto> codeInformationDtos) {
        return codeInformationDtos.parallelStream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
