package com.backend.mapper;

import com.backend.pojo.BiddingEnterprise;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BiddingEnterpriseMapper {
    List<BiddingEnterprise> listByAnnouncementId(Integer announcementId);
    
    void add(BiddingEnterprise biddingEnterprise);
} 