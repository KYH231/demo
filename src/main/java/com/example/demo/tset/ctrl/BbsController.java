package com.example.demo.tset.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.tset.domain.BbsRequstDTO;
import com.example.demo.tset.domain.BbsResponseDTO;
import com.example.demo.tset.domain.comment.CommentRequestDTO;
import com.example.demo.tset.service.BbsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;










@Tag(name="BBS API", description = "게시글 관련 API 목록")
@RequestMapping("api/bbs")
@RestController
public class BbsController {
    
    @Autowired
    private BbsService bbsService;

    
   
    @DeleteMapping("delete/{id}")
    @Operation(summary = "게시글 삭제",description = "게시글 키 값을 가지고 삭제")
    public ResponseEntity<String> delete(@PathVariable(name="id") Integer id) {
        System.out.println("debug >>> bbs controller client path / delete");
        System.out.println("debug >>> id " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id",id);
        bbsService.delete(map);
        return new ResponseEntity<String>( id+" 번째 데이터 삭제", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BbsResponseDTO>> getList() {
        System.out.println("debug >>> bbs controller client path / select");
        List<BbsResponseDTO> list = bbsService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("view/{id}")
    public ResponseEntity<Object> view(@PathVariable(name="id") Integer id) {
        System.out.println("debug >>> bbs controller client path / view");
        System.out.println("debug >>> id " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id",id);
        Optional<BbsResponseDTO> response = bbsService.select(map);
        if(response.isPresent()) {
            return new ResponseEntity<>( response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }
       
    }
    /* 
    @PostMapping("/post")
    public ResponseEntity<String> save(@RequestParam("title") String title, @RequestParam("content") String content) {
        
        BbsRequstDTO params = BbsRequstDTO.builder().title(title).content(content).build();
        System.out.println("debug >>>>>>>> requset dto" + params);
        
        return null;
    }
    */
    @PostMapping("/post")
    public ResponseEntity<BbsRequstDTO> save(BbsRequstDTO params) {
       
        System.out.println("debug >>> bbs controller client path / post");
        System.out.println("debug >>>>>>>> requset dto" + params);
        bbsService.save(params);
        return new ResponseEntity<>( params, HttpStatus.OK);
    }

    @PostMapping("/comment/save")
    public ResponseEntity<String> postMethodName(CommentRequestDTO params) {
        System.out.println("debug >>> bbs controller client path /comment/post");
        System.out.println("debug >>>>>>>> requset dto" + params);
        bbsService.commentSave(params);
        return new ResponseEntity<String>( params.getBbsid()+"에 타임라인 등록완료" , HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody BbsRequstDTO params) {
        System.out.println("debug >>> bbs controller client path /update");
        System.out.println("debug >>> update request DTO: " + params);
        bbsService.update(params);
        return new ResponseEntity<>("Update success", HttpStatus.OK);
    }
    
}
