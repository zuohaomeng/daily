package com.meng.daily.basejava.java8.stream;

import com.meng.daily.common.base.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
