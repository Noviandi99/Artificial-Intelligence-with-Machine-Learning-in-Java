package YesNoGame;

import java.io.Serializable;

public class Pertanyaan implements Serializable {
	int key;
	String question;
	public boolean isQuestion=true;
	Pertanyaan parent;
	Boolean parentYesResponse;
	Pertanyaan no;
	Pertanyaan yes;
	
}
