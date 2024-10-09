	package com.cts.eas.ipm.connector.awstextract.outbound;

    import com.cts.eas.ipm.connector.awstextract.input.AWSTextractConnectorInput;

	import com.cts.eas.ipm.connector.awstextract.output.*;
	import com.cts.eas.ipm.connector.awstextract.output.AnalyzeExpenseResponse;
	import com.cts.eas.ipm.connector.awstextract.output.LineItemGroup;
	import com.cts.eas.ipm.connector.outbound.CoreOutboundConnector;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import io.camunda.connector.api.outbound.OutboundConnectorContext;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
	import software.amazon.awssdk.auth.credentials.SystemPropertyCredentialsProvider;
	import software.amazon.awssdk.core.SdkBytes;
	import software.amazon.awssdk.regions.Region;
	import software.amazon.awssdk.services.textract.TextractClient;
	import software.amazon.awssdk.services.textract.model.*;

	import java.io.*;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
    import java.util.*;
    import java.util.concurrent.atomic.AtomicReference;

	public class AWSTextractConnector implements CoreOutboundConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(AWSTextractConnector.class);




		enum AWSTextractOperations {
			analyzeExpenses,analyzeId,analyzeDocument

	}


	@Override
	public Object executeContext(OutboundConnectorContext context) {
		 var input = context.bindVariables(AWSTextractConnectorInput.class);
		LOGGER.debug("Input :"+input.toString());
        return executeConnector(input);
	}

	private Object executeConnector(AWSTextractConnectorInput input) {

		Object result = null;

		String sourceDoc = input.getInData().getSourceDocument();
		Region region = Region.of(input.getAuthentication().getRegion());
		System.setProperty("aws.accessKeyId",input.getAuthentication().getAccessKey());
		System.setProperty("aws.secretAccessKey",input.getAuthentication().getSecretKey());


		TextractClient textractClient = TextractClient.builder()
				.region(region)
				.credentialsProvider(SystemPropertyCredentialsProvider.create())
				.build();

		switch (AWSTextractOperations.valueOf(input.getInData().getOperation())) {
			case analyzeExpenses:

				result = new AnalyzeExpenseFunction().analyzeExpense(textractClient, input);
				textractClient.close();

				break;
			case analyzeId:
					result = new AnalyzeIdFunction().analyzeId(textractClient, input);
				textractClient.close();
				break;
			case analyzeDocument:
					result = new AnalyzeDocumentFunction().analyzeDocument(textractClient, input);
				textractClient.close();
				break;
			default:
				throw new UnsupportedOperationException("Unsupported Operation");
			}
		return result;

	}

public static void main(String args[]) throws IOException {
		String path="C:\\Users\\745440\\Downloads\\IPR000820_CamundaCustomConnectors2\\IPR000820_CamundaCustomConnectors\\aws-connectors\\aws-textract-connector\\src\\main\\resources";
	String analyzeDocResponse=path+"\\analyzeDocResponse.json";
	String analyzeIdResponse=path+"\\analyzeIdResponse.json";
String analyzeExpenseResponse = path+"\\analyzeExpenseResponse.json";
	String analyzeLendingResponse = path+"\\analyzeLendingResponse.json";

	ObjectMapper mapper = new ObjectMapper();
    String res="{\"invoiceRecordsHeaderFields\":{\"invoiceKeyFields\":{\"invoiceNumber\":\"181038\",\"invoiceDate\":\"Jun 26, 2020\",\"poNumber\":\"00001\"},\"supplierDetails\":{\"supplierName\":\" tess\\n® AMERICAN\\nEXPRESS\",\"supplierAddress\":\" 2328 Truax Boulevard\\nEau Claire, WI 54703\",\"supplierPhoneNumber\":\" (715) 832-7271 (800) 762-1765\",\"supplierUrl\":\" www.TessOralHealth.com\",\"others\":\" (715) 832-0093 UPS\"},\"billToDetails\":{\"billToName\":\"Tess Oral Health\",\"billToAddress\":\"Tess Oral Health\\n123 Main Street\\nAnywhere, CA 12345\",\"billToStreet\":\"123 Main Street\",\"billToZipCode\":\"12345\",\"billToState\":\"CA\"},\"shipToDetails\":{\"shipToName\":\"AMERICAN\\nEXPRESS\",\"shipToAddress\":\"2328 Truax Boulevard\\nEau Claire, WI 54703\",\"shipToCity\":\"Eau Claire,\",\"shipToZipCode\":\"54703\",\"shipToState\":\"WI\",\"shipToStreet\":\"2328 Truax Boulevard\"},\"invoiceAmountFields\":{\"invoiceSubTotal\":\"106.56\",\"invoiceTaxRate\":\"8.45\",\"invoiceTotal\":\"125.01\"}},\"invoiceDetailsFields\":[{\"invoiceItemDescription\":\"Accent Adult\",\"invoiceItemQuantity\":\"144\",\"invoiceItemUnitPrice\":\"0.74\",\"invoiceItemExtendedPrice\":\"106.56\"}]}";
    System.out.print(res.replaceAll("\\\"","\""));


    try {
/*		 AtomicReference<String> analyzeDocumentContents= new AtomicReference<>("<html><body><table border='1'><tr><td colspan='2'>KEY VALUES</td></tr>");
		AnalyzeDocumentResponse out = mapper.readValue(new File(analyzeDocResponse), AnalyzeDocumentResponse.class);
				System.out.println("out:"+out.getBlocks().get(1).getText().toString());
out.getBlocks().stream().filter(s -> Objects.nonNull(s.getText())&&s.getBlockType().equalsIgnoreCase("LINE")).
		forEach(s ->{	analyzeDocumentContents.set(analyzeDocumentContents + "<tr><td>" + s.getText() + "</td></tr>");
				s.getRelationships().stream().filter(
						r1 -> Objects.nonNull(r1.getIds())).
						forEach(r1 ->
								out.getBlocks().stream().filter(
										bl->r1.getIds().contains(bl.getId())).
										forEach(s1 ->{}));});


        Map<Double, List> map1 = new HashMap<>();

        out.getBlocks().stream().filter(s -> s.getBlockType().equalsIgnoreCase("KEY_VALUE_SET")).forEach(
				s1->{
					System.out.println(s1.getConfidence()+"ssss");
					if (map1.get(s1.getConfidence()) ==null) {
						map1.put(s1.getConfidence(),s1.getRelationships());
                    } else {
						map1.get(s1.getConfidence()).addAll(s1.getRelationships());
					}
				}
		);
		System.out.println("Confidence"+map1.size());

	for(Double confidence:map1.keySet()) {
		System.out.println("Confidence=======================" + confidence);
		List<Relationship> list = map1.get(confidence);

			for (Relationship relationship : list) {
				for (String id : relationship.getIds()) {

					System.out.println(out.getBlocks().stream().filter(s -> s.getId().equalsIgnoreCase(id)).findAny().get().getText());

				}
			}

	}//QUERYANSWERS
		 Map<String, List> map2= new HashMap<>();

		out.getBlocks().stream().filter(s -> s.getBlockType().equalsIgnoreCase("QUERY")).forEach(
				s1->{
					System.out.println(s1.getQuery().getText()+"ssss");
					if (map2.get(s1.getQuery().getText()) ==null) {
						map2.put(s1.getQuery().getText(),s1.getRelationships());
					} else {
						map2.get(s1.getQuery().getText()).addAll(s1.getRelationships());
					}
				}
		);
		System.out.println("query"+map2.size());
		analyzeDocumentContents.set(analyzeDocumentContents + "<tr><td colspan='2'>Question Answers</td></tr>");

		for(String queryQuestion:map2.keySet()) {
			System.out.println("queryQuestion=======================" + queryQuestion);
			analyzeDocumentContents.set(analyzeDocumentContents + "<tr><td>"+queryQuestion+"</td>");

			List<Relationship> list = map2.get(queryQuestion);

			for (Relationship relationship : list) {
				if(relationship.getType().equalsIgnoreCase("ANSWER")) {
					for (String id : relationship.getIds()) {

						System.out.println(out.getBlocks().stream().filter(s -> s.getId().equalsIgnoreCase(id)).findAny().get().getText());
						analyzeDocumentContents.set(analyzeDocumentContents + "<td>"+out.getBlocks().stream().filter(s -> s.getId().equalsIgnoreCase(id)).findAny().get().getText()+"</td></tr>");

					}
				}
			}

		}
		analyzeDocumentContents.set(analyzeDocumentContents+"</table></body></html>");
				Path analyzeDocumentpath = Paths.get(path+"\\analyzeDocumentResponse.html");
		byte[] strToBytes = analyzeDocumentContents.get().getBytes();

		Files.write(analyzeDocumentpath, strToBytes);*/
			/*	 AtomicReference<String> analyzeIdContents= new AtomicReference<>("<html><body><table border='1'><tr><td colspan='2'>KEY VALUES</td></tr>");

		AnalyzeIDResponse out = mapper.readValue(new File(analyzeIdResponse), AnalyzeIDResponse.class);



		out.getIdentityDocuments().stream().forEach(
				identityDocumentFields->{
					identityDocumentFields.getIdentityDocumentFields().stream().forEach(
							key1->{analyzeIdContents.set(analyzeIdContents+"<tr><td>"+key1.getType().getText()+"</td><td>"+key1.getValueDetection().getText()+"</td></tr>");});});
								//					bl->r1.getIds().contains(bl.getId())&&
								//							bl.getConfidence().toString().equalsIgnoreCase(s.getConfidence().toString())).forEach(s3->

		analyzeIdContents.set(analyzeIdContents+"</table></body></html>");
		Path analyzeIdpath = Paths.get(path+"\\analyzeIdResponse.html");
		byte[] strToBytes = analyzeIdContents.get().getBytes();

		Files.write(analyzeIdpath, strToBytes);*/
	/*	com.cts.eas.ipm.connector.awstextract.output.AnalyzeExpenseResponse out = mapper.readValue(new File(analyzeExpenseResponse), com.cts.eas.ipm.connector.awstextract.output.AnalyzeExpenseResponse.class);
		AtomicReference<Map<String,String>> analyzeExpenseContents= new AtomicReference<>();
		Map<String,String> map = new HashMap<String,String>();
		out.getExpenseDocuments().stream().forEach(
				expenseDocument->{
					expenseDocument.getSummaryFields().stream().forEach(
							summaryFields->{map.put(summaryFields.getType().getText(),summaryFields.getValueDetection().getText());});});
		List res=new ArrayList<>();
		int j = 1;
		out.getExpenseDocuments().stream().forEach(
				expenseDocument->{
					for (LineItemGroup summaryFields : expenseDocument.getLineItemGroups()) {
						for (LineItem lineItems : summaryFields.getLineItems()) {
							int check = 1;

							LinkedHashMap<String,LinkedHashMap<String, String>> mapList = new LinkedHashMap<>();
							LinkedHashMap<String,String> map1 = new LinkedHashMap<>();
							for (LineItemExpenseField fields : lineItems.getLineItemExpenseFields()) {
								map1.put(fields.getType().getText(), fields.getValueDetection().getText());

								if (fields.getType().getText().equalsIgnoreCase("EXPENSE_ROW") ){
									map1.put(fields.getType().getText(), fields.getValueDetection().getText());


									mapList.put("ExpenseRow",map1);
									map1= new LinkedHashMap<>();

									j++;
								}


							}
							res.add(mapList.toString());

						}
					}});
		map.put("Table",res.toString());
		*/
/*
		com.cts.eas.ipm.connector.awstextract.output.AnalyzeExpenseResponse out = mapper.readValue(new File(analyzeExpenseResponse), AnalyzeExpenseResponse.class);

		AtomicReference<String> analyzeExpenseContents= new AtomicReference<>("<html><body><table border='1'><tr><td colspan='2'>KEY VALUES</td></tr>");

		out.getExpenseDocuments().stream().forEach(
				expenseDocument->{
					expenseDocument.getSummaryFields().stream().forEach(
							summaryFields->{analyzeExpenseContents.set(analyzeExpenseContents+"<tr><td>"+
									summaryFields.getType().getText()+"</td><td>"+
									summaryFields.getValueDetection().getText()+"</td></tr>");});});

		out.getExpenseDocuments().stream().forEach(
				expenseDocument->{
                    for (LineItemGroup summaryFields : expenseDocument.getLineItemGroups()) {
                        analyzeExpenseContents.set(analyzeExpenseContents + "<tr><td>" + summaryFields.getLineItemGroupIndex() + "</td></tr>");
                        for (LineItem lineItems : summaryFields.getLineItems()) {
							int check = 1;
							Map<String, String> map = new LinkedHashMap<>();

							for (LineItemExpenseField fields : lineItems.getLineItemExpenseFields()) {
								map.put(fields.getType().getText(), fields.getValueDetection().getText());
								if (fields.getType().getText().equalsIgnoreCase("EXPENSE_ROW") ){
									int j = 0;

									System.out.println(check+"55555555555555555555");

										analyzeExpenseContents.set(analyzeExpenseContents + "<tr>");

										for (String key : map.keySet()) {
											analyzeExpenseContents.set(analyzeExpenseContents + "<td>" +
													key + "</td><td>" + map.get(key)
													+ "</td>");
										}
										analyzeExpenseContents.set(analyzeExpenseContents + "</tr>");


									map = new LinkedHashMap<>();
								}


							}

                    }
                }});

		analyzeExpenseContents.set(analyzeExpenseContents+"</table></body></html>");
		Path analyzeExpensepath = Paths.get(path+"\\analyzeExpenseContents_synovaimagee.html");
		byte[] strToBytes = analyzeExpenseContents.get().getBytes();

		Files.write(analyzeExpensepath, strToBytes);*/
	/*	AnalyzeExpenseResponse out = mapper.readValue(new File(analyzeExpenseResponse), AnalyzeExpenseResponse.class);
		AtomicReference<Map<String,String>> analyzeExpenseContents= new AtomicReference<>();
Map<String,String> map = new HashMap<String,String>();
out.getExpenseDocuments().stream().forEach(
				expenseDocument->{
					expenseDocument.getSummaryFields().stream().forEach(
							summaryFields->{map.put(summaryFields.getType().getText(),summaryFields.getValueDetection().getText());});});
		List res=new ArrayList<>();
		int j = 1;
		out.getExpenseDocuments().stream().forEach(
				expenseDocument->{
					for (LineItemGroup summaryFields : expenseDocument.getLineItemGroups()) {
						for (LineItem lineItems : summaryFields.getLineItems()) {
							int check = 1;

							LinkedHashMap<String,LinkedHashMap<String, String>> mapList = new LinkedHashMap<>();
							LinkedHashMap<String,String> map1 = new LinkedHashMap<>();
							for (LineItemExpenseField fields : lineItems.getLineItemExpenseFields()) {
								map1.put(fields.getType().getText(), fields.getValueDetection().getText());

								if (fields.getType().getText().equalsIgnoreCase("EXPENSE_ROW") ){
									map1.put(fields.getType().getText(), fields.getValueDetection().getText());


									mapList.put("ExpenseRow",map1);
									map1= new LinkedHashMap<>();

								}


							}
							res.add(mapList.toString());

						}
					}});
		map.put("Table",res.toString());*/
		com.cts.eas.ipm.connector.awstextract.output.AnalyzeExpenseResponse out = mapper.readValue(new File(analyzeExpenseResponse), AnalyzeExpenseResponse.class);
		AtomicReference<Invoice> analyzeExpenseContents= new AtomicReference<>();
		AtomicReference<Integer> addressBlock = new AtomicReference<Integer>();
		addressBlock.set(1);
Invoice invoice=new Invoice();
		Invoice_Records_Header_Fields recordsHeaderFields=new Invoice_Records_Header_Fields();
		Bill_To_Details billToDetails = new Bill_To_Details();
		Ship_To_Details shipToDetails = new Ship_To_Details();
		Supplier_Details supplierDetails = new Supplier_Details();
		Invoice_Key_Fields invoiceKeyFields =new Invoice_Key_Fields();
		Invoice_Amount_Fields invoiceAmountFields=new Invoice_Amount_Fields();

		out.getExpenseDocuments().stream().forEach(
				expenseDocument->{
					expenseDocument.getSummaryFields().stream().forEach(
							summaryFields-> {
                                for (GroupProperty p : summaryFields.getGroupProperties()) {
                                    if (p.getTypes().contains("VENDOR")) {
										System.out.println(summaryFields.getType().getText());
										if (summaryFields.getType().getText().equalsIgnoreCase("ZIP_CODE")) {

											supplierDetails.setSupplierZipCode(supplierDetails.getSupplierZipCode() + " " + summaryFields.getValueDetection().getText()!=null?summaryFields.getValueDetection().getText():"null");
										}else if (summaryFields.getType().getText().equalsIgnoreCase("STATE")) {

											supplierDetails.setSupplierState( supplierDetails.getSupplierState() + " " + summaryFields.getValueDetection().getText()!=null?summaryFields.getValueDetection().getText():"null");
										}else if (summaryFields.getType().getText().equalsIgnoreCase("CITY")) {

											supplierDetails.setSupplierCity( supplierDetails.getSupplierCity()  + " " + summaryFields.getValueDetection().getText()!=null?summaryFields.getValueDetection().getText():"null");
										}
										System.out.println(summaryFields.getValueDetection().getText());
									}
									}});});
/*
											if (summaryFields.getType().getText().equalsIgnoreCase("ZIP_CODE")) {

												supplierDetails.setSupplierZipCode(supplierDetails.getSupplierZipCode() + " " + summaryFields.getValueDetection().getText()!=null?summaryFields.getValueDetection().getText():"null");
											}else if (summaryFields.getType().getText().equalsIgnoreCase("STATE")) {

												supplierDetails.setSupplierState( supplierDetails.getSupplierState() + " " + summaryFields.getValueDetection().getText()!=null?summaryFields.getValueDetection().getText():"null");
											}else if (summaryFields.getType().getText().equalsIgnoreCase("CITY")) {

												supplierDetails.setSupplierCity( supplierDetails.getSupplierCity()  + " " + summaryFields.getValueDetection().getText()!=null?summaryFields.getValueDetection().getText():"null");
											}
										}
*/
		out.getExpenseDocuments().stream().forEach(
				expenseDocument->{
					expenseDocument.getSummaryFields().stream().forEach(
							summaryFields-> {
								summaryFields.getGroupProperties().stream().filter(p->p.getTypes().contains("VENDOR")).forEach(vendor->{
									if (summaryFields.getType().getText().equalsIgnoreCase("ZIP_CODE")) {

										supplierDetails.setSupplierZipCode(supplierDetails.getSupplierZipCode() + " " + summaryFields.getValueDetection().getText()!=null?summaryFields.getValueDetection().getText():"null");
									}else if (summaryFields.getType().getText().equalsIgnoreCase("STATE")) {

										supplierDetails.setSupplierState( supplierDetails.getSupplierState() + " " + summaryFields.getValueDetection().getText()!=null?summaryFields.getValueDetection().getText():"null");
									}else if (summaryFields.getType().getText().equalsIgnoreCase("CITY")) {

										supplierDetails.setSupplierCity( supplierDetails.getSupplierCity()  + " " + summaryFields.getValueDetection().getText()!=null?summaryFields.getValueDetection().getText():"null");
									}
									}
								);

								if (summaryFields.getType().getText().equalsIgnoreCase("ADDRESS_BLOCK")) {
									addressBlock.set(2);

								}
								if (summaryFields.getType().getText().equalsIgnoreCase("SUBTOTAL")) {

									invoiceAmountFields.setInvoiceSubTotal(summaryFields.getValueDetection().getText());
								} else if (summaryFields.getType().getText().equalsIgnoreCase("TOTAL")) {

									invoiceAmountFields.setInvoiceTotal(summaryFields.getValueDetection().getText());
								} else if (summaryFields.getType().getText().equalsIgnoreCase("TAX")) {

									invoiceAmountFields.setInvoiceTaxRate(summaryFields.getValueDetection().getText());
								}
								if (summaryFields.getType().getText().equalsIgnoreCase("INVOICE_RECEIPT_ID")) {

									invoiceKeyFields.setInvoiceNumber(summaryFields.getValueDetection().getText());
								} else if (summaryFields.getType().getText().equalsIgnoreCase("INVOICE_RECEIPT_DATE")) {

									invoiceKeyFields.setInvoiceDate(summaryFields.getValueDetection().getText());
								} else if (summaryFields.getType().getText().equalsIgnoreCase("PO_NUMBER")) {

									invoiceKeyFields.setPoNumber(summaryFields.getValueDetection().getText());
								}


								if (summaryFields.getType().getText().equalsIgnoreCase("VENDOR_ADDRESS")) {

									supplierDetails.setSupplierAddress((supplierDetails.getSupplierAddress()!=null?supplierDetails.getSupplierAddress():"") + " " + summaryFields.getValueDetection().getText());
								} else if (summaryFields.getType().getText().equalsIgnoreCase("VENDOR_NAME")) {

									supplierDetails.setSupplierName((supplierDetails.getSupplierName()!=null?supplierDetails.getSupplierName():"") + " " + summaryFields.getValueDetection().getText());
								}
								if (summaryFields.getType().getText().equalsIgnoreCase("VENDOR_PHONE")) {

									supplierDetails.setSupplierPhoneNumber((supplierDetails.getSupplierPhoneNumber()!=null?supplierDetails.getSupplierPhoneNumber() :"") + " " + summaryFields.getValueDetection().getText());
								} else if (summaryFields.getType().getText().equalsIgnoreCase("VENDOR_URL")) {

									supplierDetails.setSupplierUrl((supplierDetails.getSupplierUrl()!=null?supplierDetails.getSupplierUrl():"") + " " + summaryFields.getValueDetection().getText());
								} else if (summaryFields.getType().getText().equalsIgnoreCase("OTHER")) {

									supplierDetails.setOthers((supplierDetails.getOthers()!=null?supplierDetails.getOthers():"") + " " + summaryFields.getValueDetection().getText());
								}

								if (addressBlock.get() == 1) {

									if (summaryFields.getType().getText().equalsIgnoreCase("ADDRESS")) {

										billToDetails.setBillToAddress(summaryFields.getValueDetection().getText());
									} else if (summaryFields.getType().getText().equalsIgnoreCase("STREET")) {

										billToDetails.setBillToStreet(summaryFields.getValueDetection().getText());
									} else if (summaryFields.getType().getText().equalsIgnoreCase("STATE")) {

										billToDetails.setBillToState(summaryFields.getValueDetection().getText());
									} else if (summaryFields.getType().getText().equalsIgnoreCase("ZIP_CODE")) {

										billToDetails.setBillToZipCode(summaryFields.getValueDetection().getText());
									} else if (summaryFields.getType().getText().equalsIgnoreCase("NAME")) {

										billToDetails.setBillToName(summaryFields.getValueDetection().getText());
									} else if (summaryFields.getType().getText().equalsIgnoreCase("CITY")) {

										billToDetails.setBillToCity(summaryFields.getValueDetection().getText());
									}
								} else {


										if (summaryFields.getType().getText().equalsIgnoreCase("ADDRESS")) {

											shipToDetails.setShipToAddress(summaryFields.getValueDetection().getText());
										} else if (summaryFields.getType().getText().equalsIgnoreCase("STREET")) {

											shipToDetails.setShipToStreet(summaryFields.getValueDetection().getText());
										} else if (summaryFields.getType().getText().equalsIgnoreCase("STATE")) {

											shipToDetails.setShipToState(summaryFields.getValueDetection().getText());
										} else if (summaryFields.getType().getText().equalsIgnoreCase("ZIP_CODE")) {

											shipToDetails.setShipToZipCode(summaryFields.getValueDetection().getText());
										} else if (summaryFields.getType().getText().equalsIgnoreCase("NAME")) {

											shipToDetails.setShipToName(summaryFields.getValueDetection().getText());
										} else if (summaryFields.getType().getText().equalsIgnoreCase("CITY")) {

											shipToDetails.setShipToCity(summaryFields.getValueDetection().getText());
										}

								}

				});});

		recordsHeaderFields.setInvoiceAmountFields(invoiceAmountFields);
		recordsHeaderFields.setInvoiceKeyFields(invoiceKeyFields);
		recordsHeaderFields.setBillToDetails(billToDetails);
		recordsHeaderFields.setShipToDetails(shipToDetails);
		recordsHeaderFields.setSupplierDetails(supplierDetails);

								List<Invoice_Details_Fields> detailsList = new ArrayList<>();

		out.getExpenseDocuments().stream().forEach(
				expenseDocument1->{
                    for (LineItemGroup summaryFields1 : expenseDocument1.getLineItemGroups()) {

                        for (LineItem lineItems : summaryFields1.getLineItems()) {
							int check = 1;
							Invoice_Details_Fields details = new Invoice_Details_Fields();

							for (LineItemExpenseField fields : lineItems.getLineItemExpenseFields()) {
								if(fields.getType().getText().equalsIgnoreCase("QUANTITY")) {

									details.setInvoiceItemQuantity(fields.getValueDetection().getText());
								}else if(fields.getType().getText().equalsIgnoreCase("UNIT_PRICE")) {

									details.setInvoiceItemUnitPrice(fields.getValueDetection().getText());
								}else if(fields.getType().getText().equalsIgnoreCase("PRICE")) {

									details.setInvoiceItemExtendedPrice(fields.getValueDetection().getText());
								}else if(fields.getType().getText().equalsIgnoreCase("ITEM")) {

									details.setInvoiceItemDescription(fields.getValueDetection().getText());
								}else if(fields.getType().getText().equalsIgnoreCase("OTHER")) {

									details.setInvoiceItemNumber(fields.getValueDetection().getText());
									details.setInvoiceNumber(fields.getValueDetection().getText());

								}
								if (fields.getType().getText().equalsIgnoreCase("EXPENSE_ROW") ){
									int j = 0;



detailsList.add(details);
									details = new Invoice_Details_Fields();
								}


							}

                    }
                }});
		invoice.setInvoiceDetailsFields(detailsList);
		invoice.setInvoiceRecordsHeaderFields(recordsHeaderFields);
System.out.println(invoice);

		/*Map<Double, List> map1 = new HashMap<>();

		out.getExpenseDocuments().stream().forEach(s -> {
             s.getBlocks().stream().forEach(
                    s1 -> {
                       // System.out.println(s1.getConfidence() + "ssss");
                        if (map1.get(s1.getConfidence()) == null) {
                            map1.put(s1.getConfidence(), s1.getRelationships());
                        } else {
                            map1.get(s1.getConfidence()).addAll(s1.getRelationships());
                        }
                    }
            );
        });
		//System.out.println("Confidence"+map1.size());

		for(Double confidence:map1.keySet()) {
			System.out.println("Confidence=======================" + confidence);
			List<Relationship> list = map1.get(confidence);
			AtomicReference<Optional<Block>> found = new AtomicReference<>(Optional.empty());
			for (Relationship relationship : list) {
				for (String id : relationship.getIds()) {
					{
						out.getExpenseDocuments().stream().forEach(s -> {
							for (Block s1 : s.getBlocks()) {
								for (ExpenseDocument s2 : out.getExpenseDocuments()) {
									for (Block block : s2.getBlocks()) {
										if (block.getId().equalsIgnoreCase(id)) {
											found.set(Optional.of(block));
											break;
										}
									}
									if (found.get().isPresent()) {
										break;
									}
								}

							}
							//System.out.println(found.get().get().getText());
						});
					}

				}
			}
		}*/
                                        //System.out.println(map.toString());
                                        //					bl->r1.getIds().contains(bl.getId())&&
                                        //
	/*	AnalyzeLendingResponse out = mapper.readValue(new File(analyzeLendingResponse), AnalyzeLendingResponse.class);
		System.out.println("Job Status"+out.getJobStatus());
		AtomicReference<String> analyzeLendingContents= new AtomicReference<>("<html><body><table border='1'><tr><td colspan='2'>"+"Job Status:  "+out.getJobStatus()+"</td></tr>");

		out.getResults().stream().flatMap(res->res.getExtractions().stream()).filter(extr->extr.getLendingDocument()!=null).forEach
				(extr-> {
                     extr.getLendingDocument().getLendingFields().stream().filter(lendingFields1 -> lendingFields1.getValueDetections() != null).forEach(lendingFields -> {
						 analyzeLendingContents.set(analyzeLendingContents+"<tr><td>"+ lendingFields.getType()+"</td>");
                                lendingFields.getValueDetections().stream().forEach(
                                        valueDetections -> {
											analyzeLendingContents.set(analyzeLendingContents+"<td>"+ valueDetections.getText()+"</td>");
//
                                        }
                                );
						 analyzeLendingContents.set(analyzeLendingContents+"</tr>");

					 }
                    );
                });

		analyzeLendingContents.set(analyzeLendingContents+"</table></body></html>");
		Path analyzeLendingpath = Paths.get(path+"\\analyzeLendingResponse.html");
		byte[] strToBytes = analyzeLendingContents.get().getBytes();

		Files.write(analyzeLendingpath, strToBytes);
*/

                                }catch (Exception e) {
        throw new RuntimeException(e);
    }
}

}

