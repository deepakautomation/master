package com;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteDataIntoExcel {

	
	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
		
	WritableWorkbook write=Workbook.createWorkbook(new File("C:\\Users\\dsood1\\Desktop\\abc.xls"));	
	
	WritableSheet sh=write.createSheet("CreateSheet", 1);
	
	Label label=new Label(0, 0, "hi");
	
	sh.addCell(label);
	write.write();
	write.close();
		
	}
	
}
