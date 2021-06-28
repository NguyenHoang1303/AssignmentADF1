package assignment.entity;

import java.time.LocalDate;
import java.util.Calendar;

public class Oder {
//    Mã đơn hàng (ví dụ: “Order001”, “Order002”)
//    Tên người mua (lưu dạng chuỗi, không có lớp User ở đây, ví dụ: “Xuân Hùng” )
//    Tên các sản phẩm (đơn giản lưu tên các sản phẩm có trong đơn hàng, không có lớp Product ở đây, ví dụ: 2 mớ rau, 1kg thịt, 2kg táo….)
//    Tổng số tiền (dạng số, đơn vị vnd).
//    Ngày tạo đơn hàng (định dạng ngày tháng theo format yyyy-MM-DD).
//    Trạng thái đơn hàng (1. Chưa thanh toán. 2. Đã thanh toán. 0. Đã xoá)
    private  String orderId;
    private String userName;
    private String products;
    private LocalDate creatAt;
    private int totalPrice;
    private int status;

    public Oder() {

    }

    @Override
    public String toString() {
        return String.format("%5s%10s%10s | %5s%15s%15s | %5s%20s%18s | %5s%10s%10s | %5s%5s%5s | %5s%10s%5s |\n",
                "", orderId,"",
                "", userName,"",
                "", products,"",
                "", totalPrice,"",
                "", status,"",
                "", this.getCreatAt(),""
        );
    }

    public Oder(String orderId, String userName, String products, int totalPrice, int status) {
        this.orderId = orderId;
        this.userName = userName;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
        this.creatAt = LocalDate.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public LocalDate getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(LocalDate creatAt) {
        this.creatAt = creatAt;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
