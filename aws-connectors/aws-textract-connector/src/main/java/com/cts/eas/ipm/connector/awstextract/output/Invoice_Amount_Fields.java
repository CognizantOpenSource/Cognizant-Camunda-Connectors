package com.cts.eas.ipm.connector.awstextract.output;

public class Invoice_Amount_Fields {
    private String invoiceSubTotal="null";
    private String invoiceTaxRate="null";
    private String invoiceTaxAmount="null";
    private String invoiceDiscountAmount="null";
    private String invoiceTotal="null";



    public String getInvoiceSubTotal() {
        return invoiceSubTotal;
    }

    public void setInvoiceSubTotal(String invoiceSubTotal) {
        this.invoiceSubTotal = invoiceSubTotal;
    }

    public String getInvoiceTaxRate() {
        return invoiceTaxRate;
    }

    public void setInvoiceTaxRate(String invoiceTaxRate) {
        this.invoiceTaxRate = invoiceTaxRate;
    }

    public String getInvoiceTaxAmount() {
        return invoiceTaxAmount;
    }

    public void setInvoiceTaxAmount(String invoiceTaxAmount) {
        this.invoiceTaxAmount = invoiceTaxAmount;
    }

    public String getInvoiceDiscountAmount() {
        return invoiceDiscountAmount;
    }

    public void setInvoiceDiscountAmount(String invoiceDiscountAmount) {
        this.invoiceDiscountAmount = invoiceDiscountAmount;
    }

    public String getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(String invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }
}
