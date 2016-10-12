package com.tcb.consuming.entities;

import java.util.HashMap;
import java.util.Map;



public class Flux1 {
	//NUMERO;IDENTIFIANT;CODE_MESSAGE;MONTANT_TTC;DATE_ECHEANCE_FACTURE;DATE_ECHEANCE_APUREMENT;MARQUEUR4;MARQUEUR5

	private String NUMERO ;
	private String IDENTIFIANT;
	private String CODE_MESSAGE;
    private String MONTANT_TTC;
    private String DATE_ECHEANCE_FACTURE;
    private String DATE_ECHEANCE_APUREMENT;
    private String MARQUEUR4;
    private String MARQUEUR5;
    
	public String getNUMERO() {
		
		return NUMERO;
	}
	public Flux1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setNUMERO(String nUMERO) {
		NUMERO = nUMERO;
	}
	
	public Flux1(String nUMERO, String iDENTIFIANT, String cODE_MESSAGE, String mONTANT_TTC,
			String dATE_ECHEANCE_FACTURE, String dATE_ECHEANCE_APUREMENT, String mARQUEUR4, String mARQUEUR5) {
		
		NUMERO = nUMERO;
		IDENTIFIANT = iDENTIFIANT;
		CODE_MESSAGE = cODE_MESSAGE;
		MONTANT_TTC = mONTANT_TTC;
		DATE_ECHEANCE_FACTURE = dATE_ECHEANCE_FACTURE;
		DATE_ECHEANCE_APUREMENT = dATE_ECHEANCE_APUREMENT;
		MARQUEUR4 = mARQUEUR4;
		MARQUEUR5 = mARQUEUR5;
	}
	public String getIDENTIFIANT() {
		return IDENTIFIANT;
	}
	public void setIDENTIFIANT(String iDENTIFIANT) {
		IDENTIFIANT = iDENTIFIANT;
	}
	public String getCODE_MESSAGE() {
		return CODE_MESSAGE;
	}
	public void setCODE_MESSAGE(String cODE_MESSAGE) {
		CODE_MESSAGE = cODE_MESSAGE;
	}
	public String getMONTANT_TTC() {
		return MONTANT_TTC;
	}
	public void setMONTANT_TTC(String mONTANT_TTC) {
		MONTANT_TTC = mONTANT_TTC;
	}
	public String getDATE_ECHEANCE_FACTURE() {
		return DATE_ECHEANCE_FACTURE;
	}
	public void setDATE_ECHEANCE_FACTURE(String dATE_ECHEANCE_FACTURE) {
		DATE_ECHEANCE_FACTURE = dATE_ECHEANCE_FACTURE;
	}
	public String getDATE_ECHEANCE_APUREMENT() {
		return DATE_ECHEANCE_APUREMENT;
	}
	public void setDATE_ECHEANCE_APUREMENT(String dATE_ECHEANCE_APUREMENT) {
		DATE_ECHEANCE_APUREMENT = dATE_ECHEANCE_APUREMENT;
	}
	public String getMARQUEUR4() {
		return MARQUEUR4;
	}
	public void setMARQUEUR4(String mARQUEUR4) {
		MARQUEUR4 = mARQUEUR4;
	}
	public String getMARQUEUR5() {
		return MARQUEUR5;
	}
	public void setMARQUEUR5(String mARQUEUR5) {
		MARQUEUR5 = mARQUEUR5;
	}
	/** 
	 * @solve  the  outOfBound exception
	 * 
	 * 
	 * */
 public  void formatKafka(String key , String value){ 
	 if (value !=null)
	    {    
		 
		   String[] buffer = new String[8];
           String [] list = value.split("\\;",-1);
           
           for(int i=0;i<list.length;i++)
              {
        	   buffer[i]=list[i];
        	   
              }
           this.setNUMERO(buffer[0]);
	  
           this.setIDENTIFIANT(buffer[1]);
	  
           this.setIDENTIFIANT(buffer[2]);
	  
           this.setIDENTIFIANT(buffer[3]);
	  
           this.setIDENTIFIANT(buffer[4]);
	  
           this.setIDENTIFIANT(buffer[5]);
	  
           this.setIDENTIFIANT(buffer[6]);
	  
           this.setIDENTIFIANT(buffer[7]);
	 	  
	 }
	 
	 else System.out.println("Value is null come from kafka");
	 
	 
     }
 public void formatHbase()
 {
	// on peut le traiter dans la couche DAO
	 
 }
 public void formatElasticSearch(String Key ,String Value)

 
 {
	 
	    Map<String, String> document = new HashMap<String, String>();	     
	    String[] arrayKey = Key.split("\\;",-1);
		String []arrayValue = Value.split("\\;",-1); 
		 
		for (int i = 0 ;i<arrayKey.length;i++)
		        {
				 document = new HashMap<String, String>();
		         document.put(arrayKey[i],arrayValue[i]);
		         System.out.println(document);
		         
		         }
	 
	 
	 
	 
	 
 }
 
}
