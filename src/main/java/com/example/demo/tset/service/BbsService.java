package com.example.demo.tset.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.tset.domain.BbsRequstDTO;
import com.example.demo.tset.domain.BbsResponseDTO;
import com.example.demo.tset.domain.comment.CommentRequestDTO;
import com.example.demo.tset.domain.comment.CommentResponseDTO;
import com.example.demo.tset.mapper.BbsMapper;


@Service
public class BbsService {
    
    @Autowired
    private BbsMapper bbsMapper;


    public void save(BbsRequstDTO params) {
        System.out.println("debug >>> service save()" + bbsMapper);
        bbsMapper.saveRow(params);
    }

    public void update(BbsRequstDTO params) {
        System.out.println("debug >>> service update()");
        bbsMapper.updateRow(params);
    }

    public void delete(Map<String, Integer> map ) {
        System.out.println("debug >>> service delete() with id " + map.get("id"));
        bbsMapper.deleteRow(map);  
    }

    public List<BbsResponseDTO> list() {
        System.out.println("debug >>> service selet()" );
        return bbsMapper.selectRow(); 
    }

    public Optional<BbsResponseDTO> select(Map<String, Integer> map) {
        System.out.println("debug >>> service selet()" );
        Optional<BbsResponseDTO> result = bbsMapper.getRow(map);
        System.out.println("debug >>> bbs result " + result);
        ArrayList<CommentResponseDTO> list = bbsMapper.commentSelectRow(map);
        System.out.println("debug >>> comment result " + list);
        if(result.isPresent() ) {
            result.get().setComments(list);
        }
        return result;
    }

    public void commentSave(CommentRequestDTO params) {
        System.out.println("debug >>> commentSave()");
        bbsMapper.saveComment(params);
    }
}
