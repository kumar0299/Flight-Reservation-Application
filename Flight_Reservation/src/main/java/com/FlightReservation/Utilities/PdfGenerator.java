package com.FlightReservation.Utilities;

import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfGenerator {

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	public void generatePdf(String filePath, String name, String emailId, String phone, String operatingAirlines,
			Date departureDate, String departureCity, String arrivalCity) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			addMetaData(document);
			addTitleAndTable(document, name, emailId, phone, operatingAirlines, departureDate.toString(), departureCity,
					arrivalCity);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addMetaData(Document document) {
		document.addTitle("My first PDF");
		document.addSubject("Using iText");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("Manjeet Kumar");
		document.addCreator("Lars Vogel from vogella.com");
	}

	private static void addTitleAndTable(Document document, String name, String emailId, String phone,
			String operatingAirlines, String departureDate, String departureCity, String arrivalCity)
			throws DocumentException {

		Paragraph preface = new Paragraph();
		// Lets write a big header
		preface.add(new Paragraph("Flight Booking Details", catFont));

		// Will create: Report generated by: _name, _date
		preface.add(
				new Paragraph("Report generated by: " + "Manjeet's Flight Reservation Application " + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						smallBold));

		document.add(preface);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);
		table.setSpacingAfter(10f);
		PdfPCell c1 = new PdfPCell(new Phrase("Passenger Detail"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setColspan(2);
		table.addCell(c1);

		table.addCell("Passenger name");
		table.addCell(name);
		table.addCell("Email Id");
		table.addCell(emailId);
		table.addCell("Phone Number");
		table.addCell(phone);

		document.add(table);

		PdfPTable table1 = new PdfPTable(2);
		table.setWidthPercentage(100);
		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);
		table.setSpacingAfter(10f);
		PdfPCell c2 = new PdfPCell(new Phrase("Flight Detail"));
		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		c2.setColspan(2);
		table1.addCell(c2);

		table1.addCell("Operating Airlines");
		table1.addCell(operatingAirlines);
		table1.addCell("Departure Date");
		table1.addCell(departureDate);
		table1.addCell("Departure City");
		table1.addCell(departureCity);

		table1.addCell("Arrival City");
		table1.addCell(arrivalCity);

		document.add(table1);

		document.close();

	}
}
