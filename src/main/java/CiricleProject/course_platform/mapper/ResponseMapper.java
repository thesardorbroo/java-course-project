package CiricleProject.course_platform.mapper;

import CiricleProject.course_platform.dto.ResponseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class ResponseMapper {
//    @Bean
    public static ResponseDto getResponseDto(Integer code, Boolean success, String message, Object o){
        return ResponseDto.builder()
                .code(code)
                .success(success)
                .message(message)
                .data(o)
                .build();
    }
}
