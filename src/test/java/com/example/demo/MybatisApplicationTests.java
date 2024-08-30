package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import com.example.demo.tset.domain.BbsRequstDTO;
import com.example.demo.tset.domain.BbsResponseDTO;
import com.example.demo.tset.mapper.BbsMapper;

@SpringBootTest
public class MybatisApplicationTests {
    
    @Autowired
    private BbsMapper bbsMapper;

    @Test
    public void saveTest() {
        System.out.println("debug mapper >>>>>>" +bbsMapper);
        BbsRequstDTO requst = BbsRequstDTO.builder().title("겁나 어렵다").content("뻥이야 쉬워").build();
        bbsMapper.saveRow(requst);
        System.out.println("debug >>>> save suscces");
        
    }

    @Test
    public void selectTest() {
        System.out.println("debug mapper select>>>>" + bbsMapper);
        List<BbsResponseDTO> list = bbsMapper.selectRow();
        for(BbsResponseDTO dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void selectOne() {
        System.out.println("debug mapper >>>>>" +bbsMapper);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", 2);
        Optional<BbsResponseDTO> response = bbsMapper.getRow(map);
        System.out.println("debug >>> select One " + response.get());
    }

    @Test
    public void deleteTest() {
        System.out.println("debug mapper >>>>>" +bbsMapper);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", 2);
        Optional<BbsResponseDTO> response = bbsMapper.getRow(map);
        System.out.println("debug >>> delect One " + response);
        bbsMapper.deleteRow(map);
        System.out.println("debug >>> delete success");
        
    }
} 
