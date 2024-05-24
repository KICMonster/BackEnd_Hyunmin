package com.monster.luv_cocktail.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "JWT_TOKEN")
public class JwtToken {

    @Id
    @Column(name = "TOKEN_ID", nullable = false)
    private String tokenId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @Column(name = "GRANT_TYPE", nullable = false)
    private String grantType;

    @Column(name = "ACCESSTOKEN", nullable = false)
    private String accessToken;

    @Column(name = "REFRESHTOKEN", nullable = false)
    private String refreshToken;

    @Column(name = "EXPIRE_IN", nullable = false)
    private Date expireIn;

    @Column(name = "CREATED_AT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    public JwtToken(String tokenId, Member member, String grantType, String accessToken, String refreshToken, Date expireIn) {
        this.tokenId = tokenId;
        this.member = member;
        this.grantType = grantType;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expireIn = expireIn;
    }
}
