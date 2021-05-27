create table if not exists customer(
    id int auto_increment primary key,
    email varchar(255) unique ,
    masokh varchar(255),
    hoten varchar(255),
    ngaysinh date,
    gioi_tinh varchar(50),
    quoc_tich varchar(100),
    que_quan varchar(255),
    socmt varchar(15) unique ,
    ngaycap date,
    noicap varchar(255),
    diachi varchar(255),
    sodienthoai varchar(12),
    tinh_trang_hon_nhan varchar(50),
    congviec varchar(100),
    phongban varchar(100),
    tencongty varchar(100),
    thu_nhap varchar(100),
    ten_nguoi_than1 varchar(255),
    diachi_nguoithan1 varchar(255),
    sdtnguoithan1 varchar(255),
    cam_ket boolean
);
create table if not exists loan_information(
    id int auto_increment primary key,
    loan float,
    date_of_loan DATE,
    interest_rate float,
    interest_type int,
    loan_per_month float,
    num_of_months int,
    customer_id int,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
create table if not exists pay_information(
    id int auto_increment primary key,
    existence float,
    date_of_pay DATE,
    payment_date DATE,
    interest float,
    total_per_month float,
    count_month int,
    is_pay boolean,
    customer_id int,
    loan_id int,
    loan_per_month float,
    FOREIGN KEY (loan_id) REFERENCES loan_information(id)
)

