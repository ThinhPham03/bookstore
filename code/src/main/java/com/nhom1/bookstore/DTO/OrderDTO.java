package com.nhom1.bookstore.DTO;

import java.util.List;

public class OrderDTO {
    private List<BookDTO> BookList;
    private String Price;
    private String Phone;
    private String Address;
    private String PaymentMethod;

    public class BookDTO {
        private String ID;
        private int SoLuong;

        public String getID() {
            return ID;
        }
        public void setID(String iD) {
            ID = iD;
        }
        public int getSoLuong() {
            return SoLuong;
        }
        public void setSoLuong(int soLuong) {
            SoLuong = soLuong;
        }
    }

    public List<BookDTO> getBookList() {
        return BookList;
    }

    public void setBookList(List<BookDTO> bookList) {
        BookList = bookList;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }
    
}



