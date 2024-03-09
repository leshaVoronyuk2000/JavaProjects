package ru.geekbrains.voronyuk.homework6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;

public class MainProgram {
	static HashMap<String,ArrayList<Long>> phoneBook = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] contacts = {
		    "Вика 8911879911",
			"Влад 8991738577",
			"Влад 8991538571",
			"Иван 8991530511",
			"Иван 8991530509",
			"Иван 8991530999",
			"Марина 8992532509",
			"Света 89241222211",
			"Света 89241222311",
			"Света 89241252211",
			"Иван 89219889921",
			"Андрей 8922337756",
			"Андрей 8922237751",
		};
		printPhoneBook(contacts);
		
		
	}
	
	static void printPhoneBook(String[] contacts) {
		for(String contact: contacts) {
			String[] contactParts = contact.split(" ");
			if(phoneBook.containsKey(contactParts[0])) {
				phoneBook.get(contactParts[0]).add(Long.parseLong(contactParts[1]));
			}else {
				ArrayList<Long> newContact = new ArrayList<>();
				newContact.add(Long.parseLong(contactParts[1]));
				phoneBook.put(contactParts[0],newContact);
			}
		}
		
		int[] countContacts = new int[phoneBook.size()];
		int index = 0;

		for(Map.Entry<String,ArrayList<Long>> e : phoneBook.entrySet()) {
			countContacts[index] = e.getValue().size();
			index++;
		}
		
		for(int i = 0;i < countContacts.length;i++) {
			for(int j = countContacts.length-1; j > i;j--) {
				if(countContacts[j] > countContacts[j-1]) {
					int temp = countContacts[j];
					countContacts[j] = countContacts[j-1];
					countContacts[j-1] = temp;
				}
			}
		}
		
		
		for(int i = 0;i < countContacts.length;i++) {
			for(Map.Entry<String,ArrayList<Long>> e : phoneBook.entrySet()) {
				if(countContacts[i] == e.getValue().size()) {
					System.out.print(e.getKey() + " "+e.getValue() + ". ");
					System.out.println("Количество номореров: " + e.getValue().size());
					phoneBook.remove(e.getKey());
					break;
				}
			}
		}
	}

}
