package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import com.example.demo.tset.domain.BbsRequstDTO;
import com.example.demo.tset.domain.BbsResponseDTO;
import com.example.demo.tset.mapper.BbsMapper;

@SpringBootTest
public class ServiceApplicationTests {
    
    @Autowired
    private BbsMapper bbsMapper;

    @Test
    public void saveService() {
        System.out.println("debug >>> junit service save " + bbsMapper);
        System.out.println("debug mapper >>>>>>" +bbsMapper);
        BbsRequstDTO requst = BbsRequstDTO.builder()
                            .title("오늘은")
                            .content("시원하다")
                            .build();
        bbsMapper.saveRow(requst);
        System.out.println("debug >>>> save suscces");
    }

    @Test
    public void updateService() {
        System.out.println("debug mapper update >>>>>" +bbsMapper);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", 1);
        Optional<BbsResponseDTO> response = bbsMapper.getRow(map);
        System.out.println("debug >>> select Update One " + response);
        BbsRequstDTO params = BbsRequstDTO.builder()
                            .id(response.get().getId())  
                            .title("8월 29일")  
                            .content("목요일 내일은 금요일")  
                            .build();
        bbsMapper.updateRow(params);
        System.out.println("debug >>> update success");                  
    }
}
