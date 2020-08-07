package com.meng.spbnodependence.controller;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-06 19:26
 */
@RestController
@RequestMapping("/stream")
public class ListController {

    public static void main(String[] args) {
        List list = getList();
        System.out.println(Optional.ofNullable(list).orElse(Collections.emptyList()));
    }
    public static ArrayList getList(){
        ArrayList list =new ArrayList();
        String t = "2";
        if("2".equals(t)){
            return null;
        }
        return list;
    }
}
