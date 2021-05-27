package com.example.bank.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Entity
@Component
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "masokh")
    private String masoKh;

    @Column(name="hoten")
    private String name;

    @Column(name = "ngaysinh")
    private String birthday;

    @Column(name="gioi_tinh")
    private String gender;

    @Column(name="quoc_tich")
    private String quocTich;

    @Column(name="que_quan")
    private String hometown;

    @Column(name = "socmt")
    private String identityCode;

    @Column(name = "ngaycap")
    private String identityCreatedAt;

    @Column(name = "noicap")
    private String identityCreatedFrom;

    @Column(name="diachi")
    private String address;

    @Column(name = "sodienthoai")
    private String phoneNumber;

    @Column(name = "tinh_trang_hon_nhan")
    private String ttHonnhan;

    @Column(name = "congviec")
    private String job;

    @Column(name = "tencongty")
    private String nameCompany;

    @Column(name = "phongban")
    private String department;

    @Column(name = "thu_nhap")
    private String salary;

    @Column(name = "ten_nguoi_than1")
    private String nameProtector;

    @Column(name = "diachi_nguoithan1")
    private String addressProtector;

    @Column(name = "sdtnguoithan1")
    private String phoneProtector;

    @Column(name="cam_ket")
    private boolean isConfirm;
}