package outputstream;

import java.util.ArrayList;

public class StrInDe {

	private StringBuffer str;
	private ArrayList<Byte> list;
	
	public StrInDe(){
		str = new StringBuffer();
		list = new ArrayList<>();
	}
	
	public String getStr() {
		return str.toString();
	}

	public void setStr(String str) {
		this.str.setLength(0);
		this.str.append(str);
	}

	public ArrayList<Byte> getList() {
		return list;
	}

	public void setList(ArrayList<Byte> list) {
		this.list = list;
	}

	public void incode() {
		int size = list.size();
		for(int i=0; i<size; i++) {
			
		}
	}
	
	public void decode() {
		int size = str.length();
		list.clear();
		for(int i=0; i<size; i++) {
			
		}
	}
	
}
