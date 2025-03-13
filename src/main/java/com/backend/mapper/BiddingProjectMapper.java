package com.backend.mapper;

import com.backend.pojo.BiddingProject;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BiddingProjectMapper {
    void add(BiddingProject biddingProject);
    
    List<BiddingProject> list();
    
    BiddingProject getById(Integer id);
    
    void update(BiddingProject biddingProject);
} 