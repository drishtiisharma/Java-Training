package com.pojo;

public class OrderItem {
    private int itemId;
    private int orderId;
    private int pid;
    private int quantity;
    private double price;
    private String productName;  
    private String imageUrl;     

    public OrderItem() {
        super();
    }

    public OrderItem(int itemId, int orderId, int pid, int quantity, 
                    double price, String productName, String imageUrl) {
        super();
        this.itemId = itemId;
        this.orderId = orderId;
        this.pid = pid;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // New getters and setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "OrderItem [itemId=" + itemId + ", orderId=" + orderId + 
               ", pid=" + pid + ", quantity=" + quantity + ", price=" + price + 
               ", productName=" + productName + ", imageUrl=" + imageUrl + "]";
    }
}