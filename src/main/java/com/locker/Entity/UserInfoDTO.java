package com.locker.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sejta on 2018/5/28.
 */
@Entity
@Table(name="USER_INFO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfoDTO implements Serializable{
    @Id
    private String weOpenID;

    @Column(length = 16)
    private String weNickName;

    @Column(length = 256 )
    private String weLocation;

    @Column(length = 2)
    private int userStates;

    @Column(length=11)
    private int userMobile;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registerTime;

    @Column(length=256)
    private int userToken;

    @PrePersist
    protected void prePersist() {
        if (this.registerTime == null) {
            registerTime = new Date();
        }
        if (this.lastLoginTime == null) {
            lastLoginTime = new Date();
        }
    }

}
