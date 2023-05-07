package com.kon.bnmo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.kon.bnmo.items.Billitem;
import com.kon.bnmo.items.FixedBill;
import com.kon.bnmo.items.Item;
import com.kon.bnmo.items.ItemHolder;
import com.itextpdf.text.Element;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BillExporter extends Thread{
    private final FixedBill bill;
    private String filename;

    public BillExporter(FixedBill bill, String filename){
        this.filename = filename;
        this.bill = new FixedBill(bill.getListBillItem());
    }

    @Override
    public void run(){
        try {
            Thread.sleep(10000); // simulate long print process
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
                document.open();
                Paragraph title = new Paragraph("Toko KON", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                Paragraph date = new Paragraph(this.bill.getCheckoutDate().toString(), new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL));
                date.setAlignment(Element.ALIGN_RIGHT);
                document.add(date);
                Paragraph itemsTitle = new Paragraph("Daftar Belanjaan", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
                itemsTitle.setSpacingBefore(20);
                document.add(itemsTitle);


//                List<Item> itemList = bill.getItemList();
                double totalHarga = 0;
                for (int i = 0; i < bill.getListBillItem().size(); i++) {
                    totalHarga += bill.getListBillItem().get(i).getPrice()*bill.getListBillItem().get(i).getAmount();
                    Paragraph item = new Paragraph(bill.getListBillItem().get(i).getAmount()+ " " + bill.getListBillItem().get(i).getName() + " : Rp " + bill.getListBillItem().get(i).getPrice()*bill.getListBillItem().get(i).getAmount(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        ArrayList<Billitem> bill = new ArrayList<>();

//        BillContainer billCon1 = new BillContainer();
        Billitem item1 =  new Billitem("barang1", 100.0, "barang", "sdjakjsd",
                10, 3);
        Billitem item2 =  new Billitem("barang2", 200.0, "barang", "sdjakjsd",
                10, 4);

        bill.add(item1);
        bill.add(item2);

        FixedBill fixbill = new FixedBill(bill);
        BillExporter test = new BillExporter(fixbill, "testThread");
        test.run();
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
