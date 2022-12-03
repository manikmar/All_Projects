package com.ace.cigna.DemoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentData {

    private int id;
    private String name;
    private int age;
}
