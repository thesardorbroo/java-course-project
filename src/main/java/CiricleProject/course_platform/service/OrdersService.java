package CiricleProject.course_platform.service;


import CiricleProject.course_platform.dto.OrdersDto;
import CiricleProject.course_platform.dto.ResponseDto;

public interface OrdersService {

    ResponseDto getAllOrders();

    ResponseDto getOrdersById(Integer id);

    ResponseDto updateOrders(OrdersDto ordersDto);

    ResponseDto deleteOrdersById(Integer id);

    ResponseDto addNewOrders(OrdersDto ordersDto);

    ResponseDto buyCourse(Integer studentId ,Integer courseId);
}
