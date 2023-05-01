//package com.kon.bnmo;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
//public class pdfCreator {
//    public static void main(String[] args) {
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream("example.pdf"));
//            document.open();
//            document.add(new Paragraph("Hello, World!"));
//            document.close();
//            System.out.println("PDF created successfully!");
//        } catch (DocumentException | FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
