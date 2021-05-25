package de.tekup.loanwhitetest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;


import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.Address;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Service
public class ReservationService {  
	/***declaration des etudiants***/
	Student s1;
	Student s2;
	Student s3;
	Student s4;
	Student s5;
	
	/***declaration des Examen***/
	Exam E1;
	Exam E2;
	Exam E3;
	Exam E4;
	Exam E5;
	
	/***declaration des Adress***/
	Address A1;
	Address A2;
	Address A3;
	Address A4;
	Address A5;
	ArrayList<Exam> listExam;
	ArrayList<Student> listStudent;
	ArrayList<Address> listAddress;
	int i;
	int j;
	boolean test=false;
	boolean test2=false;
	int k;
	int m;
	int l;
	int p;
	public WhiteTestResponse reservation(StudentRequest studentrequest) throws Exception {
/****************************************************************************/		
		s1=new Student(1,"virgil",A1);
		s2=new Student(2,"leonle",A2);
		s3=new Student(3,"jean",A3);
		s4=new Student(4,"paul",A4);
		s5=new Student(5,"ahmed",A5);
		
		/*** creation d'une liste d'etudiant ***/
	    listStudent=new ArrayList<Student>();
	    
	    	listStudent.add(s1); 
	    	listStudent.add(s2); 
	    	listStudent.add(s3); 
	    	listStudent.add(s4); 
	    	listStudent.add(s5); 
		
/****************************************************************************/
		E1=new Exam("ex1","java");
		E2=new Exam("ex2","bigData");
		E3=new Exam("ex3","android");
		E4=new Exam("ex4","compilation");
		E5=new Exam("ex5","c++");
		
		
       /*** creation d'une liste d'examen ***/
		listExam=new ArrayList<Exam>();
		
			listExam.add(E1);
			listExam.add(E2);
			listExam.add(E3);
			listExam.add(E4);
			listExam.add(E5);
			
/*********************************,*******************************************/	
			A1=new Address("street1","city1","postcode1");
			A2=new Address("street2","city2","postcode2");
			A3=new Address("street3","city3","postcode3");
			A4=new Address("street4","city4","postcode4");
			A5=new Address("street5","city5","postcode5");
			
			
		/*** creation d'une liste d'address ***/
		listAddress=new ArrayList<Address>();
			
			listAddress.add(A1);
			listAddress.add(A2);
			listAddress.add(A3);
			listAddress.add(A4);
			listAddress.add(A5);	
		
		
		WhiteTestResponse whiteTestResponse= new WhiteTestResponse();
		
		for(k=0;k<listStudent.size();k++) {
			if(studentrequest.getStudentId()==listStudent.get(k).getId() ) {
				test=true;
				break;
			}	
		}
		
		
		
		if(studentrequest.getStudentId()>listStudent.size()) {
			test=false;
			
		}
			
		for(p=0;p<listExam.size();p++) {
			if(studentrequest.getExamCode().equalsIgnoreCase(listExam.get(p).getCode())){
				test2=true;
				break;
			}
		   }
		
		if(p>listExam.size()){
			test2=false;
			
		}
		
		if(test==true && test2==true) {
					
				for(i=0;i<listStudent.size();i++) {
					if(studentrequest.getStudentId()==listStudent.get(i).getId()){ 
						break;
					   }else  {
							test=false;
						}
				   }
				
				whiteTestResponse.setStudent(listStudent.get(i));
				
			
				for(j=0;j<listExam.size();j++) {
					if(studentrequest.getExamCode().equalsIgnoreCase(listExam.get(j).getCode())){
					break;
					}else  {
						test2=false;
					}
				   }
				
				whiteTestResponse.setExam(listExam.get(j));
				
				LocalDateTime localDate = LocalDateTime.now().plusDays(2);
				XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
				whiteTestResponse.setDate(xmlGregorianCalendar);
			}	
				
				
				else if(test==false){
					whiteTestResponse.setBadRequests("wrong student id");
					whiteTestResponse.setIspresent(true);
				  }
				else if(test2==false){
						whiteTestResponse.setBadRequests("this exam is not present");
						whiteTestResponse.setIspresent(true);
					  }
	
		return whiteTestResponse;
	}
    
	
	
	
}
