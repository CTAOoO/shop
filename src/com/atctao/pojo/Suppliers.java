package com.atctao.pojo;

public class Suppliers {
    private String VendorName;
    private String contacts;
    private String contactNumber;
    private String VendorInformation;

    public Suppliers() {
    }

    public Suppliers(String vendorName, String contacts, String contactNumber, String vendorInformation) {
        VendorName = vendorName;
        this.contacts = contacts;
        this.contactNumber = contactNumber;
        VendorInformation = vendorInformation;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getVendorInformation() {
        return VendorInformation;
    }

    public void setVendorInformation(String vendorInformation) {
        VendorInformation = vendorInformation;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "VendorName='" + VendorName + '\'' +
                ", contacts='" + contacts + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", VendorInformation='" + VendorInformation + '\'' +
                '}';
    }
}
