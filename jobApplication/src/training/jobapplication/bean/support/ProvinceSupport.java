package training.jobapplication.bean.support;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import training.jobapplication.transfer.Province;

public class ProvinceSupport {
	public List<Province> getProvinces() {
		long provinceId = 1;
		
		ArrayList<Province> provinces = new ArrayList<Province>();
		
		Province province = new Province(provinceId++, "AB");
		provinces.add(province);
		province = new Province(provinceId++, "BC");
		provinces.add(province);
		province = new Province(provinceId++, "MB");
		provinces.add(province);
		province = new Province(provinceId++, "NB");
		provinces.add(province);
		province = new Province(provinceId++, "NL");
		provinces.add(province);
		province = new Province(provinceId++, "NT");
		provinces.add(province);
		province = new Province(provinceId++, "NS");
		provinces.add(province);
		province = new Province(provinceId++, "NU");
		provinces.add(province);
		province = new Province(provinceId++, "ON");
		provinces.add(province);
		province = new Province(provinceId++, "PE");
		provinces.add(province);
		province = new Province(provinceId++, "QC");
		provinces.add(province);
		province = new Province(provinceId++, "SK");
		provinces.add(province);
		province = new Province(provinceId++, "YT");
		provinces.add(province);
		
		return provinces;
	}
	
	public List<SelectItem> getSelectItems() {
		List<SelectItem> selectItems;
		selectItems = new ArrayList<SelectItem>();
		List<Province> provinces = getProvinces();

		for (Province province : provinces) {
			SelectItem selectItem = new SelectItem(
	            province.getProvinceId(),
	            province.getProvinceName());
			selectItems.add(selectItem);
		}

		return selectItems;
	}
	
	public long getProvinceId(String provinceName) {
		 long provinceId = 0;
		 List<Province> provinces = getProvinces();
		 for (Province province: provinces) {
		  	if (province.getProvinceName().equals(provinceName)) {
				   provinceId = province.getProvinceId();
				   break;
			  }
		 }
		 return provinceId;
	}	
}
