package com.wing.backend.forutonamanager.manager.MaliciousProfile.Service.SearchService;

import com.wing.backend.forutonamanager.forutona.FUserInfo.Service.FUserInfoService;
import com.wing.backend.forutonamanager.manager.MaliciousProfile.Domain.MaliciousProfile;
import com.wing.backend.forutonamanager.manager.MaliciousProfile.Dto.MaliciousProfilePageItemResDto;
import com.wing.backend.forutonamanager.manager.MaliciousProfile.Repository.MaliciousProfileDataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaliciousProfileFalseReportSearchService extends MaliciousProfileSearchService {

    final MaliciousProfileDataRepository maliciousProfileDataRepository;

    public MaliciousProfileFalseReportSearchService(FUserInfoService fUserInfoService, MaliciousProfileDataRepository maliciousProfileDataRepository) {
        super(fUserInfoService);

        this.maliciousProfileDataRepository = maliciousProfileDataRepository;
    }

    @Override
    public Page<MaliciousProfilePageItemResDto> search(Pageable pageable) {
        Page<MaliciousProfile> byFalseReportFlagTrue = this.maliciousProfileDataRepository.findByFalseReportFlagTrue(pageable);
        return makeMaliciousProfilePageItemResDto(byFalseReportFlagTrue);
    }
}
