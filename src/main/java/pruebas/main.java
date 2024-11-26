package pruebas;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.lang.foreign.PaddingLayout;

public class main {
    public static void main(String[] args) {
        try (PDDocument document = new PDDocument()) {
            PDPage page=new PDPage(PDRectangle.A6);
            document.addPage(page);
            PDPageContentStream stream= new PDPageContentStream(document, page);
            stream.beginText();
            stream.setFont(PDType1Font.H, 12);
            stream.newLineAtOffset( 20, page.getMediaBox().getHeight() - 52);
            document.save("/home/josepino/doc.pdf");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
