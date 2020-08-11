package org.demon.spring5;

public class Order {

    private String oName;
    private String address;

    public Order(String oName, String address) {
        this.oName = oName;
        this.address = address;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oName='" + oName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
