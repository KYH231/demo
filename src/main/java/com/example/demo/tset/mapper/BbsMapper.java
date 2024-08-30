package com.example.demo.tset.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.tset.domain.BbsRequstDTO;
import com.example.demo.tset.domain.BbsResponseDTO;
import com.example.demo.tset.domain.comment.CommentRequestDTO;
import com.example.demo.tset.domain.comment.CommentResponseDTO;

@Mapper
public interface BbsMapper {

    public void saveRow(BbsRequstDTO params);
    
    public List<BbsResponseDTO> selectRow();

    public Optional<BbsResponseDTO> getRow(Map<String, Integer>Map);

    public void deleteRow(Map<String, Integer>Map);

    public void updateRow(BbsRequstDTO params);

    public void saveComment(CommentRequestDTO params);

    public ArrayList<CommentResponseDTO> commentSelectRow(Map<String, Integer> map);
}
