INSERT INTO member (user_id, user_password, user_address, user_name, user_hp, user_email, user_role,grade) 
VALUES 
('test1', '1234', '서울특별시', '김진수2', '01089237125', 'afc2016@naver.com', 'BIZ','실버'),
('test2', '1234', '대구광역시', '김진수3', '01089237126', 'afc2017@naver.com', 'USER','골드'),
('test3', '1234', '광주광역시', '김진수4', '01089237127', 'afc2018@naver.com', 'USER','실버'),
('test4', '1234', '울산광역시', '김진수5', '01089237128', 'afc2019@naver.com', 'USER','골드'),
('test5', '1234', '울산광역시', '김진수6', '01089237128', 'afc2020@naver.com', 'USER','브론즈'),
('test6', '1234', '울산광역시', '김진수7', '01089237128', 'afc2021@naver.com', 'USER','골드'),
('test7', '1234', '울산광역시', '김진수8', '01089237128', 'afc2022@naver.com', 'USER','실버'),
('test8', '1234', '울산광역시', '김진수9', '01089237128', 'afc2023@naver.com', 'USER','골드'),
('test9', '1234', '울산광역시', '김진수10', '01089237128', 'afc2024@naver.com', 'USER','골드'),
('test9', '1234', '울산광역시', '김진수10', '01089237128', 'afc2024@naver.com', 'USER','실버'),
('test9', '1234', '울산광역시', '김진수10', '01089237128', 'afc2024@naver.com', 'USER','골드'),
('test9', '1234', '울산광역시', '김진수10', '01089237128', 'afc2024@naver.com', 'USER','골드'),
('test10', '1234', '울산광역시', '김진수10', '01089237128', 'afc2024@naver.com', 'BIZ','골드');


insert into biz (biz_id , biz_brand_name,biz_balance , file_path)
values (1 , '상호명' , 20000 , 'https://picsum.photos/200/300​');
insert into biz (biz_id , biz_brand_name,biz_balance , file_path)
values (13 , '상호명' , 20000 , 'https://picsum.photos/200/300​');

-- product
insert into product (
	prod_writer_no,
    prod_title ,
    prod_start_time ,
    prod_end_time , 
    prod_space_info,
    prod_goods_info ,
    prod_caution_info ,
    prod_maximum_people, 
    prod_address ,
    prod_detailed_address ,
    prod_price ,
    file_path ,
    prod_major_category_id ,
    prod_subcategory_id ,
    prod_full_address ,
    prod_location_x ,
    prod_location_y
) values (
	1, 
    '타이틀' ,
	1 ,
    24 ,
    '공간 소개',
    '물품 대여 소개' ,
    '예약시 주의 사항' ,
    6 ,
    '주소' ,
    '상세 주소' ,
    50000 ,
    'file_path' ,
    1,
    2,
    '전체 주소' ,
    125.026156153123,35.15165189498
);


insert into admin_prod_history (
	admin_his_no , 
    admin_his_prod_no, 
    admin_his_price ,
    admin_his_user_point ,
    admin_his_save_point ,
    admin_his_discount ,
    admin_his_charge ,
    admin_his_prod_name ,
    admin_his_seller_id ,
    admin_his_comfirm ,
    admin_his_buyer_id ,
    bank ,
    start_time ,
    end_time,
    people_count
) values ('OXDSAD-DNSKAN1' ,1,100000 ,0,0,0,0,'타이틀' , 1,true ,2 ,'부산은행',1,4,2);
