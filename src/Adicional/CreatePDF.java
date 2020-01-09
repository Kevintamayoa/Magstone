/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicional;

import Classes.Client;
import Classes.Expense;
import Classes.Income;
import Classes.Tickets;
import Classes.Tickets_Contains;
import Classes.Inventory;
import Classes.Inventory_Type;
import Classes.Provider;
import Classes.Sale;
import Classes.Save;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import static com.itextpdf.text.Element.DIV;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Font;

import java.awt.Desktop;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.scene.paint.Color;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author macbook
 */
public class CreatePDF {

    public void ReporteIngresos(List<Income> list) {
        try {
            Document doc = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                Chunk chunk = new Chunk("Reporte de ingresos", FontFactory.getFont("ARIAL", 14, Font.BOLD));
                doc.add(new Paragraph(chunk));
                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(135f, 70f);
                img.setAbsolutePosition(650, 500);
                doc.add(img);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                PdfPTable datatable = new PdfPTable(12);
                datatable.getDefaultCell().setPadding(2);
                datatable.setWidthPercentage((float) 100.0);
                datatable.getDefaultCell().setBorder(3);
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                datatable.addCell(new Phrase("Id", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Fecha", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Categoría", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Cliente", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Venta", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Concepto", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Cuenta", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Factura", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("No. Factura", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Monto sin IVA", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("IVA", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Monto Total", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.setHeaderRows(1);
                datatable.getDefaultCell().setBorderWidth((float) 1);
                DecimalFormat formatea = new DecimalFormat("$###,###.##");
                for (Income obj : list) {
                    datatable.addCell(new Phrase(String.valueOf(obj.Id), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Date.getDate() + "-" + obj.Date.getMonth() + "-" + obj.Date.getYear(), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Expense_Type, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Client, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Sale, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Concept, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Account, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    if (obj.Bill()) {
                        datatable.addCell(new Phrase("Si", FontFactory.getFont("ARIAL", 8, Font.NORMAL)));

                    } else {
                        datatable.addCell(new Phrase("No", FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    }
                    datatable.addCell(new Phrase(obj.BillsNumber, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.AmountSinIva()), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Iva()), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Amount), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.completeRow();
                }
                // datatable.Size=FontFactory.GetFont("ARIAL", 14, iTextSharp.text.Font.BOLD)
                doc.add(datatable);
                doc.addCreationDate();
                doc.close();

            }

        } catch (Exception e) {
        }
    }

    public void ReporteIngresosCliente(List<Income> list, String aa) {
        try {
            Document doc = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                Chunk chunk = new Chunk("Reporte de pagos de " + aa, FontFactory.getFont("ARIAL", 14, Font.BOLD));
                doc.add(new Paragraph(chunk));
                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(135f, 70f);
                img.setAbsolutePosition(650, 500);
                doc.add(img);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                PdfPTable datatable = new PdfPTable(12);
                datatable.getDefaultCell().setPadding(2);
                datatable.setWidthPercentage((float) 100.0);
                datatable.getDefaultCell().setBorder(3);
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                datatable.addCell(new Phrase("Id", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Fecha", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Categoría", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Cliente", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Venta", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Concepto", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Cuenta", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Factura", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("No. Factura", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Monto sin IVA", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("IVA", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Monto Total", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.setHeaderRows(1);
                datatable.getDefaultCell().setBorderWidth((float) 1);
                DecimalFormat formatea = new DecimalFormat("$###,###.##");
                for (Income obj : list) {
                    datatable.addCell(new Phrase(String.valueOf(obj.Id), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Date.getDate() + "-" + obj.Date.getMonth() + "-" + obj.Date.getYear(), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Expense_Type, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Client, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Sale, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Concept, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Account, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    if (obj.Bill()) {
                        datatable.addCell(new Phrase("Si", FontFactory.getFont("ARIAL", 8, Font.NORMAL)));

                    } else {
                        datatable.addCell(new Phrase("No", FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    }
                    datatable.addCell(new Phrase(obj.BillsNumber, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.AmountSinIva()), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Iva()), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Amount), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.completeRow();
                }
                // datatable.Size=FontFactory.GetFont("ARIAL", 14, iTextSharp.text.Font.BOLD)
                doc.add(datatable);
                doc.addCreationDate();
                doc.close();

            }

        } catch (Exception e) {
        }
    }

    public void ReporteEgresos(List<Expense> list) {
        try {
            Document doc = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                Chunk chunk = new Chunk("Reporte de egresos", FontFactory.getFont("ARIAL", 14, Font.BOLD));
                doc.add(new Paragraph(chunk));
                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(135f, 70f);
                img.setAbsolutePosition(650, 500);
                doc.add(img);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                PdfPTable datatable = new PdfPTable(10);
                datatable.getDefaultCell().setPadding(2);
                datatable.setWidthPercentage((float) 100.0);
                datatable.getDefaultCell().setBorder(3);
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                datatable.addCell(new Phrase("Id", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Fecha", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Categoría", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Concepto", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Cuenta", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Factura", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("No. Factura", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Monto sin IVA", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("IVA", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Monto Total", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.setHeaderRows(1);
                datatable.getDefaultCell().setBorderWidth((float) 1);
                DecimalFormat formatea = new DecimalFormat("$###,###.##");
                for (Expense obj : list) {
                    datatable.addCell(new Phrase(String.valueOf(obj.Id), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Date.getDate() + "-" + obj.Date.getMonth() + "-" + obj.Date.getYear(), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Expense_Type, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Concept, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Account, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    if (obj.Bill()) {
                        datatable.addCell(new Phrase("Si", FontFactory.getFont("ARIAL", 8, Font.NORMAL)));

                    } else {
                        datatable.addCell(new Phrase("No", FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    }
                    datatable.addCell(new Phrase(obj.BillsNumber, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.AmountSinIva()), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Iva()), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Amount), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.completeRow();
                }
                // datatable.Size=FontFactory.GetFont("ARIAL", 14, iTextSharp.text.Font.BOLD)
                doc.add(datatable);
                doc.addCreationDate();
                doc.close();

            }

        } catch (Exception e) {
        }
    }

    public void ReporteEgresos(List<Expense> list, String aa) {
        try {
            Document doc = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                Chunk chunk = new Chunk("Reporte de pagos a " + aa, FontFactory.getFont("ARIAL", 14, Font.BOLD));
                doc.add(new Paragraph(chunk));
                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(135f, 70f);
                img.setAbsolutePosition(650, 500);
                doc.add(img);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                PdfPTable datatable = new PdfPTable(10);
                datatable.getDefaultCell().setPadding(2);
                datatable.setWidthPercentage((float) 100.0);
                datatable.getDefaultCell().setBorder(3);
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                datatable.addCell(new Phrase("Id", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Fecha", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Categoría", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Concepto", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Cuenta", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Factura", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("No. Factura", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Monto sin IVA", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("IVA", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Monto Total", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.setHeaderRows(1);
                datatable.getDefaultCell().setBorderWidth((float) 1);
                DecimalFormat formatea = new DecimalFormat("$###,###.##");
                for (Expense obj : list) {
                    datatable.addCell(new Phrase(String.valueOf(obj.Id), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Date.getDate() + "-" + obj.Date.getMonth() + "-" + obj.Date.getYear(), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Expense_Type, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Concept, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Account, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    if (obj.Bill()) {
                        datatable.addCell(new Phrase("Si", FontFactory.getFont("ARIAL", 8, Font.NORMAL)));

                    } else {
                        datatable.addCell(new Phrase("No", FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    }
                    datatable.addCell(new Phrase(obj.BillsNumber, FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.AmountSinIva()), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Iva()), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Amount), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.completeRow();
                }
                // datatable.Size=FontFactory.GetFont("ARIAL", 14, iTextSharp.text.Font.BOLD)
                doc.add(datatable);
                doc.addCreationDate();
                doc.close();

            }

        } catch (Exception e) {
        }
    }

    public void ReporteClientes(List<Client> list) {
        try {
            Document doc = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                Chunk chunk = new Chunk("Cobranza de clientes", FontFactory.getFont("ARIAL", 14, Font.BOLD));
                doc.add(new Paragraph(chunk));
                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(135f, 70f);
                img.setAbsolutePosition(650, 500);
                doc.add(img);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                PdfPTable datatable = new PdfPTable(8);
                datatable.getDefaultCell().setPadding(2);
                datatable.setWidthPercentage((float) 100.0);
                datatable.getDefaultCell().setBorder(3);
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                datatable.addCell(new Phrase("Id", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Cliente", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Dirección", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Email", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Teléfono", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Total de ventas", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Total pagado", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Saldo", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.setHeaderRows(1);
                datatable.getDefaultCell().setBorderWidth((float) 1);
                DecimalFormat formatea = new DecimalFormat("$###,###.##");
                for (Client obj : list) {
                    datatable.addCell(new Phrase(String.valueOf(obj.Id), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Description, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Direccion, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Email, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Telefono, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Monto), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.MontoPagado), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Saldo()), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.completeRow();
                }
                doc.add(datatable);
                doc.addCreationDate();
                doc.close();

            }

        } catch (Exception e) {
        }
    }

    public void ReporteProv(List<Provider> list) {
        try {
            Document doc = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                Chunk chunk = new Chunk("Cobranza de clientes", FontFactory.getFont("ARIAL", 14, Font.BOLD));
                doc.add(new Paragraph(chunk));
                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(135f, 70f);
                img.setAbsolutePosition(650, 500);
                doc.add(img);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                PdfPTable datatable = new PdfPTable(8);
                datatable.getDefaultCell().setPadding(2);
                datatable.setWidthPercentage((float) 100.0);
                datatable.getDefaultCell().setBorder(3);
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                datatable.addCell(new Phrase("Id", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Proveedor", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Contacto", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Email", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Detalle", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Total de compras", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Total pagado", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Saldo", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.setHeaderRows(1);
                datatable.getDefaultCell().setBorderWidth((float) 1);
                DecimalFormat formatea = new DecimalFormat("$###,###.##");
                for (Provider obj : list) {
                    datatable.addCell(new Phrase(String.valueOf(obj.Id), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Description, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Contacto, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Email, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Detalle, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Monto), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.MontoPagado), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Saldo()), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.completeRow();
                }
                doc.add(datatable);
                doc.addCreationDate();
                doc.close();

            }

        } catch (Exception e) {
        }
    }

    public void ReporteSubVentas(List<Sale> list, String aa) {
        try {
            Document doc = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                Chunk chunk = new Chunk("Ventas de " + aa, FontFactory.getFont("ARIAL", 14, Font.BOLD));
                doc.add(new Paragraph(chunk));
                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(135f, 70f);
                img.setAbsolutePosition(650, 500);
                doc.add(img);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                PdfPTable datatable = new PdfPTable(8);
                datatable.getDefaultCell().setPadding(2);
                datatable.setWidthPercentage((float) 100.0);
                datatable.getDefaultCell().setBorder(3);
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                datatable.addCell(new Phrase("Id", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Fecha", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Venta", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Comentario", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Monto total", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Monto cobrado", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Saldo", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Entregado", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                datatable.setHeaderRows(1);
                datatable.getDefaultCell().setBorderWidth((float) 1);
                DecimalFormat formatea = new DecimalFormat("$###,###.##");
                for (Sale obj : list) {
                    datatable.addCell(new Phrase(String.valueOf(obj.Id), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Date.getDate() + "-" + obj.Date.getMonth() + "-" + obj.Date.getYear(), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));

                    datatable.addCell(new Phrase(obj.Description, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Comentario, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Monto), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.MontoCobrado), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Saldo()), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    if (obj.Status()) {
                        datatable.addCell(new Phrase("Si", FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    } else {
                        datatable.addCell(new Phrase("No", FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    }
                    datatable.completeRow();
                }
                doc.add(datatable);
                doc.addCreationDate();
                doc.close();

            }

        } catch (Exception e) {
        }
    }

    public void ReportVentas(List<Sale> list) {
        try {
            Document doc = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                Chunk chunk = new Chunk("Ventas", FontFactory.getFont("ARIAL", 14, Font.BOLD));
                doc.add(new Paragraph(chunk));
                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(135f, 70f);
                img.setAbsolutePosition(650, 500);
                doc.add(img);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                PdfPTable datatable = new PdfPTable(9);
                datatable.getDefaultCell().setPadding(2);
                datatable.setWidthPercentage((float) 100.0);
                datatable.getDefaultCell().setBorder(3);
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                datatable.addCell(new Phrase("Id", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Fecha", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Cliente", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                datatable.addCell(new Phrase("Venta", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Comentario", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Monto total", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Monto cobrado", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Saldo", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Entregado", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                datatable.setHeaderRows(1);
                datatable.getDefaultCell().setBorderWidth((float) 1);
                DecimalFormat formatea = new DecimalFormat("$###,###.##");
                for (Sale obj : list) {
                    datatable.addCell(new Phrase(String.valueOf(obj.Id), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Date.getDate() + "-" + obj.Date.getMonth() + "-" + obj.Date.getYear(), FontFactory.getFont("ARIAL", 8, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Client, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));

                    datatable.addCell(new Phrase(obj.Description, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Comentario, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Monto), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.MontoCobrado), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Saldo()), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    if (obj.Status()) {
                        datatable.addCell(new Phrase("Si", FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    } else {
                        datatable.addCell(new Phrase("No", FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    }
                    datatable.completeRow();
                }
                doc.add(datatable);
                doc.addCreationDate();
                doc.close();

            }

        } catch (Exception e) {
        }
    }

    public void ReportInventarios(List<Inventory_Type> list) {
        try {
            Document doc = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                Chunk chunk = new Chunk("Inventarios", FontFactory.getFont("ARIAL", 14, Font.BOLD));
                doc.add(new Paragraph(chunk));

                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(135f, 70f);
                img.setAbsolutePosition(650, 500);
                doc.add(img);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("", FontFactory.getFont("ARIAL", 10, Font.BOLD)));

                PdfPTable datatable = new PdfPTable(6);
                datatable.getDefaultCell().setPadding(2);
                datatable.setWidthPercentage((float) 100.0);
                datatable.getDefaultCell().setBorder(3);
                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                datatable.addCell(new Phrase("Id", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Categoría", FontFactory.getFont("ARIAL", 8, Font.BOLD)));
                datatable.addCell(new Phrase("Producto", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Costo proveedor", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Costo unitario", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.addCell(new Phrase("Inventario actual", FontFactory.getFont("ARIAL", 10, Font.BOLD)));
                datatable.setHeaderRows(1);
                datatable.getDefaultCell().setBorderWidth((float) 1);
                DecimalFormat formatea = new DecimalFormat("$###,###.##");
                for (Inventory_Type obj : list) {
                    datatable.addCell(new Phrase(String.valueOf(obj.Id), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(obj.Category, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));

                    datatable.addCell(new Phrase(obj.Description, FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Cost), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(formatea.format(obj.Price), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));
                    datatable.addCell(new Phrase(String.valueOf(obj.TotalStock), FontFactory.getFont("ARIAL", 10, Font.NORMAL)));

                    datatable.completeRow();
                }
                doc.add(datatable);
                doc.addCreationDate();
                doc.close();

            }

        } catch (Exception e) {
        }
    }

    public void TicketVentas(Tickets list) {
        try {
            Document doc = new Document(PageSize.A4, 10, 10, 10, 10);
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String ruta = chooser.getSelectedFile().toString().concat(".pdf");
                PdfWriter.getInstance(doc, new FileOutputStream(ruta));
                doc.open();
                BaseColor col = new BaseColor(2, 2, 2);
                Chunk chunk = new Chunk("                      ENTREGA DE MATERIAL", FontFactory.getFont("ARIAL", 24, Font.BOLD,new BaseColor(240, 94, 34)));
                doc.add(new Paragraph(chunk));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                Image img = Image.getInstance(System.getProperty("user.home") + "/Documents/MagstoneManager/iconn.jpeg");
                img.scaleToFit(169f, 88f);
                img.setAbsolutePosition(50, 700);
                doc.add(img);

                doc.add(new Paragraph("                                                                                         FECHA: " + Date.valueOf(LocalDate.now()), FontFactory.getFont("ARIAL", 14, Font.BOLD)));

                doc.add(new Paragraph("                                                                                         FOLIO: " + list.Ticket_Num, FontFactory.getFont("ARIAL", 14, Font.BOLD)));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                   Celular: 999-593-3017                             "));
                doc.add(new Paragraph("                   Correo: a.maglioni.a@gmail.com                            "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
//
//                PdfPTable datatable = new PdfPTable(1);
//                datatable.setHorizontalAlignment(Element.ALIGN_LEFT);
//                datatable.getDefaultCell().setPadding(2);
//                datatable.setWidthPercentage((float) 40.0);
//                datatable.getDefaultCell().setBorder(3);
//                datatable.getDefaultCell().setBackgroundColor(new BaseColor(255, 128, 0));
//
//                
//                datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
//                datatable.addCell(new Phrase("CLIENTE:", FontFactory.getFont("ARIAL", 16, Font.BOLD, BaseColor.WHITE)));
//                datatable.addCell(new Phrase(Save.Sale2.Client, FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
//                datatable.completeRow();
//                doc.add(datatable);
//
//                PdfPTable datatable2 = new PdfPTable(1);
//                datatable2.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                datatable2.getDefaultCell().setPadding(2);
//                datatable2.setWidthPercentage((float) 40.0);
//                 datatable2.getDefaultCell().setBorder(3);
//                datatable2.getDefaultCell().setBackgroundColor(new BaseColor(255, 128, 0));
//
//                datatable2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
//                datatable2.addCell(new Phrase("DOMICILIO DE ENTREGA:", FontFactory.getFont("ARIAL", 16, Font.BOLD, BaseColor.WHITE)));
//                datatable2.addCell(new Phrase(Save.Sale2.Description, FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
//                datatable2.completeRow();

               // doc.add(datatable2);
                  doc.add(new Paragraph("                           CLIENTE                                    DOMICILIO DE ENTREGA        ", FontFactory.getFont("ARIAL", 14, Font.BOLD,new BaseColor(240, 94, 34))));
                  doc.add(new Paragraph("                       "+Save.Sale2.Client+"                                      "+Save.Sale2.Description+"         "));

                doc.add(new Paragraph("                                   "));
               
//                PdfPTable datatable3 = new PdfPTable(1);
//                datatable3.setHorizontalAlignment(Element.ALIGN_LEFT);
//                datatable3.getDefaultCell().setPadding(2);
//                datatable3.setWidthPercentage((float) 40.0);
//                datatable3.getDefaultCell().setBorder(3);
//                datatable3.getDefaultCell().setBackgroundColor(new BaseColor(255, 128, 0));
//
//                datatable3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
//                datatable3.addCell(new Phrase("ORDEN DE COMPRA No.", FontFactory.getFont("ARIAL", 16, Font.BOLD, BaseColor.WHITE)));
//                datatable3.addCell(new Phrase(String.valueOf(Save.Sale2.Id), FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
//                datatable3.completeRow();
//                doc.add(datatable3);
//
//                PdfPTable datatable4 = new PdfPTable(1);
//                datatable4.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                datatable4.getDefaultCell().setPadding(2);
//                datatable4.setWidthPercentage((float) 40.0);
//                datatable4.getDefaultCell().setBorder(3);
//                datatable4.getDefaultCell().setBackgroundColor(new BaseColor(255, 128, 0));
//
//                datatable4.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
//                datatable4.addCell(new Phrase("CHOFER", FontFactory.getFont("ARIAL", 16, Font.BOLD, BaseColor.WHITE)));
//                datatable4.addCell(new Phrase(list.Chofer, FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
//                datatable4.completeRow();
//                doc.add(datatable4);
//                doc.add(new Paragraph("                                   "));
//                doc.add(new Paragraph("                                   "));
               doc.add(new Paragraph("              ORDEN DE COMPRA No.                                        CHOFER       ", FontFactory.getFont("ARIAL", 14, Font.BOLD,new BaseColor(240, 94, 34))));
      doc.add(new Paragraph("                                    "+String.valueOf(Save.Sale2.Id)+"                                                                      "+list.Chofer+"         "));

                doc.add(new Paragraph("                                   "));
              
                PdfPTable datatable5 = new PdfPTable(4);
                datatable5.setHorizontalAlignment(Element.ALIGN_CENTER);
                datatable5.getDefaultCell().setPadding(2);
                datatable5.setWidthPercentage((float) 100.0);
                datatable5.getDefaultCell().setBorder(3);

                datatable5.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                datatable5.addCell(new Phrase("CANTIDAD", FontFactory.getFont("ARIAL", 16, Font.BOLD,new BaseColor(240, 94, 34))));
                datatable5.addCell(new Phrase("UNIDAD", FontFactory.getFont("ARIAL", 16, Font.BOLD, new BaseColor(240, 94, 34))));
                datatable5.addCell(new Phrase("        ", FontFactory.getFont("ARIAL", 16, Font.BOLD,new BaseColor(240, 94, 34))));
                datatable5.addCell(new Phrase("CONCEPTO", FontFactory.getFont("ARIAL", 16, Font.BOLD, new BaseColor(240, 94, 34))));
                for (Tickets_Contains obj : list.list) {
                    datatable5.addCell(new Phrase(String.valueOf(obj.Cantidad), FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                    datatable5.addCell(new Phrase("Metros", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                    datatable5.addCell(new Phrase("      ", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                    datatable5.addCell(new Phrase(obj.Product, FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                    datatable5.completeRow();
                }
                datatable5.addCell(new Phrase("      ", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                datatable5.addCell(new Phrase("      ", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                datatable5.addCell(new Phrase("      ", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                datatable5.addCell(new Phrase("      ", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                datatable5.completeRow();
                datatable5.addCell(new Phrase("      ", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                datatable5.addCell(new Phrase("      ", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                datatable5.addCell(new Phrase("      ", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                datatable5.addCell(new Phrase("      ", FontFactory.getFont("ARIAL", 16, Font.NORMAL)));
                datatable5.completeRow();
                doc.add(datatable5);

                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));

                PdfPTable datatable6 = new PdfPTable(1);
                datatable6.setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable6.getDefaultCell().setPadding(2);
                datatable6.setWidthPercentage((float) 65.0);
                datatable6.getDefaultCell().setBorder(3);
                //datatable6.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
                datatable6.addCell(new Phrase("Comentarios o instrucciones especiales", FontFactory.getFont("ARIAL", 16, Font.BOLD,new BaseColor(240, 94, 34))));
                datatable6.addCell(new Phrase(list.Comentario ));
                datatable6.addCell(new Phrase("  "));
                datatable6.addCell(new Phrase(" "));
                
                
                          datatable6.completeRow();
                doc.add(datatable6);
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                                   "));
                doc.add(new Paragraph("                 _______________________                          _______________________________        "));
                doc.add(new Paragraph("                                 ELABORÓ                                         NOMBRE Y FIRMA QUIEN RECIBE          "));

                doc.addCreationDate();

                doc.close();
            }

        } catch (Exception e) {
        }
    }
}
