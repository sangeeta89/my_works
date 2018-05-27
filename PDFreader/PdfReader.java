package PDFreader;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		PDDocument pd;
		pd= PDDocument.load(new File("D:\\Ticket.pdf"));
		System.out.println("Total number of pages: "+pd.getNumberOfPages());
		PDFTextStripper pdf=new PDFTextStripper();
		System.out.println(pdf.getText(pd));
		
	}

}
