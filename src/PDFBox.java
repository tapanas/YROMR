import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.util.PDFTextStripper;
import java.util.List;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class PDFBox {
    PDFTextStripper pdfStripper;
    PDDocument pdDoc;
    COSDocument cosDoc;
    File file;

    BufferedImage bi;
    Graphics2D g;

    public PDFBox() {

        pdfStripper = null;
        pdDoc = null;
        cosDoc = null;
        file = new File("pdf.pdf");


    }


    public void getText() {
        try {
            PDFParser parser = new PDFParser(new FileInputStream(file));
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            pdfStripper.setStartPage(1);
            pdfStripper.setEndPage(1);

            String parsedText = pdfStripper.getText(pdDoc);
            System.out.println(parsedText);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void getFonts () {

        List<PDPage> pages = pdDoc.getDocumentCatalog().getAllPages();
        for(PDPage page:pages){
            Map<String,PDFont> pageFonts = page.getResources().getFonts();
            System.out.println("The page fonts are : " + pageFonts + "\n");
        }
    }

    public void getColor() throws  IOException {
        PDFTextStripper stripper = new ColorTextStripper();

        PDDocument document = PDDocument.load(file);

        String text = stripper.getText(document);
        System.out.println(text);
    }
    public static void main(String[] args) throws Exception {
        new PDFBox();

    }
}