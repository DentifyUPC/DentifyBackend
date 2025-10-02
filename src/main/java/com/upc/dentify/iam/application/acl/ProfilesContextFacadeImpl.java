package com.upc.dentify.iam.application.acl;

import com.upc.dentify.iam.domain.model.queries.GetClinicIdByUserIdQuery;
import com.upc.dentify.iam.domain.services.ProfileQueryService;
import com.upc.dentify.iam.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ProfilesContextFacadeImpl implements ProfilesContextFacade {

    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacadeImpl(ProfileQueryService profileQueryService) {
        this.profileQueryService = profileQueryService;
    }

    @Override
    public Long fetchClinicByUserId(Long userId) {
        Long clinicId = profileQueryService.handle(new GetClinicIdByUserIdQuery(userId));
        return clinicId != null ? clinicId : null;
    }
}
