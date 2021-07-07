﻿CREATE DATABASE STORAGEMS
GO
USE STORAGEMS
GO
--DROP DATABASE STORAGEMS

--------------------------------------------------------
-- TAO BANG --

CREATE TABLE LOAIHANGHOA (
	MALHH INT IDENTITY(1,1) PRIMARY KEY,
	TENLHH NVARCHAR(50) NOT NULL,
)
GO

CREATE TABLE HANGHOA (
	MAHH VARCHAR(10) PRIMARY KEY NOT NULL,
	TENHH NVARCHAR(50) NOT NULL,
	DONGIA FLOAT DEFAULT 0,
	DONVITINH NVARCHAR(10) NOT NULL,
	MALHH INT NULL,
	
	CONSTRAINT CHK_HANGHOA CHECK (DONGIA>=0)
)
GO

CREATE TABLE LOAIDOITAC(
	MALDT INT IDENTITY(1,1) PRIMARY KEY,
	TENLDT VARCHAR(50) NOT NULL,
)
GO

CREATE TABLE DOITAC(
	MADT INT IDENTITY(1,1) PRIMARY KEY,
	TENDT NVARCHAR(50) NOT NULL,
	DIACHI NVARCHAR(50) NOT NULL,
	EMAIL VARCHAR(50) NULL,
	SODT VARCHAR(15) NOT NULL,
	VAITRO BIT DEFAULT 1,
	MALDT INT NULL
)
GO

CREATE TABLE KHO(
	MAKHO INT PRIMARY KEY NOT NULL,
	DIACHI NVARCHAR(50) NOT NULL,
	MATK VARCHAR(10) NULL
)
GO

CREATE TABLE LUUTRU(
	MALT INT IDENTITY(1,1) PRIMARY KEY,
	MAKHO INT NOT NULL,
	MAHH VARCHAR(10) NOT NULL,
	SOLUONG FLOAT DEFAULT 0,

	CHECK (SOLUONG>=0)
)
GO

CREATE TABLE CHITIETPHIEU(
	MACTP INT IDENTITY(1,1) PRIMARY KEY,
	MAPHIEU INT NOT NULL,
	MALT INT NOT NULL,
	SOLUONG FLOAT DEFAULT 0,
	DONGIA FLOAT DEFAULT 0,

	CONSTRAINT chk_CHITIETPHIEU CHECK (SOLUONG>=0 AND DONGIA>=0)
)	
GO

CREATE TABLE PHIEU (
	MAPHIEU INT IDENTITY(1,1) PRIMARY KEY,
	NGAYLAP DATETIME DEFAULT GETDATE(),
	LOAI BIT NULL,
	TRANGTHAI BIT DEFAULT 0,
	NGTHUCHIEN DATE NOT NULL,
	NGHOANTHANH DATE NULL,
	MADT INT NOT NULL,
	MANV VARCHAR(10) NOT NULL,

	CONSTRAINT CHK_PHIEU CHECK ((NGHOANTHANH IS NULL) OR (NGHOANTHANH>NGTHUCHIEN))
)
GO

CREATE TABLE CHITIETKIEMKHO(
	MACTKK INT IDENTITY(1,1) PRIMARY KEY,
	SOLUONGTON FLOAT DEFAULT 0 NOT NULL,
	SOLUONGTHUC FLOAT DEFAULT 0 NOT NULL,
	GHICHU NVARCHAR(50) NULL,
	MAKK INT NOT NULL,
	MALT INT NOT NULL,

	CONSTRAINT CHK_CHITIETKIEMKHO CHECK (SOLUONGTON>=0 AND SOLUONGTHUC>=0)
)
GO

CREATE TABLE PHIEUKIEMKHO(
	MAKK INT IDENTITY(1,1) PRIMARY KEY,
	NGAYLAP DATETIME DEFAULT GETDATE(),
	NGAYKIEM DATE NOT NULL,
	TRANGTHAI BIT DEFAULT 0,
	MANV VARCHAR(10) NOT NULL
)
GO

CREATE TABLE NHANVIEN(
	MANV VARCHAR(10) PRIMARY KEY NOT NULL,
	TENNV VARCHAR(50) NOT NULL,
	VAITRO BIT NOT NULL DEFAULT 0,
	MATKHAU VARCHAR(15) NOT NULL,
	MUOI VARCHAR(15) NOT NULL,
)
GO
	
--------------------------------------------------------
-- KET NOI CAC BANG --
--
ALTER TABLE HANGHOA
ADD CONSTRAINT FK_HANGHOA_LOAIHANGHOA
FOREIGN KEY (MALHH) REFERENCES LOAIHANGHOA(MALHH);
GO
--
ALTER TABLE DOITAC
ADD CONSTRAINT FK_DOITAC_LOAIDOITAC
FOREIGN KEY (MALDT) REFERENCES LOAIDOITAC(MALDT);
GO
--
ALTER TABLE PHIEU
ADD CONSTRAINT FK_PHIEU_DOITAC
FOREIGN KEY (MADT) REFERENCES DOITAC(MADT);

ALTER TABLE PHIEU
ADD CONSTRAINT FK_PHIEU_NHANVIEN
FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV);
GO
--
ALTER TABLE CHITIETPHIEU
ADD CONSTRAINT FK_CHITIETPHIEU_PHIEU
FOREIGN KEY (MAPHIEU) REFERENCES PHIEU(MAPHIEU);

ALTER TABLE CHITIETPHIEU
ADD CONSTRAINT FK_CHITIETPHIEU_LUUTRU
FOREIGN KEY (MALT) REFERENCES LUUTRU(MALT);
GO
--
ALTER TABLE LUUTRU
ADD CONSTRAINT FK_LUUTRU_KHO
FOREIGN KEY (MAKHO) REFERENCES KHO(MAKHO);
GO
ALTER TABLE LUUTRU
ADD CONSTRAINT FK_LUUTRU_HANGHOA
FOREIGN KEY (MAHH) REFERENCES HANGHOA(MAHH);
GO
--
ALTER TABLE KHO
ADD CONSTRAINT FK_KHO_NHANVIEN
FOREIGN KEY (MATK) REFERENCES NHANVIEN(MANV);
GO
--
ALTER TABLE PHIEUKIEMKHO
ADD CONSTRAINT FK_PHIEUKIEMKHO_NHANVIEN
FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV);
GO
--
ALTER TABLE CHITIETKIEMKHO
ADD CONSTRAINT FK_CHITIETKIEMKHO_PHIEUKIEMKHO
FOREIGN KEY (MAKK) REFERENCES PHIEUKIEMKHO(MAKK);
GO
ALTER TABLE CHITIETKIEMKHO
ADD CONSTRAINT FK_CHITIETKIEMKHO_LUUTRU
FOREIGN KEY (MALT) REFERENCES LUUTRU(MALT);
GO
--------------------------------------------------------
-- NHAP LIEU --
--








--------------------------------------------------------
-- TAO TRIGGER --
--













