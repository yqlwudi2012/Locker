package com.locker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sejta on 2018/5/29.
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "CABINET_DETAIL")
public class CabinetDetailDTO implements Serializable {
    @EmbeddedId
    private CabinetDetailIdentity cabinetDetailIdentity;

    @Column(length =  2)
    private int type;

    @Column(length =  2)
    private int status;

    @Column(length =  3)
    private int horizontal;

    @Column(length =  3)
    private int vertical;

    @Temporal(TemporalType.TIMESTAMP)
    private Date usedTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;
}
