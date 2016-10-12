package com.tcb.consuming.entities;

public class Flux2 {
//NUMERO;IDENTIFIANT;CODE_MESSAGE;;DATE_ACTION_COMMERCIALE;;CIVILITE;NOM
	private String NUMERO ;
	private String IDENTIFIANT ;
	private String CODE_MESSAGE ;
	public String getNUMERO() {
		return NUMERO;
	}
	public void setNUMERO(String nUMERO) {
		NUMERO = nUMERO;
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
	public String getDATE_ACTION_COMMERCIALE() {
		return DATE_ACTION_COMMERCIALE;
	}
	public void setDATE_ACTION_COMMERCIALE(String dATE_ACTION_COMMERCIALE) {
		DATE_ACTION_COMMERCIALE = dATE_ACTION_COMMERCIALE;
	}
	public String getCIVILITE() {
		return CIVILITE;
	}
	public void setCIVILITE(String cIVILITE) {
		CIVILITE = cIVILITE;
	}
	public String getNOM() {
		return NOM;
	}
	public void setNOM(String nOM) {
		NOM = nOM;
	}
	public Flux2(String nUMERO, String iDENTIFIANT, String cODE_MESSAGE, String dATE_ACTION_COMMERCIALE,
			String cIVILITE, String nOM) {
		super();
		NUMERO = nUMERO;
		IDENTIFIANT = iDENTIFIANT;
		CODE_MESSAGE = cODE_MESSAGE;
		DATE_ACTION_COMMERCIALE = dATE_ACTION_COMMERCIALE;
		CIVILITE = cIVILITE;
		NOM = nOM;
	}
	private String DATE_ACTION_COMMERCIALE ;
	private String CIVILITE ;
	private String NOM ;


}
