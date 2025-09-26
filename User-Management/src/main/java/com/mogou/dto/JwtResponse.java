package com.mogou.dto;

public class JwtResponse {
    public String token;
    public String type;
    public Long id;
    public String email;
    public String role;

    public JwtResponse(String token, String type, Long id, String email, String role){
        this.token = token; this.type = type; this.id = id; this.email = email; this.role = role;
    }
}
