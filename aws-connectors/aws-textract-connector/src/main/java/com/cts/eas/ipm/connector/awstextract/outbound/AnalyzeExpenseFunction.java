package com.cts.eas.ipm.connector.awstextract.outbound;

import com.cts.eas.ipm.connector.awstextract.input.AWSTextractConnectorInput;
import com.cts.eas.ipm.connector.awstextract.output.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.*;
import software.amazon.awssdk.services.textract.model.AnalyzeExpenseResponse;
import software.amazon.awssdk.services.textract.model.LineItemGroup;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class AnalyzeExpenseFunction {
    private static final Logger LOGGER = LoggerFactory.getLogger(AWSTextractConnector.class);

    public  Object analyzeExpense(TextractClient textractClient, AWSTextractConnectorInput input) {

        try {
         //   HttpURLConnection connection = ((HttpURLConnection)new URL(input.getInData().getSourceDocument()).openConnection());
           // connection.addRequestProperty("User-Agent", "Mozilla/4.0");
            InputStream sourceStream = new FileInputStream(new File(input.getInData().getSourceDocument()));
            SdkBytes sourceBytes = SdkBytes.fromInputStream(sourceStream);

            // Get the input Document object as bytes
            Document myDoc = Document.builder()
                    .bytes(sourceBytes)
                    .build();


            AnalyzeExpenseRequest analyzeDocumentExpenseRequest = AnalyzeExpenseRequest.builder()
                    .document(myDoc)
                    .build();

            software.amazon.awssdk.services.textract.model.AnalyzeExpenseResponse analyzeExpense = textractClient.analyzeExpense(analyzeDocumentExpenseRequest);


            AtomicReference<Invoice> analyzeExpenseContents = new AtomicReference<>();
            AtomicReference<Integer> addressBlock = new AtomicReference<Integer>();
            addressBlock.set(1);
            Invoice invoice = new Invoice();
            Invoice_Records_Header_Fields recordsHeaderFields = new Invoice_Records_Header_Fields();
            Bill_To_Details billToDetails = new Bill_To_Details();
            Ship_To_Details shipToDetails = new Ship_To_Details();
            Supplier_Details supplierDetails = new Supplier_Details();
            Invoice_Key_Fields invoiceKeyFields = new Invoice_Key_Fields();
            Invoice_Amount_Fields invoiceAmountFields = new Invoice_Amount_Fields();
           ;
            analyzeExpense.expenseDocuments().stream().forEach(
                    expenseDocument -> {
                        expenseDocument.summaryFields().stream().forEach(
                                summaryFields -> {

                                    for (ExpenseGroupProperty p : summaryFields.groupProperties()) {
                                        if (p.types().contains("VENDOR")) {
                                            System.out.println(summaryFields.type().text());
                                            if (summaryFields.type().text().equalsIgnoreCase("ZIP_CODE")) {

                                                supplierDetails.setSupplierZipCode(supplierDetails.getSupplierZipCode() + " " + summaryFields.valueDetection().text() != null ? summaryFields.valueDetection().text() : "null");
                                            } else if (summaryFields.type().text().equalsIgnoreCase("STATE")) {

                                                supplierDetails.setSupplierState(supplierDetails.getSupplierState() + " " + summaryFields.valueDetection().text() != null ? summaryFields.valueDetection().text() : "null");
                                            } else if (summaryFields.type().text().equalsIgnoreCase("CITY")) {

                                                supplierDetails.setSupplierCity(supplierDetails.getSupplierCity() + " " + summaryFields.valueDetection().text() != null ? summaryFields.valueDetection().text() : "null");
                                            }
                                        }
                                    }

                                        if (summaryFields.type().text().equalsIgnoreCase("ADDRESS_BLOCK")) {
                                        addressBlock.set(2);

                                    }
                                    if (summaryFields.type().text().equalsIgnoreCase("SUBTOTAL")) {

                                        invoiceAmountFields.setInvoiceSubTotal(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    } else if (summaryFields.type().text().equalsIgnoreCase("TOTAL")) {

                                        invoiceAmountFields.setInvoiceTotal(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    } else if (summaryFields.type().text().equalsIgnoreCase("TAX")) {

                                        invoiceAmountFields.setInvoiceTaxRate(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    }
                                    if (summaryFields.type().text().equalsIgnoreCase("INVOICE_RECEIPT_ID")) {

                                        invoiceKeyFields.setInvoiceNumber(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    } else if (summaryFields.type().text().equalsIgnoreCase("INVOICE_RECEIPT_DATE")) {

                                        invoiceKeyFields.setInvoiceDate(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    } else if (summaryFields.type().text().equalsIgnoreCase("PO_NUMBER")) {

                                        invoiceKeyFields.setPoNumber(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    }


                                    if (summaryFields.type().text().equalsIgnoreCase("VENDOR_ADDRESS")) {

                                        supplierDetails.setSupplierAddress((supplierDetails.getSupplierAddress() != null ? supplierDetails.getSupplierAddress() : "") + " " + summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    } else if (summaryFields.type().text().equalsIgnoreCase("VENDOR_NAME")) {

                                        supplierDetails.setSupplierName((supplierDetails.getSupplierName() != null ? supplierDetails.getSupplierName() : "") + " " + summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    }
                                    if (summaryFields.type().text().equalsIgnoreCase("VENDOR_PHONE")) {

                                        supplierDetails.setSupplierPhoneNumber((supplierDetails.getSupplierPhoneNumber() != null ? supplierDetails.getSupplierPhoneNumber() : "") + " " + summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    } else if (summaryFields.type().text().equalsIgnoreCase("VENDOR_URL")) {

                                        supplierDetails.setSupplierUrl((supplierDetails.getSupplierUrl() != null ? supplierDetails.getSupplierUrl() : "") + " " + summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    } else if (summaryFields.type().text().equalsIgnoreCase("OTHER")) {

                                        supplierDetails.setOthers((supplierDetails.getOthers() != null ? supplierDetails.getOthers() : "") + " " + summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    }
                                   

                                    if (addressBlock.get() == 1) {

                                        if (summaryFields.type().text().equalsIgnoreCase("ADDRESS")) {

                                            billToDetails.setBillToAddress(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        } else if (summaryFields.type().text().equalsIgnoreCase("STREET")) {

                                            billToDetails.setBillToStreet(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                    } else if (summaryFields.type().text().equalsIgnoreCase("STATE")) {

                                            billToDetails.setBillToState(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        } else if (summaryFields.type().text().equalsIgnoreCase("ZIP_CODE")) {

                                            billToDetails.setBillToZipCode(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        } else if (summaryFields.type().text().equalsIgnoreCase("NAME")) {

                                            billToDetails.setBillToName(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        } else if (summaryFields.type().text().equalsIgnoreCase("CITY")) {

                                            billToDetails.setBillToCity(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        }
                                    } else {


                                        if (summaryFields.type().text().equalsIgnoreCase("ADDRESS")) {

                                            shipToDetails.setShipToAddress(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        } else if (summaryFields.type().text().equalsIgnoreCase("STREET")) {

                                            shipToDetails.setShipToStreet(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        } else if (summaryFields.type().text().equalsIgnoreCase("STATE")) {

                                            shipToDetails.setShipToState(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        } else if (summaryFields.type().text().equalsIgnoreCase("ZIP_CODE")) {

                                            shipToDetails.setShipToZipCode(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        } else if (summaryFields.type().text().equalsIgnoreCase("NAME")) {

                                            shipToDetails.setShipToName(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        } else if (summaryFields.type().text().equalsIgnoreCase("CITY")) {

                                            shipToDetails.setShipToCity(summaryFields.valueDetection().text()!=null?summaryFields.valueDetection().text():"null");
                                        }

                                    }

                                });
                    });

            recordsHeaderFields.setInvoiceAmountFields(invoiceAmountFields);
            recordsHeaderFields.setInvoiceKeyFields(invoiceKeyFields);
            recordsHeaderFields.setBillToDetails(billToDetails);
            recordsHeaderFields.setShipToDetails(shipToDetails);
            recordsHeaderFields.setSupplierDetails(supplierDetails);

            List<Invoice_Details_Fields> detailsList = new ArrayList<>();

            analyzeExpense.expenseDocuments().stream().forEach(
                    expenseDocument1 -> {
                        for (LineItemGroup summaryFields1 : expenseDocument1.lineItemGroups()) {

                            for (LineItemFields lineItems : summaryFields1.lineItems()) {
                                int rowNo = 1;
                                Invoice_Details_Fields details = new Invoice_Details_Fields();

                                for (ExpenseField fields : lineItems.lineItemExpenseFields()) {
                                    if (fields.type().text().equalsIgnoreCase("QUANTITY")) {

                                        details.setInvoiceItemQuantity(fields.valueDetection().text()!=null?fields.valueDetection().text():"null");
                                    } else if (fields.type().text().equalsIgnoreCase("UNIT_PRICE")) {

                                        details.setInvoiceItemUnitPrice(fields.valueDetection().text()!=null?fields.valueDetection().text():"null");
                                    } else if (fields.type().text().equalsIgnoreCase("PRICE")) {

                                        details.setInvoiceItemExtendedPrice(fields.valueDetection().text()!=null?fields.valueDetection().text():"null");
                                    } else if (fields.type().text().equalsIgnoreCase("ITEM")) {

                                        details.setInvoiceItemDescription(fields.valueDetection().text()!=null?fields.valueDetection().text():"null");
                                    } else if (fields.type().text().equalsIgnoreCase("OTHER")) {

                                        if(fields.labelDetection()!=null && fields.labelDetection().text().equalsIgnoreCase("ItemNumber")) {

                                            details.setInvoiceItemNumber(fields.valueDetection().text()!=null?fields.valueDetection().text():"null");

                                        }
                                        details.setInvoiceNumber( invoiceKeyFields.getInvoiceNumber());

                                    }
                                    if (fields.type().text().equalsIgnoreCase("EXPENSE_ROW")) {
                                        int j = 0;


                                        detailsList.add(details);
                                        details = new Invoice_Details_Fields();
                                    }

                                    rowNo++;
                                }

                            }
                        }
                    });
            invoice.setInvoiceDetailsFields(detailsList);
            invoice.setInvoiceRecordsHeaderFields(recordsHeaderFields);


            LOGGER.info(AnalyzeExpenseFunction.class.getName() + "Output " + invoice);
            return invoice;
        } catch (Exception e) {

                Map<Object, Object> error = new HashMap<>();
                error.put("error", e.getMessage());
                System.err.println(e.getMessage());
                return error;

        }

    }

}
