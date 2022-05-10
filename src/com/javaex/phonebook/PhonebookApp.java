package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhonebookApp {

	public static void main(String[] args) throws IOException {

		// 시작화면
		Scanner sc = new Scanner(System.in);
		System.out.println("*************************************");
		System.out.println("*	전화번호 관리 프로그램	    *");
		System.out.println("*************************************");
		System.out.println();
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("-------------------------------------");
		System.out.print(">메뉴번호:");
		int num = sc.nextInt();

		// 1.리스트
		List<Phonebook> personList = new ArrayList<Phonebook>();

		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		if (num == 1) {
			System.out.println("<1.리스트>");
			while (true) {
				Phonebook person = new Phonebook();
				String str = br.readLine();
				if (str == null) {
					break;
				}
				String[] personInfo = str.split(",");
				person.setName(personInfo[0]);
				person.setHp(personInfo[1]);
				person.setCompany(personInfo[2]);
				personList.add(person);
			}
			for (int i = 0; i < personList.size(); i++) {
				personList.get(i).showInfo();
			}
		} else if (num == 2) {
			System.out.println("<2.등록>");
			while(true) {
				Phonebook person = new Phonebook();
				String str = br.readLine();
				if (str == null) {
					break;
				}
				String[] personInfo = str.split(",");
				person.setName(personInfo[0]);
				person.setHp(personInfo[1]);
				person.setCompany(personInfo[2]);
				personList.add(person);
				
				sc.nextLine();
				System.out.print(">이름: ");
				person.setName(sc.nextInt());
				System.out.print(">휴대전화: ");
				person.setHp(sc.nextInt());
				System.out.print(">회사전화: ");
				person.setCompany(sc.nextInt());
				break;
			}
			
		} else if (num == 3) {
			System.out.println("<3.삭제>");
			
		} else if (num == 4) {
			System.out.println("<4.검색>");
			
		} else if (num == 5) {
			System.out.println("<5.종료>");
			
		} else {
			System.out.println("[다시 입력해 주세요]");
		}

		br.close();
		sc.close();
	}

}
