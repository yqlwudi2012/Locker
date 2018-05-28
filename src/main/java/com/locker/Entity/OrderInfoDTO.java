package com.locker.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Sejta on 2018/5/28.
 */
@Entity
@Table(name="ORDER_INFO",indexes = {@Index(name="index_orderUserId",columnList = "orderUserId",unique = false)})
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
    @JsonIgnore
    @JoinColumn(name="orderUserId",nullable = false,foreignKey = @ForeignKey(name="FOREIGN_ORDER_USER",value = ConstraintMode.CONSTRAINT))
    private UserInfoDTO userInfo;
}
