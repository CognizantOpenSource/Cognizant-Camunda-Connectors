package com.cts.eas.ipm.connector.awstextract.output;

import java.util.List;

public class Invoice {
    private Invoice_Records_Header_Fields invoiceRecordsHeaderFields;
    private List<Invoice_Details_Fields> invoiceDetailsFields;

    public Invoice_Records_Header_Fields getInvoiceRecordsHeaderFields() {
        return invoiceRecordsHeaderFields;
    }

    public void setInvoiceRecordsHeaderFields(Invoice_Records_Header_Fields invoiceRecordsHeaderFields) {
        this.invoiceRecordsHeaderFields = invoiceRecordsHeaderFields;
    }

    public List<Invoice_Details_Fields> getInvoiceDetailsFields() {
        return invoiceDetailsFields;
    }

    public void setInvoiceDetailsFields(List<Invoice_Details_Fields> invoiceDetailsFields) {
        this.invoiceDetailsFields = invoiceDetailsFields;
    }


}
