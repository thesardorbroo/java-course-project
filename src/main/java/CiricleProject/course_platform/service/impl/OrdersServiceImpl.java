package CiricleProject.course_platform.service.impl;

import CiricleProject.course_platform.dto.OrdersDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.entity.Orders;
import CiricleProject.course_platform.repository.CourseRepository;
import CiricleProject.course_platform.repository.StudentRepository;
import CiricleProject.course_platform.service.mapper.OrdersMapper;
import CiricleProject.course_platform.mapper.ResponseMapper;
import CiricleProject.course_platform.repository.OrdersRepository;
import CiricleProject.course_platform.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    private final OrdersMapper ordersMapper;

    @Override
    public ResponseDto<List<OrdersDto>> getAllOrders() {
        List<Orders> orders = ordersRepository.findAll();
        List<OrdersDto> list = orders.stream()
                .map(ordersMapper::toDto)
                .toList();

        return ResponseMapper.getResponseDto(200, true, "Data is found!", list);
    }

    @Override
    public ResponseDto getOrdersById(Integer id) {
        if (ordersRepository.existsById(id)) {
            Orders orders = ordersRepository.findById(id).get();
            return ResponseMapper.getResponseDto(200, true, "Data is found!",
                    ordersMapper.toDto(orders));

        }

        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto updateOrders(OrdersDto ordersDto) {
        if(ordersRepository.existsById(ordersDto.getId())){
            Orders orders = ordersRepository.findById(ordersDto.getId()).get();
            orders = Orders.builder()
                    .id(ordersDto.getId() != null? ordersDto.getId() : orders.getId())
                    .courseId(ordersDto.getCourseId() != null? ordersDto.getCourseId() : orders.getCourseId())
                    .studentId(ordersDto.getStudentId() != null? ordersDto.getStudentId() : orders.getStudentId())
                    .isPaid(ordersDto.getIsPaid() != null? ordersDto.getIsPaid() : orders.getIsPaid())
                    .build();

            ordersRepository.save(orders);
            return ResponseMapper.getResponseDto(200, true, "Successfully updated!", ordersMapper.toDto(orders));

        }
        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto deleteOrdersById(Integer id) {
        if(ordersRepository.existsById(id)){
            Orders orders = ordersRepository.findById(id).get();
            ordersRepository.delete(orders);
            return ResponseMapper.getResponseDto(200, true, "Successfully deleted!", ordersMapper.toDto(orders));
        }

        return ResponseMapper.getResponseDto(404, false, "Data is not found!", null);
    }

    @Override
    public ResponseDto addNewOrders(OrdersDto ordersDto) {
        if(!ordersRepository.existsById(ordersDto.getId())){
            Orders orders = ordersRepository.save(ordersMapper.toEntity(ordersDto));
            return ResponseMapper.getResponseDto(200, true, "Successully saved!", ordersMapper.toDto(orders));
        }

        return ResponseMapper.getResponseDto(404, false, "Data is already exists!", null);
    }

    @Override
    public ResponseDto buyCourse(Integer studentId ,Integer courseId) {
        boolean course = courseRepository.existsById(courseId);
        boolean student = studentRepository.existsById(studentId);

        if(!course) return ResponseMapper.getResponseDto(404, false, "Course is not found!", null);
        if(!student) return ResponseMapper.getResponseDto(404, false, "Student is not found!", null);

        Orders orders = Orders.builder().studentId(studentId).courseId(courseId).isPaid(true).build();
        orders = ordersRepository.save(orders);
        return ResponseMapper.getResponseDto(200, false, "Successfully sold!", ordersMapper.toDto(orders));
    }
}
