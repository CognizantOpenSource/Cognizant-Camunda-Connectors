package com.cts.eas.ipm.connector.awstextract.output;

public class Invoice_Records_Header_Fields {
    private Invoice_Key_Fields invoiceKeyFields;
    private Supplier_Details supplierDetails;
    private Bill_To_Details billToDetails;
    private Ship_To_Details shipToDetails;

    private Invoice_Amount_Fields invoiceAmountFields;



    public Invoice_Key_Fields getInvoiceKeyFields() {
        return invoiceKeyFields;
    }

    public void setInvoiceKeyFields(Invoice_Key_Fields invoiceKeyFields) {
        this.invoiceKeyFields = invoiceKeyFields;
    }

    public Supplier_Details getSupplierDetails() {
        return supplierDetails;
    }

    public void setSupplierDetails(Supplier_Details supplierDetails) {
        this.supplierDetails = supplierDetails;
    }

    public Bill_To_Details getBillToDetails() {
        return billToDetails;
    }

    public void setBillToDetails(Bill_To_Details billToDetails) {
        this.billToDetails = billToDetails;
    }

    public Ship_To_Details getShipToDetails() {
        return shipToDetails;
    }

    public void setShipToDetails(Ship_To_Details shipToDetails) {
        this.shipToDetails = shipToDetails;
    }

    public Invoice_Amount_Fields getInvoiceAmountFields() {
        return invoiceAmountFields;
    }

    public void setInvoiceAmountFields(Invoice_Amount_Fields invoiceAmountFields) {
        this.invoiceAmountFields = invoiceAmountFields;
    }
}
