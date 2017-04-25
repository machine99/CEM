package com.baolian.excel;

import com.baolian.excel.factory.WorkbookFactory;
import com.baolian.excel.factory.impl.HSSFWorkbookFactory;
import com.baolian.excel.factory.impl.XSSFWorkbookFactory;
import com.baolian.service.TestagentService;
import com.baolian.utils.excel.ExcelUtils;
import com.baolian.utils.excel.Student;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.lang.reflect.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by tomxie on 2017/4/5 15:16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-baolian.xml"})
public class ExcelTest {
    @Autowired
    private TestagentService testagentService;

    // Excel文件名
    private String[] xlsNames = {"testagent.xls", "result_httptest.xls", "result_pingtest.xls",
            "result_xunleitest.xls", "result_youkutest.xls"};

    // 文件所在根目录
    private String path = "F://baolian_data_201703/";

    // 对应xls文件和xlsx的工厂类集合
    static List<WorkbookFactory<? extends Workbook, InputStream>> workbookFactories = new ArrayList<>();

    static {
        workbookFactories.add(new HSSFWorkbookFactory());
        workbookFactories.add(new XSSFWorkbookFactory());
    }

    @Test
    public void RunExcelTest() {
        Class<Student> c = Student.class;
        InputStream is = null;
        try {
            is = new FileInputStream("F://student_info.xls");
            Collection<Student> list = ExcelUtils.readExcel(is, "xls", Student.class);
            for (Student student : list) {
                System.out.println(student);
            }
            XSSFWorkbook workbook = ExcelUtils.<Student>exportExcel("sheet1", Student.class, list);
            File outFile = new File("F://out.xlsx");
            workbook.write(new FileOutputStream(outFile));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testStringToDate() {
        String s = "2017/3/1  0:00:47";
        // System.out.println(stringToDate("2017/3/1  0:00:47"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d  H:m:s");
        format.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        try {
            System.out.println(format.parse(s));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将excel文件转换成集合
     *
     * @param inputStream 输入文件流
     * @param type        输入文件类型
     * @param entity      实体类
     * @return 实体类集合
     * @throws IOException
     */
    public Collection readXls(InputStream inputStream, String type, Class entity) throws IOException {
        // InputStream is = new FileInputStream(path + fileName);//EXCEL_PATH存放路径
        Collection dist = new ArrayList<Object>();
        try {

            // 得到目标目标类的所有的字段列表
            Field fields[] = entity.getDeclaredFields();
            Map<String, Method> fieldSetMap = new HashMap<String, Method>();
            for (Field f : fields) {
                // 去除由序列化导致的serialVersionUID
                if (!isFieldFinal(f)) {
                    // 构造Setter方法
                    String fieldName = f.getName();
                    String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    // 构造调用的method
                    Method setMethod = entity.getMethod(setMethodName, f.getType());
                    // 将这个method以field名字的小写为key来存入
                    fieldSetMap.put(fieldName.toLowerCase(), setMethod);
                }
            }
            Workbook book;
            switch (type) {
                case "xls":
                    book = workbookFactories.get(0).create(inputStream);
                    break;
                case "xlsx":
                    book = workbookFactories.get(1).create(inputStream);
                    break;
                default:
                    return null;
            }
            // // 得到工作表
            // HSSFWorkbook book = new HSSFWorkbook(inputStream);
            // 得到第一页
            Sheet sheet = book.getSheetAt(1);
            // 得到第一面的所有行
            Iterator<Row> row = sheet.rowIterator();
            // 得到第一行，也就是标题行
            Row title = row.next();
            // 得到第一行的所有列
            Iterator<Cell> cellTitle = title.cellIterator();
            // 将标题的文字内容放入到一个map中。
            Map<Integer, String> titleMap = new HashMap<Integer, String>();
            // 从标题第一列开始
            int i = 0;
            // 循环标题所有的列
            while (cellTitle.hasNext()) {
                Cell cell = cellTitle.next();
                String value = cell.getStringCellValue();
                System.out.println(value);
                titleMap.put(i, value);
                i = i + 1;
            }
            return null;
            // while (row.hasNext()) {
            //     // 标题下的第一行
            //     Row rown = row.next();
            //     // 行的所有列
            //     Iterator<Cell> cellbody = rown.cellIterator();
            //     // 得到传入类的实例
            //     Constructor constructor = entity.getDeclaredConstructor();
            //     constructor.setAccessible(true);
            //     Object tObject = constructor.newInstance();
            //     int k = 0;
            //     // 遍历一行的列
            //     while (cellbody.hasNext()) {
            //         Cell cell = cellbody.next();
            //         // 这里得到此列的对应的标题
            //         String titleString = (String) titleMap.get(k);
            //         // 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值
            //         if (fieldSetMap.containsKey(titleString)) {
            //             Method setMethod = (Method) fieldSetMap.get(titleString);
            //             // 得到setter方法的参数
            //             Type[] ts = setMethod.getGenericParameterTypes();
            //             // 只要一个参数
            //             String xclass = ts[0].toString();
            //             // 判断参数类型
            //             switch (xclass) {
            //                 case "class java.lang.String":
            //                     // 先设置Cell的类型，然后就可以把纯数字作为String类型读进来了：
            //                     cell.setCellType(Cell.CELL_TYPE_STRING);
            //                     setMethod.invoke(tObject, cell.getStringCellValue());
            //                     break;
            //                 case "class java.util.Date":
            //                     Date cellDate = null;
            //                     if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            //                         // 日期格式
            //                         cellDate = cell.getDateCellValue();
            //                     } else {    // 全认为是  Cell.CELL_TYPE_STRING: 如果不是 yyyy-mm-dd hh:mm:ss 的格式就不对(wait to do:有局限性)
            //                         cellDate = stringToDate(cell.getStringCellValue());
            //                     }
            //                     setMethod.invoke(tObject, cellDate);
            //                     //// --------------------------------------------------------------------------------------------
            //                     //String cellValue = cell.getStringCellValue();
            //                     //Date theDate = stringToDate(cellValue);
            //                     //setMethod.invoke(tObject, theDate);
            //                     //// --------------------------------------------------------------------------------------------
            //                     break;
            //                 case "class java.lang.Boolean":
            //                     boolean valBool;
            //                     if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
            //                         valBool = cell.getBooleanCellValue();
            //                     } else {// 全认为是  Cell.CELL_TYPE_STRING
            //                         valBool = cell.getStringCellValue().equalsIgnoreCase("true")
            //                                 || (!cell.getStringCellValue().equals("0"));
            //                     }
            //                     setMethod.invoke(tObject, valBool);
            //                     break;
            //                 case "class java.lang.Integer":
            //                     Integer valInt;
            //                     if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            //                         valInt = (new Double(cell.getNumericCellValue())).intValue();
            //                     } else {// 全认为是  Cell.CELL_TYPE_STRING
            //                         valInt = new Integer(cell.getStringCellValue());
            //                     }
            //                     setMethod.invoke(tObject, valInt);
            //                     break;
            //                 case "class java.lang.Long":
            //                     Long valLong;
            //                     if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            //                         valLong = (new Double(cell.getNumericCellValue())).longValue();
            //                     } else {// 全认为是  Cell.CELL_TYPE_STRING
            //                         valLong = new Long(cell.getStringCellValue());
            //                     }
            //                     setMethod.invoke(tObject, valLong);
            //                     break;
            //                 case "class java.math.BigDecimal":
            //                     BigDecimal valDecimal;
            //                     if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            //                         valDecimal = new BigDecimal(cell.getNumericCellValue());
            //                     } else {// 全认为是  Cell.CELL_TYPE_STRING
            //                         valDecimal = new BigDecimal(cell.getStringCellValue());
            //                     }
            //                     setMethod.invoke(tObject, valDecimal);
            //                     break;
            //                 case "class java.lang.Double":
            //                     Double valDouble;
            //                     valDouble = new Double(cell.getStringCellValue());
            //                     break;
            //             }
            //
            //         }
            //         // 下一列
            //         k = k + 1;
            //     }
            //     dist.add(tObject);
            // }
            // HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
            // Student student = null;
            // List<Student> list = new ArrayList<>();
            // // 循环工作表Sheet
            // for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            //     HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            //     if (hssfSheet == null) {
            //         continue;
            //     }
            //     // 循环行Row,第一行是列名，所以跳过
            //     for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            //         HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            //         if (hssfRow != null) {
            //             student = new Student();
            //             HSSFCell no = hssfRow.getCell(0);
            //             HSSFCell name = hssfRow.getCell(1);
            //             HSSFCell age = hssfRow.getCell(2);
            //             HSSFCell score = hssfRow.getCell(3);
            //             student.setNo(getValue(no));
            //             student.setName(getValue(name));
            //             student.setAge(getValue(age));
            //             student.setScore(Float.valueOf(getValue(score)));
            //             list.add(student);
            //         }
            //     }
            // }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // return dist;
    }

    private boolean isFieldFinal(Field field) {
        return (field.getModifiers() & java.lang.reflect.Modifier.FINAL) == java.lang.reflect.Modifier.FINAL;
    }

    private String getValue(HSSFCell hssfCell) {
        if (hssfCell != null) {
            if (hssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                // 返回布尔类型的值
                return String.valueOf(hssfCell.getBooleanCellValue());
            } else if (hssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                // 返回数值类型的值
                return String.valueOf(hssfCell.getNumericCellValue());
            } else {
                // 返回字符串类型的值
                return String.valueOf(hssfCell.getStringCellValue());
            }
        } else {
            return "";
        }
    }

    /**
     * 字符串转换为Date类型数据（限定格式      YYYY-MM-DD hh:mm:ss）或（YYYY/MM/DD hh:mm:ss）
     *
     * @param cellValue : 字符串类型的日期数据
     * @return
     */
    private static Date stringToDate(String cellValue) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d  H:m:s");
        format.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        try {
            return format.parse(cellValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
