package com.kon.bnmo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.kon.bnmo.items.Item;

public class ReportExporter {
    private List<FixedBill> fixedBills;
    private String filename;

    public ReportExporter(List<FixedBill> fixedBills, String filename) {
        this.fixedBills = fixedBills;
        this.filename = filename;
    }

    public void exportToPdf() throws Exception {
        Thread t = new Thread(() -> {
            try {
                Document document = new Document(PageSize.A4, 50, 50, 50, 50);
                PdfWriter.getInstance(document, new FileOutputStream(filename));
                document.open();
                for (FixedBill fb : fixedBills) {
                    document.add(new Paragraph("Bill No. " + fb.getBillNumber()));
                    document.add(new Paragraph("Customer: " + fb.getCustomerName()));
                    document.add(new Paragraph("Date: " + fb.getBillDate()));
                    document.add(new Paragraph("Items: "));
                    for (Item item : fb.getItems()) {
                        document.add(new Paragraph("- " + item.getName() + " x " + item.getQuantity() + " = " + item.getTotal()));
                    }
                    document.add(new Paragraph("Total: " + fb.getTotal()));
                    document.add(new Paragraph("=============================================="));
                }
                document.close();
            } catch (FileNotFoundException | DocumentException e) {
                e.printStackTrace();
            }
        });
        t.start();
        Thread.sleep(10000); // simulate long print process
    }
}

