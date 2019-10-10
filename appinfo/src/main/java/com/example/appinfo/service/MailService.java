package com.example.appinfo.service;

import com.example.appinfo.pojo.MailProperties;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@Service
public class MailService implements MailServices{
    private MailProperties mailProperties;
     JavaMailSender javaMailSender=null;
    public void sendSimpleMail(String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("939623408@qq.com");
        message.setTo("939623408@qq.com");
        message.setSubject("主题：来自oKong邮件");
        message.setText("公众号：一枚趔趄的猿(lqdevOps)，作者：oKong");
        javaMailSender.send(message);
    }
    public String ex() throws IOException {
        //1.用servletContext对象获取excel模板的真实路径
        //2.读取excel模板,创建excel对象
        XSSFWorkbook wb = new XSSFWorkbook("D:/dtUSER.xlsx");
        //3.读取sheet对象
        Sheet sheet = (Sheet) wb.getSheetAt(0);
        //4.定义一些可复用的对象
        int rowIndex = 0; //行的索引
        int cellIndex = 1; //单元格的索引
        Row nRow = null;
        Cell nCell = null;
        //5.读取大标题行
        nRow = sheet.getRow(rowIndex++); // 使用后 +1
        //6.读取大标题的单元格
        nCell = nRow.getCell(cellIndex);
        //7.设置大标题的内容
        String bigTitle = inputDate.replace("-0","-").replace("-","年")+"月份新增用户表";
        nCell.setCellValue(bigTitle);
        //8.跳过第二行(模板的小标题,我们要用)
        rowIndex++;
        //9.读取第三行,获取它的样式
        nRow = sheet.getRow(rowIndex);
        //读取行高
        float lineHeight = nRow.getHeightInPoints();
        //10.获取第三行的5个单元格中的样式
        CellStyle cs1 = nRow.getCell(cellIndex++).getCellStyle();
        CellStyle cs2 = nRow.getCell(cellIndex++).getCellStyle();
        CellStyle cs3 = nRow.getCell(cellIndex++).getCellStyle();
        CellStyle cs4 = nRow.getCell(cellIndex++).getCellStyle();
        CellStyle cs5 = nRow.getCell(cellIndex++).getCellStyle();
        //11.通过月份查询新增用户列表
        List<User> newUserList =
                UserService.findByAddTime(inputDate);
        //12.遍历数据
        for(User user : newUserList){
            //13.创建数据行
            nRow = sheet.createRow(rowIndex++);
            //16.设置数据行高
            nRow.setHeightInPoints(lineHeight);
            //17.重置cellIndex,从第一列开始写数据
            cellIndex = 1;
            //18.创建数据单元格，设置单元格内容和样式
            //用户名
            nCell = nRow.createCell(cellIndex++);
            nCell.setCellStyle(cs1);
            nCell.setCellValue(user.getUserName());
            //性别
            nCell = nRow.createCell(cellIndex++);
            nCell.setCellStyle(cs2);
            nCell.setCellValue(user.getSex());
            //年龄
            nCell = nRow.createCell(cellIndex++);
            nCell.setCellStyle(cs3);
            nCell.setCellValue(user.getAge());
            //手机号
            nCell = nRow.createCell(cellIndex++);
            nCell.setCellStyle(cs4);
            nCell.setCellValue(user.getPhone());
            //邮箱
            nCell = nRow.createCell(cellIndex++);
            nCell.setCellStyle(cs5);
            nCell.setCellValue(user.getEmail());
        }

        //最后，下载新增用户表，字节数组的输出流，它可存可取，带缓冲区
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        wb.write(bos); //将工作簿写到输出流中
        new DownloadUtil().download(bos,response,bigTitle+".xlsx");
        bos.close();
        wb.close();
        return "sdf";
    }

}
