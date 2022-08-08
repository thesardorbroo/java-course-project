package CiricleProject.course_platform.mapper;

import CiricleProject.course_platform.dto.OrdersDto;
import CiricleProject.course_platform.entity.Orders;
import org.springframework.stereotype.Component;

@Component
public class
OrdersMapper {

    public OrdersDto convertToDto(Orders orders){
        return OrdersDto.builder()
                .id(orders.getId())
                .courseId(orders.getCourseId())
                .studentId(orders.getStudentId())
                .isPaid(orders.getIsPaid())
                .build();
    }

    public Orders convertToEntity(OrdersDto ordersDto){
        return Orders.builder()
                .id(ordersDto.getId())
                .courseId(ordersDto.getCourseId())
                .studentId(ordersDto.getStudentId())
                .isPaid(ordersDto.getIsPaid())

                .build();
    }
}
