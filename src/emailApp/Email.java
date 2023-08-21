package emailApp;

import java.util.Scanner;

public class Email {
        private String firstName;
        private  String lastName;
        private String password;
        private String email;
        private int mailboxCapacity = 500;
        private int defaultPasswordLength = 10;
        private String department;
        private String alternateEmail;
        private String comapanySuffix = "xyz.com";

        public Email( String firstName, String lastName){
                this.firstName = firstName;
                this.lastName = lastName;
                System.out.println(" EMAIL CREATED: " + this.firstName + " " + this.lastName);

                //Call a method asking for department
                this.department = setDepartment();
                System.out.println("Department: "+ this.department);

                //Call a method that return a random password
                this.password = randomPassword(defaultPasswordLength);
                System.out.println("Your password is: "+ this.password);

                //Combine elements to generate emails
                email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + comapanySuffix;
                System.out.println("Your Email is: " + this.email);
        }

        private String setDepartment() {
                System.out.println(" Enter the department\n1. Salse\n2. Developement \n3. Accounting \n0. None ");
                Scanner in = new Scanner(System.in);
                int deptChoice = in.nextInt();
                if(deptChoice == 1) return "sales";
                else if(deptChoice == 2) return "dev";
                else if(deptChoice == 3) return "accounting";
                else return "";
        }

        private String randomPassword(int length) {
                String passwordSet = "ABCDEFGHIJKLMNOPQXYZ1234567890!@#$%^&*()";
                char[] password = new char[length];
                for(int i=0; i<length; i++){
                        int rand = (int)(Math.random()*passwordSet.length());
                        password[i] = passwordSet.charAt(rand);
                }
                return new String(password);
        }
        
        public void setMailBoxCapacity(int capacity) {
                this.mailboxCapacity = capacity;
        }
        
        public void setAlternateEmail(String altEmail){
                this.alternateEmail = altEmail;
        }
        
        public void changePassword(String changePass) {
                this.password = changePass;
        }

        public int getMailboxCapacity() {
                return mailboxCapacity;
        }

        public String getAlternateEmail() {
                return alternateEmail;
        }

        public String getNewPassword() {
                return password;
        }

        public void showInfo(){
                System.out.println("Name: "+ firstName+" "+ lastName);
                System.out.println("Department: "+ department);
                System.out.println("Email: "+ email);
        }
}