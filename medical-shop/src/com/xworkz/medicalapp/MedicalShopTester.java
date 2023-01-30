package com.xworkz.medicalapp;

import com.xworkz.medicalapp.medicalshop.MedicalShop;

public class MedicalShopTester {

	
	public static void main(String args[]) {
		
		MedicalShop med = new MedicalShop();
		med.gstNo = "yfuyefggijwn d987565345";
		med.address = "vijayanager";
		med.name = "mani medical";
		
		med.staffNames =new String[3];
		med.staffNames[0] = "Narang";
		med.staffNames[1] = "Narangi";
		med.staffNames[2] = "Majarangi";
		
		med.staffContactNo  = new long [3];
		med.staffContactNo[0]  = 85637632l;
		med.staffContactNo[1]  = 757536698;
		med.staffContactNo[2]  = 757536699;
	
		med.cosmetics =new String[3];
		med.cosmetics[0] = "Tablet";
		med.cosmetics[1] = "injuctions";
		med.cosmetics [2] = "oinments";
		
		med. medicinesName = new String[2];
		med.medicinesName[0] = "Dulicolex";
		med.medicinesName[1] = "Gulucose";
		
		med.billingMethod = new String[2];
		med.billingMethod[0] = "cash";
		med.billingMethod[2] = "card";
		
		System.out.println("gst No is:"+med.gstNo);
		System.out.println("address is :"+med.address);
		
		
		
				med.displayInfo();
		
		
	}
}
