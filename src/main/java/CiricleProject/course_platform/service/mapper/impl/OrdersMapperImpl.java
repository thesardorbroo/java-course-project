package CiricleProject.course_platform.service.mapper.impl;

import CiricleProject.course_platform.dto.OrdersDto;
import CiricleProject.course_platform.entity.Orders;
import CiricleProject.course_platform.service.mapper.impl.StudentMapperImpl;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdersMapperImpl {

    public static OrdersDto toDtoWithout(Orders orders){
        return OrdersDto.builder()
                .id(orders.getId())
//                .student(StudentMapperImpl.toDtoWithout(orders.getStudent()))
//                .course(CourseMapperImpl.toDtoWithoutMentor(orders.getCourse()))
                .isPaid(orders.getIsPaid())
                .build();
    }

    public static Orders toEntityWithout(OrdersDto ordersDto){
        return Orders.builder()
                .id(ordersDto.getId())
//                .student(StudentMapperImpl.toEntityWithout(ordersDto.getStudent()))
//                .course(CourseMapperImpl.toEntityWithoutMentor(ordersDto.getCourse()))
                .isPaid(ordersDto.getIsPaid())
                .build();
    }
}
