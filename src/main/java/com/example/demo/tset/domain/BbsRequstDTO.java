package com.example.demo.tset.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class BbsRequstDTO {
    private int id;
    private String title;
    private String content;
}
