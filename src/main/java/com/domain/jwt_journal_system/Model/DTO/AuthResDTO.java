package com.domain.jwt_journal_system.Model.DTO;

public class AuthResDTO {
    private String accessToken;

    public AuthResDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthResDTO() {}

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
