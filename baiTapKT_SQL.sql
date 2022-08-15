
--cau 1.	Viết script tạo cấu trúc các bảng. Đối với bảng Mượn Sách cần đánh partition trên trường ngày giờ mượn, và 2 local index 1 index trên trường id bạn đọc, 1 index trên id sách. Tên indexes theo cấu trúc  TENBANG_IDX_TENTRUONG
Create Table VIET_TIEN_VUONG_NXB(
    nxb_id number(4),
    nxb_ma number(4) unique,
    nxb_ten varchar2(10),
    nxb_trang_thai number(1,0),
    nxb_dia_chi varchar2(50),
    nxb_mo_ta varchar2(50),
    CONSTRAINT NXB_PK primary key (nxb_id)
);
drop table VIET_TIEN_VUONG_NXB;


create table VIET_TIEN_VUONG_tac_gia(
    tg_id number(4),
    tg_ma number(4) unique ,
    tg_ten varchar2(10),
    tg_sdt varchar(12),
    tg_dia_chi varchar2(50),
    tg_mo_ta varchar2(50),
    CONSTRAINT tac_gia_pk primary key (tg_id)
);
drop table VIET_TIEN_VUONG_TAC_GIA;


create table VIET_TIEN_VUONG_sach(
    s_id number(4),
    s_ma number(4) unique ,
    s_ten varchar2(10),
    s_id_NXB number(4),
    s_id_tac_gia number(4),
    s_chu_de varchar2(10),
    s_nam_xuat_ban date,
    s_mo_ta varchar2(50),
    s_so_luong_con_lai number,
    s_so_luong_dang_muon number,
    s_tong_so_sach varchar(5),
    CONSTRAINT sach_pk primary key (s_id),
    CONSTRAINT tac_gia_fk FOREIGN KEY (s_id_tac_gia)
    REFERENCES VIET_TIEN_VUONG_tac_gia(tg_id),
    CONSTRAINT nxb_fk FOREIGN KEY (s_id_NXB)
    REFERENCES VIET_TIEN_VUONG_NXB(nxb_id)
);
drop table VIET_TIEN_VUONG_SACH;



create table VIET_TIEN_VUONG_ban_doc(
    bd_id number(4),
    bd_ma number(4) unique ,
    bd_ten varchar2(10),
    bd_sdt varchar2(13),
    bd_dia_chi varchar2(50),
    bd_ngay_sinh date,
    bd_ngay_tao_TK date,
    bd_hang varchar2(5),
    CONSTRAINT ban_doc_pk primary key (bd_id)
);
drop table VIET_TIEN_VUONG_BAN_DOC;

create table VIET_TIEN_VUONG_muon_sach(
    ms_id number(4),
    ms_id_ban_doc number(4),
    ms_id_sach number(4),
    ms_so_luong number(10),
    ms_ngay_gio_muon timestamp,
    ms_ngay_gio_tra date,
    ms_trang_thai number(1,0),
    ms_ghi_chu varchar2(50),
    CONSTRAINT muon_sach_pk primary key (ms_id),
    CONSTRAINT ban_doc_fk FOREIGN KEY (ms_id_ban_doc)
    REFERENCES VIET_TIEN_VUONG_ban_doc(bd_id),
    CONSTRAINT sach_fk foreign key (ms_id_sach)
    REFERENCES VIET_TIEN_VUONG_SACH(s_id)
);
drop table VIET_TIEN_VUONG_muon_sach;
 --cau 2.	Viết script tạo sequence cho mỗi bảng. Sequence được dùng để insert trường Id cho các bảng. Tên sequence theo cấu trúc  TENBANG_SEQ
create sequence VTV_NXB_seq start with 1 increment by 1;
create sequence VTV_tac_gia_seq start with 1 increment by 1;
create sequence VTV_sach_seq start with 1 increment by 1;
create sequence VTV_ban_doc_seq start with 1 increment by 1;
create sequence VTV_muon_sach_seq start with 1 increment by 1;
-- cau 3.	Viết script tạo unique index cho các bảng nếu có.
-- cau 4.	Viết script insert dữ liệu mẫu cho tất cả các bảng.
insert into VIET_TIEN_VUONG_NXB (nxb_id, nxb_ma, nxb_ten, nxb_trang_thai, nxb_dia_chi, nxb_mo_ta) VALUES (VTV_NXB_SEQ.nextval,'1','kim dong','1','ha noi','nxb xin xo');
insert into VIET_TIEN_VUONG_NXB (nxb_id, nxb_ma, nxb_ten, nxb_trang_thai, nxb_dia_chi, nxb_mo_ta) VALUES (VTV_NXB_SEQ.nextval,'2','kim dong2','1','ha noi2','nxb xin xo2');
insert into VIET_TIEN_VUONG_NXB (nxb_id, nxb_ma, nxb_ten, nxb_trang_thai, nxb_dia_chi, nxb_mo_ta) VALUES (VTV_NXB_SEQ.nextval,'3','kim dong3','1','ha noi3','nxb xin xo3');
select  from VIET_TIEN_VUONG_NXB;

insert into VIET_TIEN_VUONG_tac_gia(tg_id, tg_ma, tg_ten, tg_sdt, tg_dia_chi, tg_mo_ta) values (VTV_tac_gia_seq.nextval,'1','nguyen du','09874637537','ha noi','tac gia vip');
insert into VIET_TIEN_VUONG_tac_gia(tg_id, tg_ma, tg_ten, tg_sdt, tg_dia_chi, tg_mo_ta) values (VTV_tac_gia_seq.nextval,'2','nguyen du2','09874637522','ha noi2','tac gia vip2');
insert into VIET_TIEN_VUONG_tac_gia(tg_id, tg_ma, tg_ten, tg_sdt, tg_dia_chi, tg_mo_ta) values (VTV_tac_gia_seq.nextval,'3','nguyen du3','09874637533','ha noi3','tac gia vip3');
select  from VIET_TIEN_VUONG_tac_gia;

insert into VIET_TIEN_VUONG_SACH(s_id, s_ma, s_ten, s_id_NXB, s_id_tac_gia, s_chu_de, s_nam_xuat_ban, s_mo_ta, s_so_luong_con_lai, s_so_luong_dang_muon, s_tong_so_sach) values (VTV_SACH_SEQ.nextval,'1','chi pheo','2','2','lang man','28june2002','sach hay','5','6','20');
insert into VIET_TIEN_VUONG_SACH(s_id, s_ma, s_ten, s_id_NXB, s_id_tac_gia, s_chu_de, s_nam_xuat_ban, s_mo_ta, s_so_luong_con_lai, s_so_luong_dang_muon, s_tong_so_sach) values (VTV_SACH_SEQ.nextval,'2','chi pheo2','2','2','lang man2','28june2002','sach hay2','5','6','20');
insert into VIET_TIEN_VUONG_SACH(s_id, s_ma, s_ten, s_id_NXB, s_id_tac_gia, s_chu_de, s_nam_xuat_ban, s_mo_ta, s_so_luong_con_lai, s_so_luong_dang_muon, s_tong_so_sach) values (VTV_SACH_SEQ.nextval,'3','chi pheo3','2','2','lang man3','28june2002','sach hay3','5','6','20');
select  from VIET_TIEN_VUONG_sach;

insert into VIET_TIEN_VUONG_ban_doc(bd_id, bd_ma, bd_ten, bd_sdt, bd_dia_chi, bd_ngay_sinh, bd_ngay_tao_TK, bd_hang) values (VTV_BAN_DOC_SEQ.nextval,'1','vuong','0364358865','van quan','28july2002','08may2022','KC');
insert into VIET_TIEN_VUONG_ban_doc(bd_id, bd_ma, bd_ten, bd_sdt, bd_dia_chi, bd_ngay_sinh, bd_ngay_tao_TK, bd_hang) values (VTV_BAN_DOC_SEQ.nextval,'2','vuong2','0364358822','van quan2','28july2002','08may2022','KC');
insert into VIET_TIEN_VUONG_ban_doc(bd_id, bd_ma, bd_ten, bd_sdt, bd_dia_chi, bd_ngay_sinh, bd_ngay_tao_TK, bd_hang) values (VTV_BAN_DOC_SEQ.nextval,'3','vuong3','0364358833','van quan3','28july2002','08may2022','KC');
select  from VIET_TIEN_VUONG_ban_doc;

insert into VIET_TIEN_VUONG_muon_sach(ms_id, ms_id_ban_doc, ms_id_sach, ms_so_luong, ms_ngay_gio_muon, ms_ngay_gio_tra, ms_trang_thai, ms_ghi_chu) values (VTV_MUON_SACH_SEQ.nextval,'5','5','5',TO_DATE('2022-08-12 155738', 'YYYY-MM-DD HH24MISS'),TO_DATE('2022-08-12 165738', 'YYYY-MM-DD HH24MISS'),'1','muon 1 chut thoi');
insert into VIET_TIEN_VUONG_muon_sach(ms_id, ms_id_ban_doc, ms_id_sach, ms_so_luong, ms_ngay_gio_muon, ms_ngay_gio_tra, ms_trang_thai, ms_ghi_chu) values (VTV_MUON_SACH_SEQ.nextval,'5','5','5',TO_DATE('2022-08-12 155738', 'YYYY-MM-DD HH24MISS'),TO_DATE('2022-08-12 165738', 'YYYY-MM-DD HH24MISS'),'1','muon 1 chut thoi2');
insert into VIET_TIEN_VUONG_muon_sach(ms_id, ms_id_ban_doc, ms_id_sach, ms_so_luong, ms_ngay_gio_muon, ms_ngay_gio_tra, ms_trang_thai, ms_ghi_chu) values (VTV_MUON_SACH_SEQ.nextval,'5','5','5',TO_DATE('2022-08-12 155738', 'YYYY-MM-DD HH24MISS'),TO_DATE('2022-08-12 165738', 'YYYY-MM-DD HH24MISS'),'1','muon 1 chut thoi3');
select  from VIET_TIEN_VUONG_muon_sach;

--cau 5.	Hiển thị dách sách tác giả và tổng số lượng sách của tác giả gồm các trường thông tin Mã Tác Giả, Tên Tác Giả, Chủ Đề, Số Lượng Sách Sắp xếp theo số lượng sách giảm dần.
select tg_id,tg_ten,s_chu_de,s_tong_so_sach from VIET_TIEN_VUONG_tac_gia,VIET_TIEN_VUONG_sach order by s_tong_so_sach desc;

-- cau 6.	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất gồm các trường thông tin
select s_id,s_ten,nxb_ten,tg_ten,s_chu_de,s_nam_xuat_ban,s_so_luong_con_lai,s_so_luong_dang_muon,s_tong_so_sach from VIET_TIEN_VUONG_sach,VIET_TIEN_VUONG_NXB,VIET_TIEN_VUONG_TAC_GIA
where ROWNUM 10;

-- cau 7.Hiển thị  thông tin bạn đọc và sách được mượn từ ngày đầu tháng hiện tại đến thời điểm hiện tại.
SELECT MA_BANDOC,TEN_BANDOC,MA_SACH,TEN_SACH,NGAYMUON_MUONSACH,SOLUONGCONLAI
FROM DOAN_TU_BANDOC BD JOIN DOAN_TU_MUONSACH MS ON BD.ID = MS.ID_BANDOC JOIN DOAN_TU_SACH S ON MS.ID_SACH = S.ID
ORDER BY MS.NGAYMUON_MUONSACH DESC, BD.TEN_BANDOC ;

-- cau 8.	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất tính từ đầu năm 2022
-- cau 9.	Hiển thị danh sách bạn đọc và số lần mượn sách tính từ đầu năm 2022 sắp xếp theo tên bạn đọc tăng dần Mã Bạn Đọc, Tên Bạn Đọc, Số Lần Mượn
--cau 10.	Hiển thị thông tin bạn đọc gồm có Mã Bạn Đọc, Tên Bạn Đọc, Tuổi (được tính dựa vào trường ngày sinh)
select bd_id,bd_ten,EXTRACT(YEAR FROM sysdate) - EXTRACT(YEAR FROM bd_ngay_sinh) as tuoi from VIET_TIEN_VUONG_ban_doc
-- cau 11.	Thống kê tổng số bạn đọc theo độ Tuổi, Tổng số Bạn Đọc
SELECT (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(bd_ngay_sinh,'YYYY')) AS TUỔI ,COUNT(bd_id) AS TỔNGSỐBẠNĐỌC
FROM VIET_TIEN_VUONG_ban_doc GROUP BY (TO_CHAR(SYSDATE,'YYYY'))- TO_CHAR(bd_ngay_sinh,'YYYY');
--cau 12.	Thống kê số lượng sách được xuất bản theo Nhà Xuất Bản, Theo năm xuất bản.