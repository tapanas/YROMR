import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.IOException;

/**
 * Created by YRadhi on 10/26/15.
 */
public class Main {

    PDFBox thePdf = new PDFBox();
    JFrame frame = new JFrame("The OMR");
    Container pane = frame.getContentPane();
    JLabel label = new JLabel("HALLO");

    JPanel panel = new JPanel();

    JPanel pdfPanel = new JPanel();



    public  Main() throws IOException {

        pane.add(panel, BorderLayout.PAGE_START);
        panel.add(label);

        pane.add(pdfPanel, BorderLayout.CENTER);
        pdfPanel.add(new JLabel("OMR"));


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(300,300));

        thePdf.getText();
        thePdf.getFonts();
        thePdf.getColor();


    }

    public static void main(String[] args) throws IOException{
        new Main();
    }





}
