/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result_management_system;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arnab
 */
   class student {
       
    private String student_id;
    private String student_name;
    private double student_CGPA;
    private String student_department;
    
    
    void student(String student_id,String student_name,double student_CGPA,String student_department){
        
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_CGPA = student_CGPA;
        this.student_department = student_department;
        
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public double getStudent_CGPA() {
        return student_CGPA;
    }

    public void setStudent_CGPA(double student_CGPA) {
        this.student_CGPA = student_CGPA;
    }

    public String getStudent_department() {
        return student_department;
    }

    public void setStudent_department(String student_department) {
        this.student_department = student_department;
    }

    public String tostring(){
        return "Student ID :"+student_id+" Student Name : "+student_name+" Student CGPA : "+student_CGPA+" Department : "+student_department;
    }
}


public class ResultManagmentSystem{
    
    public static void main(String[] args) {
      
        while(true){
            System.out.println("Welcome!");
        Scanner number = new Scanner(System.in);
        System.out.println("1:Registration\n"
                         + "2:Login\n"
                         + "3:Exit");
                 int a = number.nextInt();
                 if(a==1){
                     Registration regis = new Registration();
                     regis.Registration();
                 }
                 if(a==2){
                    login log = new login();
                    log.login();
                     }
                 if(a==3){
                   break;
            }
        }
    }
}


class login{
         
	public Scanner input = new Scanner(System.in);
        public ArrayList<student> list = new ArrayList<student>();
        public void login() { 
       
        try(Scanner inp1 = new Scanner(System.in)){
            
            System.out.println("Enter username :");
            String Username = inp1.next();
            
            System.out.println("Enter password :");
            String password = inp1.next();
            Register regis = new Register();
           
            if("a".equals(Username) && "a".equals(password)){
                
                System.out.println("Successfully logged in....");
      while(true){ Scanner inp = new Scanner (System.in);
          System.out.println("Result Management System");
          System.out.println("1:Student Information\n"
                           + "2:Modify Information\n"
                           + "3:Search Student Info By ID\n"
                           + "4:Grading\n"
                           + "5:Print all Data\n"
                           + "6:Exit\n"
                           + "Choose your options = ");
        
            int n = inp.nextInt();
        
            if(n==1){
            
            add();
            
               }
            if(n==2) {
                modify();
                    }
            if(n==3){
                find();
            }
            if(n==4) {
                
               Grade();
               
                 }
            if(n==5){
            try {  
            File file = new File("Student.txt"); 
            student Student = new student();
            
            //for(){
               // System.out.println(Student.tostring());
            //}
                System.out.println("");
            if (file.createNewFile()) {  
                System.out.println("New File is created!");  
            } else {  
                System.out.println("File already exists.");  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
                }
                    if(n==6){
                    break;
                    }
                }
            }
         else{
         System.out.println("invalid username or password");
        }
    }
        
} 
        public void add(){
		 
                System.out.println("Please enter the student ID number");
                 
                student Student = new student();
		String student_id = input.next();
		Student.getStudent_id();
		
		if (checkNum(student_id)) {
			 System.out.println("This Student Data already exists...");
			 login A = new login();
		         A.login();
		}else {
                    
            
                  System.out.println("Student Name :");
                  String student_name = input.next();
                  Student.setStudent_name(student_name);
            
                  System.out.println("CGPA");
                  double student_CGPA = input.nextDouble();
                  Student.setStudent_CGPA(student_CGPA);
            
                  System.out.println("Department");
                  String student_department = input.next();
                  Student.setStudent_department(student_department);
            
            
                  System.out.println(Student.tostring());
                  list.add(Student);
		  System.out.println();
		  System.out.println("Student's Data Successfully Store");
		  System.out.println();
		  login A = new login();
		  A.login();
                        
		}
	}
      public void show() {
		System.out.println("Student Information");
		for (int i = 0; i <list.size(); i++) {
			
			System.out.println(list.get(i).toString());
			
		}
		System.out.println(); 
                login A = new login();
	        A.login();
	}
   
	public void delete() {
		 System.out.println("Please enter the student  ID number");
		 String student_id = input.next();
		
		if (checkNum(student_id)) {
			student student=getStudentByID(student_id);
			
			if (student != null) {
				list.remove(student);
			}
			System.out.println();
			System.out.println("Student Information Deleted Successfully ");
			System.out.println();
			login A = new login();
		        A.login();
		
                }
                else {
			 System.out.println("The student ID number does not exist.....");
			 System.out.println();
			 login A = new login();
		         A.login();
		     }
		
	}
 
 
	public void modify() {
		 System.out.println("Please enter the student ID number to modify the student");
		 String student_id=input.next();
		
		if (checkNum(student_id)) {
			student student=getStudentByID(student_id);
			
			if (student!=null) {
				System.out.println(student.toString());
				
				modefyDetail(student);
			
			}
			
		}else {
			 System.out.println("The student ID number does not exist.....");
			 System.out.println();
			 login A = new login();
		         A.login();
		}
		
	}
 
        
	public void modefyDetail(student student) {
		
		 System.out.println("1.Modify the student number");
		 System.out.println("2.Modify the name");
		 System.out.println("3.Modify Department");
		 System.out.println("4.Modify grades");
		 System.out.println("5.Exit");
		 System.out.println("Please enter the menu item to be modified");
		
		int choose=input.nextInt();
		
		if (choose==1) {
			 System.out.println("Please enter a new student ID number...");
			String ID =input.next();
			
			if (checkNum(ID)) {
				 System.out.println("This Student Data already exists... please re-enter");
				modefyDetail(student);
			}else {
				student.setStudent_id(ID);
			}
			
			modefyDetail(student);
			
		}else if(choose==2){
                    
			 System.out.println("Please enter a new name...");
			String name=input.next();
			
			student.setStudent_name(name);
			
			modefyDetail(student);
			
		}else if(choose==3){
			System.out.println("Please enter a new department...");
			String department=input.next();
			
			student.setStudent_department(department);
			
			modefyDetail(student);
			
		}else if(choose==4){
			 System.out.println("Please enter a new C.G.P.A...");
			double cg=input.nextDouble();
			
			student.setStudent_CGPA(cg);
			
			modefyDetail(student);
			
		}else if(choose==5){
			login A = new login();
		        A.login();
		}else {
			 System.out.println("Please enter the correct menu item...");
			modefyDetail(student);
		}
		
	}
 
        
	public void find() {
		 System.out.println("Please enter the student ID number");
		 String num=input.next();
		
		if (checkNum(num)) {
			student student=getStudentByID(num);
			
			if (student!=null) {
				System.out.println(student.toString());
				System.out.println();
				login A = new login();
		                A.login();
			}
			
		}else {
			 System.out.println("The student ID number does not exist.....");
			 System.out.println();
			 login A = new login();
		         A.login();
		}
 
		
	}
 
	
	
	public boolean checkNum(String student_id){
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStudent_id().equals(student_id)) {
				return true;
			}
		}
		
		return false;
	}
	
	public student getStudentByID(String student_id){
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStudent_id().equals(student_id)) {
				return list.get(i);
			}
		}
		return null;
		
	}

	public void exitProgram(){
            
		System.out.println("Exit Successfully");

		System.exit(0);
	}
        
   public void Grade(){
	
       int marks[] = new int[6];
       int i;
       float total=0, avg;
       
        Scanner scanner = new Scanner(System.in);
		
        
        for(i=0; i<6; i++) { 
           System.out.print("Enter Marks of Subject"+(i+1)+":");
           marks[i] = scanner.nextInt();
           total = total + marks[i];
        }
        scanner.close();
        
        avg = total/6;
        System.out.print("The student Grade is: ");
        if(avg>=80)
        {
            System.out.print("A");
        }
        else if(avg>=60 && avg<80)
        {
           System.out.print("B");
        } 
        else if(avg>=40 && avg<60)
        {
            System.out.print("C");
        }
        else
        {
            System.out.print("D");
        }
		System.out.println();
		login A = new login();
                A.login();
	}
        
}
class Registration{
    
    public void Registration() {
   
       Register register = new Register();
        Scanner input = new Scanner(System.in);{
            
            System.out.println("Student Name :");
            String student_Name = input.next();
            register.setStudent_Name(student_Name);
            
            System.out.println("Student Email ID :");
            String student_emailID = input.next();
            register.setStudent_emailID(student_emailID);
            
            System.out.println("Student Username :");
            String student_username = input.next();
            register.setStudent_userame(student_username);
            
            System.out.println("Password :");
            String student_password = input.next();
            register.setstudent_Password(student_password);
            
            System.out.println(register.getStudent_Name());
            System.out.println(register.getStudent_emailID());
            System.out.println(register.getStudent_userame());
            System.out.println(register.getstudent_Password());
            }
        }
   }
class Register{
    
    private String student_Name;
    private String student_emailID;
    private String student_username;
    private String student_password;
    
    
    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getStudent_emailID() {
        return student_emailID;
    }

    public void setStudent_emailID(String student_emailID) {
        this.student_emailID = student_emailID;
    }

    public String getStudent_userame() {
        return student_username;
    }

    public void setStudent_userame(String student_userame) {
        this.student_username = student_userame;
    }

    public String getstudent_Password() {
        return student_password;
    }

    public void setstudent_Password(String student_password) {
        this.student_password = student_password;
    }
    
}

