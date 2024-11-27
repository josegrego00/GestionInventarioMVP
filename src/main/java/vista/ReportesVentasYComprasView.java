package vista;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import controladores.ControladorIngresarProducto;
import controladores.respositorio.ProductoRepositorio;
import modelo.Producto;
import modelo.ProductosCompras;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class ReportesVentasYComprasView extends JFrame {

    private JComboBox<Producto> nombrePorductos;
    private JTextField nombre, cantidad, precio, minimoStock;
    private JButton PDFBoton, ExcelBoton, cancelarBoton;
    private ProductoRepositorio productoRepositorio;
    private ProductosCompras productosCompras;
    private ControladorIngresarProducto controladorIngresarProducto;

    public ReportesVentasYComprasView() {
        productosCompras = new ProductosCompras();
        productoRepositorio = new ProductoRepositorio();
        JPanel panelFrane = new JPanel(new BorderLayout());
        this.setTitle("Generar Reporte PDF");
        this.setSize(380, 200);
        //   this.add(panelPrincialFormulario(), BorderLayout.CENTER);
        this.add(panelBotones(), BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public JPanel panelPrincialFormulario() {
        // Agregar etiquetas y campos de texto
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        this.nombrePorductos = new JComboBox<Producto>(new Vector<Producto>(productoRepositorio.listar()));
        panel.add(new JLabel("Productos:"));
        panel.add(nombrePorductos);

        panel.add(new JLabel("Nombre del Producto:"));
        this.nombre = new JTextField();
        nombre.setEditable(false);
        panel.add(this.nombre);

        panel.add(new JLabel("Cantidad:"));
        this.cantidad = new JTextField();
        cantidad.setEditable(false);
        panel.add(cantidad);

        panel.add(new JLabel("Precio:"));
        this.precio = new JTextField();
        precio.setEditable(false);
        panel.add(precio);

        panel.add(new JLabel("Stock Mínimo:"));
        this.minimoStock = new JTextField();
        minimoStock.setEditable(false);
        panel.add(minimoStock);

        return panel;
    }

    public JPanel panelBotones() {
        JPanel panelBotones = new JPanel(new FlowLayout());
        this.PDFBoton = new JButton("PDF.");
        this.ExcelBoton = new JButton("Excel.");
        this.cancelarBoton = new JButton("Salir.");

        panelBotones.add(PDFBoton);
        panelBotones.add(ExcelBoton);
        panelBotones.add(cancelarBoton);
        return panelBotones;
    }

    public JButton getPDFBoton() {
        return PDFBoton;
    }

    public JButton getExcelBoton() {
        return ExcelBoton;
    }

    public void controladorBotonPDF(ControladorIngresarProducto controladorIngresarProducto) {

        this.controladorIngresarProducto = controladorIngresarProducto;
        String destinoPDfReporte = "/home/josepino/FolderPDFReportes/Compras.pdf";
        PDFBoton.addActionListener(e -> {
            List<ProductosCompras> listacompras = productosCompras.listarReportesCompras();
            Vector<Vector<Object>> vectorProductos = new Vector<>();
            for (ProductosCompras row : listacompras) {
                Vector<Object> rowVector = new Vector<>();
                rowVector.add(row.getCantidadC());
                rowVector.add(row.getFecha());
                rowVector.add(row.getNombreP());
                vectorProductos.add(rowVector);
            }
            try (PdfWriter pdfWriter = new PdfWriter(destinoPDfReporte);
                 PdfDocument pdfD = new PdfDocument(pdfWriter);
                 Document doc = new Document(pdfD);) {
                Table table = new Table(3);
                table.addHeaderCell("Fecha Compras");
                table.addHeaderCell("Nombre del Producto");
                table.addHeaderCell("Cantidad");

                for (Vector<Object> row : vectorProductos) {
                    table.addCell(row.get(1).toString());
                    table.addCell(row.get(2).toString());
                    table.addCell(row.get(0).toString());
                }
                table.setHorizontalAlignment(HorizontalAlignment.CENTER);
                doc.add(new Paragraph("Reporte de Compras").setHorizontalAlignment(HorizontalAlignment.CENTER));
                doc.add(table);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null, "Se Genero El PDF.");
        });
    }

    public void controladorBotonExcel(ControladorIngresarProducto controladorIngresarProducto) {
        this.controladorIngresarProducto = controladorIngresarProducto;

      ExcelBoton.addActionListener(e -> {
          List<ProductosCompras> listacompras = productosCompras.listarReportesCompras();
          Workbook workbook = new SXSSFWorkbook();
          SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("Reporte Compras");
            sheet.trackAllColumnsForAutoSizing();


          Row headerRow = sheet.createRow(0);
          headerRow.createCell(0).setCellValue("Fecha Compras");
          headerRow.createCell(1).setCellValue("Nombre del Producto");
          headerRow.createCell(2).setCellValue("Cantidad");

          int rowNum = 1; // La primera fila es para los encabezados, por lo que comenzamos en la fila 1

          for (ProductosCompras row : listacompras) {
              Row dataRow = sheet.createRow(rowNum++);
              dataRow.createCell(0).setCellValue(row.getFecha());
              dataRow.createCell(1).setCellValue(row.getNombreP());
              dataRow.createCell(2).setCellValue(row.getCantidadC());
          }
          for (int i = 0; i < 3; i++) {
              sheet.autoSizeColumn(i);
          }

          // Escribir el archivo Excel en el sistema de archivos
          try (FileOutputStream fileOut = new FileOutputStream("/home/josepino/FolderPDFReportes/Compras.xlsx")) {
              workbook.write(fileOut);
              workbook.close();
          } catch (Exception ex) {
              ex.printStackTrace();
          }

          // Cerrar el libro de trabajo
          JOptionPane.showMessageDialog(null,"Se genero el Excel");
      });


    }

}
