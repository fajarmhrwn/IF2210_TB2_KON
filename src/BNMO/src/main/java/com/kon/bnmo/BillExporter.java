package com.kon.bnmo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import com.itextpdf.text.Element;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class BillExporter extends Thread{
    private final ItemHolder bill;

    public BillExporter(ItemHolder bill){
        this.bill = bill;
    }

    public void exportToPdf(String filename){
        Thread t = new Thread(() -> {
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
                document.open();
                Paragraph title = new Paragraph("Toko KON", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                Paragraph itemsTitle = new Paragraph("Daftar Belanjaan", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
                itemsTitle.setSpacingBefore(20);
                document.add(itemsTitle);

                List<Item> itemList = bill.getItemList();
                int totalHarga = 0;
                for (int i = 0; i < itemList.size(); i++) {
                    totalHarga += itemList.get(i).getPrice()*itemList.get(i).getStock();
                    Paragraph item = new Paragraph(itemList.get(i).getStock()+ " " + itemList.get(i).getName() + " : Rp " + itemList.get(i).getPrice()*itemList.get(i).getStock(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL));
                    item.setIndentationLeft(20);
                    document.add(item);
                }

                Paragraph total = new Paragraph("Total: Rp " + totalHarga, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL));
                total.setAlignment(Element.ALIGN_RIGHT);
                total.setSpacingBefore(20);
                document.add(total);
                // add fixed bill data to document
                document.close();
            } catch (FileNotFoundException | DocumentException e) {
                e.printStackTrace();
            }
        });
        t.start();
        try {
            Thread.sleep(10000); // simulate long print process
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        ItemHolder bill = new ItemHolder();
        Item padangA = new Item("Nasi padang", 18000.0, "Food", "png", 5);
        Item padangB = new Item("Nasi padang Ayam", 18000.0, "Food", "png", 5);
        bill.add(padangA);
        bill.add(padangB);
        BillExporter test = new BillExporter(bill);
        test.exportToPdf("testpadang2");
    }
//    public static void main(String[] args){
//        ItemHolder<BillItem> bill = new ItemHolder<BillItem>();
//        BillItem padangA = new BillItem("Nasi padang", 18000.0, 2, "Dine in");
//        BillItem padangB = new BillItem("Nasi padang ayam", 18000.0, 2, "Dine in");
//        bill.add(padangA);
//        bill.add(padangB);
//        BillExporter test = new BillExporter(bill);
//        test.exportToPdf("testpadang2");
//    }
}
