package com.example.demo.tset.domain;

import java.util.ArrayList;
//import java.util.List;

import com.example.demo.tset.domain.comment.CommentResponseDTO;

//import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class BbsResponseDTO {
    private int id;
    private String  title;
    private String content;

    private ArrayList<CommentResponseDTO> comments;

}
