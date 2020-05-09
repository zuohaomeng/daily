package com.meng.ai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2020/4/17--0:44
 */
@Slf4j
@Controller
@RequestMapping("/ocr")
public class OCRController {
    @PostMapping
    public String getContent(){

        return null;
    }
}
