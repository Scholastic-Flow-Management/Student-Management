package com.SFM.Student_Management.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String accessToken;
    private long expiredIn;
    private String type;
}
