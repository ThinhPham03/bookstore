create database data_book;
use data_book;

CREATE TABLE TheLoaiSach(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Ten VARCHAR(100)
);

CREATE TABLE Sach(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Ten VARCHAR(255),
    HinhAnh VARCHAR(255),
    Gia INT,
    Loai INT,
    ThongTinChiTiet TEXT,
    FOREIGN KEY (Loai) REFERENCES TheLoaiSach(ID)
);

CREATE TABLE TheLoaiTaiKhoan(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Ten VARCHAR(50)
);

CREATE TABLE TaiKhoan (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    HoTen VARCHAR(255),
    SoDienThoai VARCHAR(15),
    Email VARCHAR(255),
    DiaChi VARCHAR(255),
    Loai INT,
    MatKhau VARCHAR(255),
    FOREIGN KEY (Loai) REFERENCES TheLoaiTaiKhoan(ID)
);

INSERT INTO TheLoaiSach (Ten)
VALUES
('Lập trình'),
('Mạng máy tính'),
('An toàn thông tin'),
('Phân tích dữ liệu'),
('Trí tuệ nhân tạo');
    
INSERT INTO TheLoaiTaiKhoan (Ten)
VALUES
('Quản trị viên'),
('Người dùng');

CREATE TABLE DonHang (
    MaDonHang INT AUTO_INCREMENT PRIMARY KEY,
    IDNguoiDat INT,
    ThoiGianDat datetime,
    DaXacNhan bool,
    FOREIGN KEY (IDNguoiDat) REFERENCES TaiKhoan(ID)
);

CREATE TABLE ChiTietDonHang (
    MaDonHang INT,
    IDSach INT,
    SoLuong INT,
    FOREIGN KEY (MaDonHang) REFERENCES DonHang(MaDonHang),
    FOREIGN KEY (IDSach) REFERENCES Sach(ID)
);

INSERT INTO Sach (Ten, HinhAnh, Gia, Loai, ThongTinChiTiet)
VALUES
('The Clean Coder: A Code of Conduct for Professional Programmers', '/img/LapTrinh/CleanCode.jpg', 60000, 1, 'A beginner-friendly guide to programming basics.'),
('Code Complete: A Practical Handbook of Software Construction, Second Edition', '/img/LapTrinh/CodeComplete.jpg', 60000, 1, 'A beginner-friendly guide to programming basics.'),

('Computer Networking: Principles, Protocols and Practice', '/img/MangMayTinh/ComputerNetworking.jpg', 60000, 2, 'A beginner-friendly guide to programming basics.'),
('Network Warrior: Everything You Need to Know That Wasn''t on the CCNA Exam', '/img/MangMayTinh/NetworkWarrior.jpg', 60000, 2, 'A beginner-friendly guide to programming basics.'),

('The Web Application Hacker''s Handbook: Finding and Exploiting Security Flaws', '/img/AnToanThongTin/HackerHandbook.jpg', 60000, 3, 'A beginner-friendly guide to programming basics.'),
('Hacking: The Art of Exploitation, 2nd Edition', '/img/AnToanThongTin/Hacking.jpg', 60000, 3, 'A beginner-friendly guide to programming basics.'),

('Data Science for Business: What You Need to Know about Data Mining and Data-Analytic Thinking', '/img/PhanTichDuLieu/DataScience.jpg', 60000, 4, 'A beginner-friendly guide to programming basics.'),
('Python for Data Analysis: Data Wrangling with Pandas, NumPy, and IPython', '/img/PhanTichDuLieu/DataAnalysis.jpg', 60000, 4, 'A beginner-friendly guide to programming basics.'),

('Artificial Intelligence: A Modern Approach, Global Edition', '/img/TriTueNhanTao/ArtificialIntelligence.jpg', 60000, 5, 'A beginner-friendly guide to programming basics.'),
('Life 3.0: Being Human in the Age of Artificial Intelligence', '/img/TriTueNhanTao/Life3.jpg', 60000, 5, 'A beginner-friendly guide to programming basics.');

INSERT INTO TaiKhoan (HoTen, Loai, MatKhau)
VALUES 
('admin',  1, 'admin'),
('user', 2, 'user');

INSERT INTO DonHang (IDNguoiDat, ThoiGianDat, DaXacNhan) VALUES (1, '2023-01-15 08:30:00', true);
INSERT INTO ChiTietDonHang (MaDonHang, IDSach, SoLuong)
VALUES 
(1, 1, 2),
(1, 3, 1),
(1, 5, 3);

INSERT INTO DonHang (IDNguoiDat, ThoiGianDa, DaXacNhan) VALUES (2, '2023-02-10 12:45:00', false);
INSERT INTO ChiTietDonHang (MaDonHang, IDSach, SoLuong)
VALUES 
(2, 2, 1),
(2, 4, 2),
(2, 6, 1);
