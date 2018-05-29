package com.locker.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
public class UserInfoDTO implements Serializable{
    @Id
    private String weOpenId;

    @Column(length = 16)
    private String weNickName;

    @Column(length = 256 )
    private String weLocation;

    @Column(length = 2)
    private int userStates;

    @Column(length=11)
    private String userMobile;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerTime;

    @Column(length=256)
    private String userToken;

    @PrePersist
    protected void prePersist() {

        if (this.registerTime == null) {
            registerTime = new Date();
        }
        if (this.lastLoginTime == null) {
            lastLoginTime = new Date();
        }
        if(this.userStates==0){
            userStates=1;
        }
    }
    @PreUpdate
    void preUpdate(){
        lastLoginTime = new Date();
    }

}
