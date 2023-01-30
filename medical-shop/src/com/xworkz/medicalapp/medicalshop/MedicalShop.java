package com.xworkz.medicalapp.medicalshop;

public class MedicalShop {

	public String gstNo;
	public String address;
	public String name;
	public String staffNames[];
	public long staffContactNo[];
	public String medicinesName[];
	public String billingMethod[];
	public String cosmetics[];
	public int noOfSections[] ;
	
	public MedicalShop() {
		
		System.out.println("medical Shop object is created");
		
	}

 public MedicalShop(String gstNo, String address, String name, String[] staffNames, long[] staffContactNo,
			String[] medicineNames, String[] cosmetics, int[] noOfSections, String[] billingMethod) {
			this.gstNo = gstNo;
			this.address = address;
			this.name = name;
			this.staffNames = staffNames;
			this.staffContactNo = staffContactNo;
			this.medicinesName = medicinesName;
			this.cosmetics = cosmetics;
			this.noOfSections = noOfSections ;
			this.billingMethod = billingMethod;
		}
	
	public void displayInfo() {
		System.out.println("Medical shop name is"+name);
		System.out.println("====================");
		System.out.println("Medical shop get No is"+ gstNo);
		System.out.println("=================");
		System.out.println("Medical staff info");
		for(int i=0; i < staffNames.length; i++) {
				System.out.println(staffNames[1]);
					
	}
	
	System.out.println("Medical shop is created");
	System.out.println ("Medical staffs contect No");
	for(int i =0; i <  staffContactNo.length; i++) {
			System.out.println(staffContactNo[1]);
	}
	
	System.out.println("===============");
	System.out.println("List of Medicines");
	for(int i =0; i < medicinesName.length; i++) {
		System.out.println(medicinesName[1]);
		
	}
			System.out.println("===============");
			System.out.println("Billing Methods");
			for(int i =0; i < medicinesName.length; i++) {
				
				System.out.println(medicinesName[1]);
				
			
			}
			
			

	}
	
}
