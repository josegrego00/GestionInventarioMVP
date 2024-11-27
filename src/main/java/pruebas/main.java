package pruebas;


import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


public class main {
    public static void main(String[] args) {
        String destino = "/home/josepino/ejemplo.pdf";
        try (PdfWriter ePDF = new PdfWriter(destino);
             PdfDocument pdf = new PdfDocument(ePDF);
             Document document = new Document(pdf);) {
            document.add(new Paragraph("Este es el Texto que estara en el PDF")
                    .setFontSize(20)
                    .setFontColor(new DeviceRgb(100, 50, 20)));
            System.out.println("PDF creado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
