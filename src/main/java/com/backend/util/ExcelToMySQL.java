package com.backend.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook; // HSSF for older Excel formats (xls)
import org.apache.poi.xssf.usermodel.XSSFWorkbook; // XSSF for modern Excel formats (xlsx)

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelToMySQL {
    public static void main(String[] args) {
        String filePath = "D:/data/data_contest/GZ031应用软件系统开发赛项赛题与评分标准_发程杰_20230926/GZ031应用软件系统开发赛项赛题与评分标准/模块二/模块二/模块二任务资源/任务8：数据可视化/数据分析数据和字段描述.xls";  // Excel文件路径
        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            Workbook workbook = null;
            if (filePath.endsWith(".xls")) {
                workbook = new HSSFWorkbook(fis); // 处理xls格式
            } else if (filePath.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis); // 处理xlsx格式
            }

            Sheet sheet = workbook.getSheetAt(1); // 获取第一个工作表
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/carbon", "root", "123456");
            String insertSQL = "INSERT INTO sale_order (order_no, customer_id, order_amount, delivery_date, apply_user, apply_time, apply_status, audit_user, audit_time, audit_status, audit_comment, remark) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertSQL);

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { // 从第二行开始，跳过标题行
                Row row = sheet.getRow(i);

                // 读取文本数据并转换
                String orderNo = getStringCellValue(row.getCell(1));  // order_no
                Long customerId = getLongCellValue(row.getCell(2));  // customer_id
                BigDecimal orderAmount = getBigDecimalCellValue(row.getCell(3));  // order_amount
                Timestamp deliveryDate = getTimestampCellValue(row.getCell(4));  // delivery_date
                String applyUser = getStringCellValue(row.getCell(5));  // apply_user
                Timestamp applyTime = getTimestampCellValue(row.getCell(6));  // apply_time
                String applyStatus = getStringCellValue(row.getCell(7));  // apply_status
                String auditUser = getStringCellValue(row.getCell(8));  // audit_user
                Timestamp auditTime = getTimestampCellValue(row.getCell(9));  // audit_time
                String auditStatus = getStringCellValue(row.getCell(10));  // audit_status
                String auditComment = getStringCellValue(row.getCell(11));  // audit_comment
                String remark = getStringCellValue(row.getCell(12));  // remark

                // 设置PreparedStatement参数
                ps.setString(1, orderNo);
                ps.setLong(2, customerId);
                ps.setBigDecimal(3, orderAmount);
                ps.setTimestamp(4, deliveryDate);
                ps.setString(5, applyUser);
                ps.setTimestamp(6, applyTime);
                ps.setString(7, applyStatus);
                ps.setString(8, auditUser);
                ps.setTimestamp(9, auditTime);
                ps.setString(10, auditStatus);
                ps.setString(11, auditComment);
                ps.setString(12, remark);

                ps.addBatch();
            }

            // 批量插入
            ps.executeBatch();
            connection.close();
            System.out.println("数据导入成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getStringCellValue(Cell cell) {
        if (cell != null && cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue().trim();  // 去除多余空格
        }
        return "";
    }

    private static Long getLongCellValue(Cell cell) {
        if (cell != null) {
            if (cell.getCellType() == CellType.STRING) {
                try {
                    return Long.parseLong(cell.getStringCellValue().trim()); // 从文本中解析长整型
                } catch (NumberFormatException e) {
                    return 0L; // 默认值
                }
            } else if (cell.getCellType() == CellType.NUMERIC) {
                return (long) cell.getNumericCellValue();
            }
        }
        return 0L; // 默认值
    }

    private static BigDecimal getBigDecimalCellValue(Cell cell) {
        if (cell != null) {
            if (cell.getCellType() == CellType.STRING) {
                try {
                    return new BigDecimal(cell.getStringCellValue().trim()); // 从文本中解析小数
                } catch (NumberFormatException e) {
                    return BigDecimal.ZERO; // 默认值
                }
            } else if (cell.getCellType() == CellType.NUMERIC) {
                return BigDecimal.valueOf(cell.getNumericCellValue());
            }
        }
        return BigDecimal.ZERO; // 默认值
    }

    private static Timestamp getTimestampCellValue(Cell cell) {
        if (cell != null) {
            if (cell.getCellType() == CellType.STRING) {
                try {
                    // 尝试解析日期的多种格式
                    String cellValue = cell.getStringCellValue().trim();
                    String[] dateFormats = {
                            "MM/dd/yyyy HH:mm:ss", // 例如 4/30/2021 00:00:00
                            "yyyy-MM-dd HH:mm:ss", // 标准日期格式
                            "MM/dd/yyyy", // 只包含日期
                            "yyyy-MM-dd" // 标准日期格式
                    };

                    for (String format : dateFormats) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat(format);
                            Date date = sdf.parse(cellValue);
                            return new Timestamp(date.getTime());
                        } catch (Exception e) {
                            // 继续尝试其他日期格式
                        }
                    }
                    return null; // 如果没有匹配的日期格式，返回null
                } catch (Exception e) {
                    return null; // 解析失败，返回null
                }
            } else if (cell.getCellType() == CellType.NUMERIC) {
                return new Timestamp(cell.getDateCellValue().getTime());
            }
        }
        return null;  // 返回null表示没有日期
    }
}
