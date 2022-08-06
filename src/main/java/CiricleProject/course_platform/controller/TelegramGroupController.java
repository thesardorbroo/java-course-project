package CiricleProject.course_platform.controller;

import CiricleProject.course_platform.dto.ResponseDto;
import CiricleProject.course_platform.dto.TelegramGroupDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import CiricleProject.course_platform.service.impl.TelegramGroupServiceImpl;

@Controller
@RequestMapping("telegramGroup")
public class TelegramGroupController {
    private final TelegramGroupServiceImpl telegramGroup;

    public TelegramGroupController(TelegramGroupServiceImpl telegramGroup) {
        this.telegramGroup = telegramGroup;
    }

    @GetMapping
    public ResponseDto getAllTelegramGroup(){
        return telegramGroup.getAllTelegramGroup();
    }
    @GetMapping
    public ResponseDto getByIdTelegramGroup(@PathVariable Integer id){
        return telegramGroup.getByIdTelegramGroup(id);
    }
    @PutMapping
    public ResponseDto updateTelegramGroup(@RequestBody TelegramGroupDto telegramGroupDto){
        return telegramGroup.updateTelegramGroup(telegramGroupDto);
    }
    @PatchMapping

    public ResponseDto addNewTelegramGrup(@RequestBody TelegramGroupDto telegramGroupDto){
        return telegramGroup.addNewTelegramGroup(telegramGroupDto);
    }
    @DeleteMapping
    public ResponseDto deleteById(@PathVariable Integer id){
        return telegramGroup.deleteByIdTelegramGroup(id);
    }


}
