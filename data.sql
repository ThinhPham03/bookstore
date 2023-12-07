CREATE DATABASE data_book;
USE data_book;

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

INSERT INTO Sach (Ten, HinhAnh, Gia, Loai, ThongTinChiTiet)
VALUES
('The Clean Coder: A Code of Conduct for Professional Programmers', 'https://drive.google.com/file/d/1AT-OG75787pUIRp0eIHBhyYioeOREkIy/view?usp=drive_link', 60000, 1, 'A beginner-friendly guide to programming basics.'),
('Code Complete: A Practical Handbook of Software Construction, Second Edition', 'https://drive.google.com/file/d/1d0t077OKhsYM8XV6GSBe2_hSkcPTm66Q/view?usp=drive_link', 60000, 1, 'A beginner-friendly guide to programming basics.'),

('Computer Networking: Principles, Protocols and Practice', 'https://drive.google.com/file/d/1PnNhMGqAw1iDI5yyUaGcWui5ld6dWYC4/view?usp=drive_link', 60000, 2, 'A beginner-friendly guide to programming basics.'),
('Network Warrior: Everything You Need to Know That Wasn''t on the CCNA Exam', 'https://drive.google.com/file/d/1cUJqlQIlhls5NKOFbb7QDnbBle0XeRNz/view?usp=drive_link', 60000, 2, 'A beginner-friendly guide to programming basics.'),

('The Web Application Hacker''s Handbook: Finding and Exploiting Security Flaws', 'https://drive.google.com/file/d/1odrBS0JufhSJ4dDACTfKUr1xjLXPEj3f/view?usp=drive_link', 60000, 3, 'A beginner-friendly guide to programming basics.'),
('Hacking: The Art of Exploitation, 2nd Edition', 'https://drive.google.com/file/d/1lhvLFW3lyhdmk6WC7RIA2m5_TEzgb7oH/view?usp=drive_link', 60000, 3, 'A beginner-friendly guide to programming basics.'),

('Data Science for Business: What You Need to Know about Data Mining and Data-Analytic Thinking', 'https://drive.google.com/file/d/1tMAujG6I_nz_TdiFDp7xXbFzq2lOGLAn/view?usp=drive_link', 60000, 4, 'A beginner-friendly guide to programming basics.'),
('Python for Data Analysis: Data Wrangling with Pandas, NumPy, and IPython', 'https://drive.google.com/file/d/1NlsYAPpXQJoihbCR3mfgxEtxhO0leD8d/view?usp=drive_link', 60000, 4, 'A beginner-friendly guide to programming basics.'),

('Artificial Intelligence: A Modern Approach, Global Edition', 'https://drive.google.com/file/d/1aFmWnysEz6IRBxtR2hH_ScfM0Ou0NvC7/view?usp=drive_link', 60000, 5, 'A beginner-friendly guide to programming basics.'),
('Life 3.0: Being Human in the Age of Artificial Intelligence', 'https://drive.google.com/file/d/1GILdw9J1TsjUElbWkEiuYMlw3wYufAO-/view?usp=drive_link', 60000, 5, 'A beginner-friendly guide to programming basics.');