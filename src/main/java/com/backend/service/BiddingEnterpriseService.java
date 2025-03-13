package com.backend.service;

import com.backend.pojo.BiddingEnterprise;
import java.util.List;

public interface BiddingEnterpriseService {
    List<BiddingEnterprise> listByAnnouncementId(Integer announcementId);
    
    void add(BiddingEnterprise biddingEnterprise);
} 