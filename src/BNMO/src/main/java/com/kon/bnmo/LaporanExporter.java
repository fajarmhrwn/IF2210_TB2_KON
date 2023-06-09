package com.kon.bnmo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.kon.bnmo.items.Billitem;
import com.kon.bnmo.items.FixedBill;
import com.kon.bnmo.transaction.TransactionHolder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class LaporanExporter extends Thread{
    private TransactionHolder history;
    private String filename;

    private boolean isCompleted = false;
    public LaporanExporter(TransactionHolder history, String filename){
        this.filename = filename;
        this.history = history;
    }

    @Override
    public void run() {
        while (!isCompleted) {
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
                document.open();
                Paragraph title = new Paragraph("Toko KON", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                double totalPenghasilan = 0;
                for (int i = 0; i < this.history.getList().size(); i++) {
                    FixedBill bill = this.history.getList().get(i);
                    Paragraph date = new Paragraph("Bill" + (i + 1) + " " + bill.keluarkanTanggal().toString(), new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL));
                    date.setAlignment(Element.ALIGN_RIGHT);
                    document.add(date);
                    Paragraph daftarBelanjaan = new Paragraph("Daftar Belanjaan", new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD));
//                    itemsTitle.setSpacingBefore(20);
                    document.add(daftarBelanjaan);


//                List<Item> itemList = bill.getItemList();
                    double totalHarga = 0;
                    for (int j = 0; j < bill.getListBillItem().size(); j++) {
                        totalHarga += bill.getListBillItem().get(j).getPrice() * bill.getListBillItem().get(j).getAmount();
                        Paragraph item = new Paragraph(bill.getListBillItem().get(j).getAmount() + " " + bill.getListBillItem().get(j).getName() + " : Rp " + bill.getListBillItem().get(j).getPrice() * bill.getListBillItem().get(j).getAmount(), new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL));
                        item.setIndentationLeft(20);
                        document.add(item);
                    }
                    totalPenghasilan += totalHarga;
                    Paragraph total = new Paragraph("Total: Rp " + totalHarga, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL));
                    total.setAlignment(Element.ALIGN_LEFT);
                    document.add(total);
                }
                Paragraph total = new Paragraph("Total Penghasilan: Rp " + totalPenghasilan, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL));
                total.setAlignment(Element.ALIGN_RIGHT);
                document.add(total);
                // add fixed bill data to document
                document.close();
                isCompleted = true;
            } catch (FileNotFoundException | DocumentException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000); // simulate long print process
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//    public static void main(String[] args){
//        ArrayList<FixedBill> report = new ArrayList<>();
//        ArrayList<Billitem> bill1 = new ArrayList<>();
//
////        BillContainer billCon1 = new BillContainer();
//        Billitem item1 =  new Billitem("barang1", 100.0, "barang", "sdjakjsd",
//                10, 3);
//        Billitem item2 =  new Billitem("barang2", 200.0, "barang", "sdjakjsd",
//                10, 4);
//
//        bill1.add(item1);
//        bill1.add(item2);
//
//        ArrayList<Billitem> bill2 = new ArrayList<>();
//
////        BillContainer billCon1 = new BillContainer();
//        Billitem item3 =  new Billitem("barang3", 100.0, "barang", "sdjakjsd",
//                10, 3);
//        Billitem item4 =  new Billitem("barang3", 200.0, "barang", "sdjakjsd",
//                10, 3);
//
//        bill2.add(item1);
//        bill2.add(item2);
//
//
//        FixedBill fixbill1 = new FixedBill(bill1);
//        FixedBill fixbill2 = new FixedBill(bill2);
//
//        report.add(fixbill1);
//        report.add(fixbill2);
//        History history = new History(report);
//        LaporanExporter tes = new LaporanExporter(history, "testhistorythread");
//        tes.run();
//    }
}
