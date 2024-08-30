package com.example.demo.tset.domain.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class CommentResponseDTO {
    private Integer id;
    private String content;
    private Integer bbsid;
}
