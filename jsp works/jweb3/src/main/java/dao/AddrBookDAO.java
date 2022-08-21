package dao;

import java.util.ArrayList;

public class AddrBookDAO {
	
	private ArrayList<AddrBook> addrList = null;
	
	public AddrBookDAO() {
		addrList = new ArrayList<>();
	}
	
	public void addAddress(AddrBook addrBook) {
		addrList.add(addrBook);
	}
	
	public AddrBook getAddress(int index) {
		return addrList.get(index);
	}
	
	public AddrBook getAddress(String username) {
		for(AddrBook addrBook:addrList) {
			if(addrBook.getUsername().equals(username)) {
				return addrBook;
			}
		}
		return null;
	}
	
	public ArrayList<AddrBook> getAllList(){
		return addrList;
	}
	
	public void deleteAddr(int userIndex){
		addrList.remove(userIndex);
	}
	
	public void deleteAddr(String username){
		for(AddrBook addrBook:addrList) {
			if(addrBook.getUsername().equals(username)) {
				addrList.remove(addrList.indexOf(addrBook));
			}
		}
	}
	
}
