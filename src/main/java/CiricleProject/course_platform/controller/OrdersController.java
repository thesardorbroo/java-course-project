package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.OrdersDto;
import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.service.impl.OrdersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersServiceImpl ordersService;
    @GetMapping("/{id}")
    public ResponseDto getOrdersById(@PathVariable Integer id){
        return ordersService.getOrdersById(id);
    }
    @GetMapping
    public ResponseDto getAllOrders(){
        return ordersService.getAllOrders();
    }
    @PostMapping
    public ResponseDto addNewOrders(@RequestBody OrdersDto ordersDto){
        return ordersService.addNewOrders(ordersDto);
    }

    @PutMapping
    public ResponseDto updateOrders(@RequestBody OrdersDto ordersDto){
        return ordersService.updateOrders(ordersDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteOrders(@PathVariable Integer id){
        return ordersService.deleteOrdersById(id);
    }

    @GetMapping("/buy/{student_id}/{course_id}")
    public ResponseDto buyCourse(@PathVariable Integer student_id, @PathVariable Integer course_id){
        return ordersService.buyCourse(student_id, course_id);
    }
}
