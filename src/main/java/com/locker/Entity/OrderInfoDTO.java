package com.locker.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sejta on 2018/5/28.
 */
@Entity
@Table(name="ORDER_INFO",indexes = {@Index(name="index_orderUserId",columnList = "weChartID",unique = false)})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderInfoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int orderId;

    @Column(length = 20)
    private String orderType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="weChartID",nullable = false,foreignKey = @ForeignKey(name="FOREIGN_ORDER_USER",value = ConstraintMode.CONSTRAINT))
    private UserInfoDTO userInfo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date usedTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(length = 2)
    private int status;

    @Column
    private boolean isPay;

    @Column(length = 2)
    private int type;

    @Column
    private double totalPay;

    @Column
    private String currency;

    @Temporal(TemporalType.TIMESTAMP)
    private Date payTime;

    @Column
    private String payMethod;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumns(value = {
            // 分别匹配主表联合主键的两个字段
            @JoinColumn(name="detailNumber", referencedColumnName="detailNumber"),
            @JoinColumn(name="cabinetId", referencedColumnName="cabinetId")
    },foreignKey =  @ForeignKey(name="FOREIGN_ORDER_CABINET",value = ConstraintMode.CONSTRAINT))
    private CabinetDetailDTO cabinetDetailDTO;

}
