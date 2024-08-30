package com.example.demo.tset.domain.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    
    private String content;
    private Integer bbsid;
}
