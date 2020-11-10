package com.meng.daily.basejava.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-07-20 17:23
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResult {
    public String name;
    public int age;


}
