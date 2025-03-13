package com.backend.service.impl;

import com.backend.mapper.BiddingEnterpriseMapper;
import com.backend.pojo.BiddingEnterprise;
import com.backend.service.BiddingEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiddingEnterpriseServiceImpl implements BiddingEnterpriseService {
    
    @Autowired
    private BiddingEnterpriseMapper biddingEnterpriseMapper;
    
    @Override
    public List<BiddingEnterprise> listByAnnouncementId(Integer announcementId) {
        return biddingEnterpriseMapper.listByAnnouncementId(announcementId);
    }
    
    @Override
    public void add(BiddingEnterprise biddingEnterprise) {
        biddingEnterpriseMapper.add(biddingEnterprise);
    }
} 