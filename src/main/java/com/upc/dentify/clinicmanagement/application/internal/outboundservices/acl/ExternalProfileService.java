package com.upc.dentify.clinicmanagement.application.internal.outboundservices.acl;

import com.upc.dentify.iam.interfaces.acl.ProfilesContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalProfileService {

    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public Long fetchClinicIdByUserId(Long userId) {
        return profilesContextFacade.fetchClinicByUserId(userId);
    }
}
