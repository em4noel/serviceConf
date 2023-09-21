package com.serviceConf.Bi.Rot;

import com.serviceConf.Bi.Rot.dto.RotDTO;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    //static String[] HEADERs = { "Fatura", "GDS", "Data emissao", "Localizador", "Bilhete", "Status", "Passageiro", "Cia", "Tipo Trecho", "Origem", "Destino", "Classe", "Rota", "Promocode", "Tarifa BRL", "TX. YQ", "Forma Pagamento"};

    static String[] HEADERs = { "Fatura"};
    static String SHEET = "Planilha1";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }
    /*
        public static ByteArrayInputStream tutorialsToExcel(List<Tutorial> tutorials) {

            try (Workbook workbook = new HSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
                Sheet sheet = workbook.createSheet(SHEET);

                // Header
                Row headerRow = sheet.createRow(0);

                for (int col = 0; col < HEADERs.length; col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(HEADERs[col]);
                }

                int rowIdx = 1;
                for (Tutorial tutorial : tutorials) {
                    Row row = sheet.createRow(rowIdx++);

                    row.createCell(0).setCellValue(tutorial.getId());
                    row.createCell(1).setCellValue(tutorial.getTitle());
                    row.createCell(2).setCellValue(tutorial.getDescription());
                    row.createCell(3).setCellValue(tutorial.getPublished());
                }

                workbook.write(out);
                return new ByteArrayInputStream(out.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException("falha ao importar dados para o arquivo Excel: " + e.getMessage());
            }
        }
    */
    public static List<RotDTO> excelToRots(InputStream is) {
        try {

            Workbook workbook = new HSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<RotDTO> rotDTOS = new ArrayList<RotDTO>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                RotDTO rot = new RotDTO();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            rot.setFatura(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                rotDTOS.add(rot);
            }

            workbook.close();

            return rotDTOS;
        } catch (IOException e) {
            throw new RuntimeException("falha ao analisar o arquivo Excel: " + e.getMessage());
        }
    }
}
