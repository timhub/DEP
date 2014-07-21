package com.demo.supervisor;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import com.csvreader.CsvWriter;
import com.test.entity.SupervisorItem;
import com.test.mockups.SupervisorService;

public class CSVUtils {
	LinkedList<SupervisorItem> list = new LinkedList<SupervisorItem>();
	SupervisorService ss = new SupervisorService();
	CsvWriter csvWriter;
	
	
	public void initCSV(){
		list = ss.getSupervisorService();
	}
	
	public void writeHeader(){
		try {
			csvWriter.write("ID#");
			csvWriter.write("Name");
			csvWriter.write("Total");
			csvWriter.write("Registered");
			csvWriter.write("Registered%");
			csvWriter.write("#");
			csvWriter.write("With Held Away");
			csvWriter.write("Internal");
			csvWriter.write("Held Away Aggregated");
			csvWriter.write("Held Away Manual");
			csvWriter.write("Total Held Away");
			csvWriter.write("Total Internal & Held Away");
			csvWriter.endRecord();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeTitle(){
		try {
			csvWriter.write("Westside Complex (1356)");
			csvWriter.endRecord();
			csvWriter.write("Data As Of: 2/26/13");
			csvWriter.endRecord();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeTotal(SupervisorItem total){
		try {
			csvWriter.write(total.getNum());
			csvWriter.write(total.getBranch_name());
			csvWriter.write(total.getTotal_branch());
			csvWriter.write(total.getRegistered_branch());
			csvWriter.write(total.getRegistered());
			csvWriter.write(total.getRegistered_clients());
			csvWriter.write(total.getHeldaway_clients());
			csvWriter.write(total.getInternal());
			csvWriter.write(total.getAggregated());
			csvWriter.write(total.getHeldaway_manual());
			csvWriter.write(total.getTotal_heldaway());
			csvWriter.write(total.getTotal_internal_heldaway());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SupervisorItem getTotal(){
		SupervisorItem total = ss.getTotal();
		return total;
	}
	
	public LinkedList<SupervisorItem> level5CSVCreater(){
		try{
			 initCSV();
			 csvWriter = new CsvWriter(new FileWriter("form.csv"),',');
			 writeTitle();
			 writeHeader();
			 for(int i=0;i<list.size();i++){
				 csvWriter.write(list.get(i).getNum());
				 csvWriter.write(list.get(i).getBranch_name());
				 csvWriter.write(list.get(i).getTotal_branch());
				 csvWriter.write(list.get(i).getRegistered_branch());
				 csvWriter.write(list.get(i).getRegistered());
				 csvWriter.write(list.get(i).getRegistered_clients());
				 csvWriter.write(list.get(i).getHeldaway_clients());
				 csvWriter.write(list.get(i).getInternal());
				 csvWriter.write(list.get(i).getAggregated());
				 csvWriter.write(list.get(i).getHeldaway_manual());
				 csvWriter.write(list.get(i).getTotal_heldaway());
				 csvWriter.write(list.get(i).getTotal_internal_heldaway());
				 csvWriter.endRecord();
			 }
			 csvWriter.endRecord();
			 SupervisorItem total = getTotal();
			 writeHeader();
			 writeTotal(total);
		       csvWriter.flush();
		       csvWriter.close();	
		       
		       
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
}
