package com.prashhanthN.ticketTool.secret;

public class MyLife {

	public static void main(String[] args) throws LoveNotFoundException {
		MyLife myLife = new MyLife();
		try {
			if ((myLife.ifSindhusFamilyAgrees() && myLife.ifSindhusFamilyAgrees() && myLife.prashhanthLovesSindhu())
					&& myLife.ifPrashhanthFamilyAgrees()) {
				Baby baby= new Baby();
				baby.makeBabies();
			}
			else
				throw new LoveNotFoundException();			
			
		} catch (Exception e) {
			throw new LoveNotFoundException();
		}
	}

	public boolean prashhanthLovesSindhu() {
		return true;
	}

	public boolean sindhuLovesPrashhanth() {
		return true;
	}

	public boolean ifSindhusFamilyAgrees() {
		return true;
	}

	public boolean ifPrashhanthFamilyAgrees() {
		return true;
	}
}
