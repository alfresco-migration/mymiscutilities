package org.myutils.pdf;

import java.io.FileOutputStream;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class WatermarkPDFFile {
    public static void main(String[] args) {
        try {
            PdfReader reader = new PdfReader("<Path of PDF file to be water marked>");
            int n = reader.getNumberOfPages();
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream("<Path of PDF file to be created with watermark>"));
            int i = 0;
            PdfContentByte under;
            Image img = Image.getInstance("<Path of the image to be used for watermark>");
            img.setAbsolutePosition(30, 100);
            while (i < n) {
              i++;
              under = stamp.getUnderContent(i);
              under.addImage(img);
            }
            stamp.close();
            System.out.println("out");
        }
        catch (Exception de) {
            de.printStackTrace();
        }
    }
}
         