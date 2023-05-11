package PokemonDTO;

public class PokemonDTO {
	
	// 포켓몬DB
	
	public int HP;
    public int ATK;
    public int LOVE;
    public int EXP;
	
    public PokemonDTO(int HP, int ATK, int LOVE, int EXP) {
    	super();
    	this.HP = HP;
    	this.ATK = ATK;
    	this.LOVE = LOVE;
    	this.EXP = EXP;
    }
    
	
    public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public int getLOVE() {
		return LOVE;
	}

	public void setLOVE(int lOVE) {
		LOVE = lOVE;
	}

	public int getEXP() {
		return EXP;
	}

	public void setEXP(int eXP) {
		EXP = eXP;
	}


	// 회원DB
    public String T_ID;
    public int T_PW;
    public int PCODE;

	public PokemonDTO(String T_ID, int T_PW, int PCODE) {
		super();
		this.T_ID = T_ID;
		this.T_PW = T_PW;
		this.PCODE = PCODE;
	}


	public String getT_ID() {
		return T_ID;
	}


	public void setT_ID(String t_ID) {
		T_ID = t_ID;
	}


	public int getT_PW() {
		return T_PW;
	}


	public void setT_PW(int t_PW) {
		T_PW = t_PW;
	}


	public int getPCODE() {
		return PCODE;
	}


	public void setPCODE(int pCODE) {
		PCODE = pCODE;
	}
    
    
    
    

}
