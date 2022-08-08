package CiricleProject.course_platform.service.mapper;

import CiricleProject.course_platform.dto.OrdersDto;
import CiricleProject.course_platform.entity.Orders;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Lazy;

@Mapper
public interface OrdersMapper {

    Orders toEntity (OrdersDto ordersDto);

    OrdersDto toDto (Orders orders);
}
