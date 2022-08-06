package CiricleProject.course_platform.service;

import CiricleProject.course_platform.dto.HomeWorkDto;
import CiricleProject.course_platform.dto.ResponseDto;

public interface HomeWorkServise {
    ResponseDto getAllHomeWork();
    ResponseDto getHomeWorkById(Integer id);
    ResponseDto updateHomeWork(HomeWorkDto homeWorkDto);
    ResponseDto deleteHomeWorkById(Integer id);
    ResponseDto addNewHomeWork(HomeWorkDto homeWorkDto);
}
