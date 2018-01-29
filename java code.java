package lavanya;
import java.io.*;
import java.sql.*;

public class db_project {
	   //function to get person data
	   public static int persondata()throws SQLException, NumberFormatException, IOException
	   {
		      //establishing database connection
		      Connection DB1=DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu","sara0003","GYat6Oh7");
		      Statement st1=DB1.createStatement();
		      //reader to hold the values got from user
		      BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));      
   		      System.out.println("Enter the Person SSN");
   		      int p_ssn=Integer.parseInt(br1.readLine());
   		      System.out.println("Enter the Person name");
	          String p_name=(br1.readLine());
	          System.out.println("Enter the Person DOB");
	          String p_dob=(br1.readLine());
	          System.out.println("Enter the Person Race");
	          String p_race=(br1.readLine());
	          System.out.println("Enter the Person Gender");
	          String p_gender=(br1.readLine());
	          System.out.println("Enter the Person Profession");
	          String p_prof=(br1.readLine());
	          System.out.println("Enter the Person Contact details..\n");
	          System.out.println("Enter the Person mailing address");
	          String p_mail=(br1.readLine());
	          System.out.println("Enter the Person Email");
	          String p_email=(br1.readLine());
	          System.out.println("Enter the Person Home_ph_no");
	          int p_hph=Integer.parseInt(br1.readLine());
	          System.out.println("Enter the Person Work_ph_no");
	          int p_wph=Integer.parseInt(br1.readLine());
	          System.out.println("Enter the Person Cell_ph_no");
	          int p_cph=Integer.parseInt(br1.readLine());
	          System.out.println("Enter 1 if Person should be added in mailing list otherwise 0");
	          int p_list=Integer.parseInt(br1.readLine());
	          st1.executeUpdate("insert into Person values('"+p_ssn+"','"+p_name+"','"+p_dob+"','"+p_race+"','"+p_gender+"','"+p_prof+"','"+p_mail+"','"+p_email+"','"+p_hph+"','"+p_wph+"','"+p_cph+"','"+p_list+"')");
	          DB1.close();
	          return p_ssn;
	   }
	   public static void main(String[] args) throws NumberFormatException, IOException {
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   int n;
	   
	   //Loading Oracle Driver
	   try {
		   Class.forName("oracle.jdbc.OracleDriver");
		   System.out.println("Connected");
	       }
	   catch(Exception e) {
		   System.out.println("Unable to load driver class");
	       }
	   
	  //Establishing connection to database
	  try {
		   Connection DB=DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu","sara0003","GYat6Oh7");
		   
		      //Creating Statement object
	          Statement st=DB.createStatement();
	    	  System.out.println("1.Enter a new team into the database");
	    	  System.out.println("2.Enter a new client into the database and associate him or her with one or more teams");
	    	  System.out.println("3.Enter a new volunteer into the database and associate him or her with one or more teams");
	    	  System.out.println("4.Enter the number of hours a volunteer worked this month for a particular team");
	    	  System.out.println("5.Enter a new employee into the database and associate him or her with one or more teams");
	    	  System.out.println("6.Enter an expense charged by an employee");
	    	  System.out.println("7.Enter a new organization and associate it to one or more PAN teams");
	    	  System.out.println("8.Enter a new donor and associate him or her with several donations");
	    	  System.out.println("9.Enter a new organization and associate it with several donations");
	    	  System.out.println("10.Retrieve the name and phone number of the doctor of a particular client");
	    	  System.out.println("11.Retrieve the total amount of expenses charged by each employee for a particular period of time. The list should be sorted by the total amount of expenses");
	    	  System.out.println("12.Retrieve the list of volunteers that are members of teams that support a particular client");
	    	  System.out.println("13.Retrieve the names and contact information of the clients that are supported by teams sponsored by an organization whose name starts with a letter between B and K. The client list should be sorted by name");
	    	  System.out.println("14.Retrieve the name and total amount donated by donors that are also employees. The list should be sorted by the total amount of the donations, and indicate if each donor wishes to remain anonymous");
	    	  System.out.println("15.For each team, retrieve the name and associated contact information of the volunteer that has worked the most total hours between March and June");
	    	  System.out.println("16.Increase the salary by 10% of all employees to whom more than one team must report");
	    	  System.out.println("17.Delete all clients who do not have health insurance and whose value of importance for transportation is less than 5");
	    	  System.out.println("18.Import File to Database");
	    	  System.out.println("19.Export file from Datebase");
	    	  System.out.println("20.Exit from PAN");
	    	  //Loop to perform various options
	    	  do 
	    	  {
	    	  System.out.println("ENTER THE CHOICE YOU WANT TO PERFORM IN PAN SYSTEM");  
	    	  n=Integer.parseInt(br.readLine());  
	    	  switch(n) {
	    	  //Enter a new team into the database
	    	  case 1: System.out.println("Enter the Team name");
	          		  String team_name=(br.readLine());
	          		  System.out.println("Enter the Team type");
	          		  String team_type=(br.readLine());
	          		  System.out.println("Enter the Team formed date");
	          		  String form_date=br.readLine();
	          		  st.executeUpdate("insert into Team values('"+team_name+"','"+team_type+"','"+form_date+"')");
	    	          break;
	    	  //Enter a new client into the database and associate him or her with one or more teams
	    	  case 2: int p_ssn=persondata();
	    		      System.out.println("Now Enter the Client details....");
			          System.out.println("Enter the Doctor name");
			          String doc_name=(br.readLine());
			          System.out.println("Enter the Attorney name");
			          String att_name=(br.readLine());
			          System.out.println("Enter the Doctor phone number");
			          int doc_ph=Integer.parseInt(br.readLine());
			          System.out.println("Enter the Attorney phone number");
			          int att_ph=Integer.parseInt(br.readLine());
			          System.out.println("Enter the client joining date");
			          String client_date=(br.readLine());
			          st.executeUpdate("insert into Client values('"+p_ssn+"','"+doc_name+"','"+att_name+"','"+doc_ph+"','"+att_ph+"','"+client_date+"')");
			          ResultSet set1= st.executeQuery("select team_name from team");
			          System.out.println("Client must be associated to how many teams?");
			          int no_teams=Integer.parseInt(br.readLine());
			          System.out.println("To which team client must be associated from below listed teams");
			          while(set1.next())
			          {
			        	  System.out.println(set1.getString(1));
			          }
			          for(int i=1;i<=no_teams;i++)
			          {
			          System.out.println("Enter "+i+"st team name");
			          String user_tname=(br.readLine());
			          st.executeUpdate("insert into Cares values('"+p_ssn+"','"+user_tname+"',1)");
			          }
			          break;
	    	  //Enter a new volunteer into the database and associate him or her with one or more teams
	    	  case 3: int pv_ssn3=persondata();
			          System.out.println("Now Enter the Volunteer details....");
			          System.out.println("Enter the date that person joined PAN ");
			          String v_date=(br.readLine());
			          System.out.println("Enter the Training join date");
			          String v_train_date=(br.readLine());
			          System.out.println("Enter the Training Location");
			          String v_train_loc=(br.readLine());
			          st.executeUpdate("insert into Volunteer values('"+pv_ssn3+"','"+v_date+"','"+v_train_date+"','"+v_train_loc+"')");
			          ResultSet set2= st.executeQuery("select team_name from team");
			          System.out.println("Volunteer must be associated to how many teams?");
			          int n_o_teams=Integer.parseInt(br.readLine());
			          System.out.println("To which team Voluteer must be associated from below listed teams");
			          while(set2.next())
			          {
			        	  System.out.println(set2.getString(1));
			          }
			          for(int i=1;i<=n_o_teams;i++)
			          {
			          System.out.println("Enter "+i+"st team name");
			          String user_tname3=(br.readLine());
			          System.out.println("Enter the month the voluteer worked");
			          String user_v_month=(br.readLine());
			          System.out.println("Enter number of hours worked for specified month");
			          String user_v_hours=(br.readLine());
			          st.executeUpdate("insert into Serves values('"+pv_ssn3+"','"+user_tname3+"','"+user_v_hours+"',1,'"+user_v_month+"')");
			          }
			          break;
			  //Enter the number of hours a volunteer worked this month for a particular team
	    	  case 4: System.out.println("Enter Volunteer SSN number for whom the hour must be recorded");
			  		  ResultSet set3= st.executeQuery("select P_name,P_SSN from Person where P_SSN in(select P_SSN from volunteer)");
			  		  System.out.println("list of Volunteers...");
			          while(set3.next())
			          {
			        	  System.out.print(set3.getString(1));
			        	  System.out.print("\t"+set3.getString(2)+"\n");
			          } 
			          int user_vpssn=Integer.parseInt(br.readLine());
			          System.out.println("Enter team name for which volunteer date must be recorded from below list of teams");
			          ResultSet set4= st.executeQuery("select team_name from team");
			          while(set4.next())
			          {
			        	  System.out.println(set4.getString(1));
			          } 
			          String user_v_tname=(br.readLine());
			          System.out.println("Enter the hours worked");
			          int user_vhours=Integer.parseInt(br.readLine());
			          System.out.println("Enter the month ");
			          String user_vmonth=(br.readLine());
			          st.executeQuery("insert into serves values('"+user_vpssn+"','"+user_v_tname+"','"+user_vhours+"',1,'"+user_vmonth+"')");
			          break;
			  //Enter a new employee into the database and associate him or her with one or more teams
	    	  case 5: int p_ssn5=persondata();
			          System.out.println("Now Enter the Employee details....");
			          System.out.println("Enter the employee Salary ");
			          float emp_sal=Float.parseFloat(br.readLine());
			          System.out.println("Enter the Employee Marital status");
			          String emp_mstatus=(br.readLine());
			          System.out.println("Enter the Employee hired date");
			          String emp_hdate=(br.readLine());
			          st.executeUpdate("insert into Employee values('"+p_ssn5+"','"+emp_sal+"','"+emp_mstatus+"','"+emp_hdate+"')");
			          ResultSet set6= st.executeQuery("select team_name from team");
			          System.out.println("Employee must be associated to how many teams");
			          int no_of_teams=Integer.parseInt(br.readLine());
			          System.out.println("Employee has to be associated to which team from below list");
			          while(set6.next())
			          {
			        	  System.out.println(set6.getString(1));
			          }
			          
			          for(int i=1; i<=no_of_teams;i++)
			          {
			          System.out.println("Enter" +i+"st team name");
			          String user_tname5=(br.readLine());
			          System.out.println("Enter report description");
			          String r_desc=(br.readLine());
			          System.out.println("Enter report date");
			          String r_date=(br.readLine());
			          st.executeUpdate("insert into Report values('"+p_ssn5+"','"+user_tname5+"','"+r_desc+"','"+r_date+"')");
			          }
			          break;
		   	  //Enter an expense charged by an employee
	    	  case 6: System.out.println("List of Employees..."); 
		   		  	  ResultSet set7= st.executeQuery("select P_SSN,P_name from person where p_ssn in(Select p_ssn from Employee)");
			          while(set7.next())
			          {
			        	  System.out.println(set7.getString(1));
			          }
			          System.out.println("Enter Employee ssn for whom expense must be recorded");
		   	  		  int e_ssn=Integer.parseInt(br.readLine());
			          System.out.println("Enter date of expense");
			          String expense_date=(br.readLine());
			          System.out.println("Enter amount of expenditure");
			          float expense_amount=Float.parseFloat(br.readLine());
			          System.out.println("Enter description of expense");
			          String expense_desc=(br.readLine());
			          st.executeUpdate("insert into Expense values('"+e_ssn+"','"+expense_date+"','"+expense_amount+"','"+expense_desc+"')");
		              break;
	    	  //Enter a new organization and associate it to one or more PAN teams
	    	  case 7: System.out.println("Enter Organization name");
		   	  		  String o_name=(br.readLine());
			          System.out.println("Enter organization address");
			          String o_add=(br.readLine());
			          System.out.println("Enter organization phone number");
			          float o_phno=Float.parseFloat(br.readLine());
			          System.out.println("Enter contact person of that organization ");
			          String o_contact=(br.readLine());
			          st.executeUpdate("insert into Ext_Org values('"+o_name+"','"+o_add+"','"+o_phno+"','"+o_contact+"')");
			          System.out.println("How many teams the organization wants to sponsor");
			          int no_of_team=Integer.parseInt(br.readLine());
			          ResultSet set8= st.executeQuery("select team_name from team");
			          System.out.println("list of teams...");
			          while(set8.next())
			          {
			        	  System.out.println(set8.getString(1));
			          }
			          for(int i=1;i<=no_of_team;i++)
			          {
			          System.out.println("Name the "+i+"st team the oragnization wants to sponsor");
			          String o_tname=(br.readLine());
			          st.executeUpdate("insert into Sponsors values('"+o_name+"','"+o_tname+"')");
			          }
			          break;
	    	  //Enter a new donor and associate him or her with several donations
	    	  case 8: int p_ssn8=persondata();
	    	  		  System.out.println("How many donations the the donor has made");
	          		  int no_of_donation=Integer.parseInt(br.readLine());
	          		  for(int i=1;i<=no_of_donation;i++)
	          		  {  
	          		  System.out.println("Enter details of "+i+"th donor"); 
			    	  System.out.println("Type 'yes' if the donor remains to be anonymous otherwise 'no'");
			          String anon=(br.readLine());
			          st.executeUpdate("insert into Donor values('"+p_ssn8+"','"+anon+"')");
			          System.out.println("Hit 1 for cheque payment and 0 for card payment");
			          int pay=Integer.parseInt(br.readLine());
			          System.out.println("Enter Date of donation");
		   	  		  String d_date=(br.readLine());
			          System.out.println("Enter donation amount");
			          float d_amount=Float.parseFloat(br.readLine());
			          System.out.println("Enter donation type");
			          String d_type=(br.readLine());
			          System.out.println("Enter fund name ");
			          String d_fundname=(br.readLine());
			          if(pay==1)
			        	  {
			        	  System.out.println("Enter cheque number ");
			          	  int d_cheqno=Integer.parseInt(br.readLine());
			        	  st.executeUpdate("insert into cheque values('"+p_ssn8+"','"+d_date+"','"+d_amount+"','"+d_type+"','"+d_fundname+"','"+d_cheqno+"')");
			        	  }
			          else
			          	  {
			        	  System.out.println("Enter card number ");
		          	      int ca_no=Integer.parseInt(br.readLine());
		          	      System.out.println("Enter card type ");
			          	  String ca_type=(br.readLine());
			          	  System.out.println("Enter card expiry date ");
			          	  String ca_expdate=(br.readLine());
			          	  st.executeUpdate("insert into card values('"+p_ssn8+"','"+d_date+"','"+d_amount+"','"+d_type+"','"+d_fundname+"','"+ca_no+"','"+ca_type+"','"+ca_expdate+"')");
	          		      }
	          		  }
	          		  break;
	    	  //Enter a new organization and associate it with several donations
	    	  case 9: System.out.println("Enter Organization name");
		   	  		  String o_name9=(br.readLine());
			          System.out.println("Enter organization address");
			          String o_add9=(br.readLine());
			          System.out.println("Enter organization phone number");
			          float o_phno9=Float.parseFloat(br.readLine());
			          System.out.println("Enter contact person of that organization ");
			          String o_contact9=(br.readLine());
			          st.executeUpdate("insert into Ext_Org values('"+o_name9+"','"+o_add9+"','"+o_phno9+"','"+o_contact9+"')");
	    		  	  System.out.println("How many donations the the donor has made");
		      		  int no_of_don=Integer.parseInt(br.readLine());
		      		  for(int i=1;i<=no_of_don;i++)
		      		  {  
		      		  System.out.println("Enter details of "+i+"th donor"); 
			    	  System.out.println("Type 'yes' if the donor remains to be anonymous otherwise 'no'");
			          String anon9=(br.readLine());
			          st.executeUpdate("insert into Org_donors values('"+o_name9+"','"+anon9+"')");
			          System.out.println("Hit 1 for cheque payment and 0 for card payment");
			          int pay9=Integer.parseInt(br.readLine());
			          System.out.println("Enter Date of donation");
		   	  		  String d_date9=(br.readLine());
			          System.out.println("Enter donation amount");
			          float d_amount9=Float.parseFloat(br.readLine());
			          System.out.println("Enter donation type");
			          String d_type9=(br.readLine());
			          System.out.println("Enter fund name ");
			          String d_fundname9=(br.readLine());
			          if(pay9==1)
			        	  {
			        	  System.out.println("Enter cheque number ");
			          	  int d_cheqno9=Integer.parseInt(br.readLine());
			        	  st.executeUpdate("insert into org_donation_cheque values('"+o_name9+"','"+d_date9+"','"+d_amount9+"','"+d_type9+"','"+d_fundname9+"','"+d_cheqno9+"')");
			        	  }
			          else
			          	  {
			        	  System.out.println("Enter card number ");
		          	      int ca_no9=Integer.parseInt(br.readLine());
		          	      System.out.println("Enter card type ");
			          	  String ca_type9=(br.readLine());
			          	  System.out.println("Enter card expiry date ");
			          	  String ca_expdate9=(br.readLine());
			          	  st.executeUpdate("insert into Org_donation_card values('"+o_name9+"','"+d_date9+"','"+d_amount9+"','"+d_type9+"','"+d_fundname9+"','"+ca_no9+"','"+ca_type9+"','"+ca_expdate9+"')");
		      		      }
		      		  }
		               break;
	    	  //Retrieve the name and phone number of the doctor of a particular client
	    	  case 10: ResultSet set10= st.executeQuery("select P_name from person where P_SSN in(select P_SSN from client)");
	    	  		   System.out.println("Enter the client name(from below list) for whom doctor name must be retrieved ");
	    	           while(set10.next())
          	  		   {
          	  			System.out.println(set10.getString(1));
          	  		   }
	    	           String Cl_name10=(br.readLine());
	    	           ResultSet set11= st.executeQuery("select doc_name, doc_ph from client where p_ssn in(select p_ssn from person where p_name='"+Cl_name10+"')");
	    	           System.out.println("doctor name\tdoctor ph.no");
	    	           while(set11.next())
          	  		   {
          	  			System.out.println(set11.getString(1)+"\t\t   "+set11.getString(2));
          	  		   }
	    	           break;
	    	  //Retrieve the total amount of expenses charged by each employee for a particular period of time. The list should be sorted by the total amount of expenses
	    	  case 11: System.out.println("Enter start of the period(dd-month-yyyy)");
	    	  		   String start_date=(br.readLine());
	    	  		   System.out.println("Enter end of the period(dd-month-yyyy)");
	    	  		   String end_date=(br.readLine());
	    	  		   ResultSet set12= st.executeQuery("select sum(expense_amount), p_ssn from expense where expense_date between '"+start_date+"' and '"+end_date+"' group by p_ssn order by sum(expense_amount)");
	    	  		   System.out.println("total expense\t\temployee ssn");
	    	  		   while(set12.next())
        	  		   {
        	  			System.out.println(set12.getString(1)+"\t\t   "+set12.getString(2));
        	  		   }
	    	  		   break;
	    	  //Retrieve the list of volunteers that are members of teams that support a particular client
	    	  case 12: System.out.println("Enter the client ssn number from the below list");
	    	  		   ResultSet set13= st.executeQuery("select p_name, p_ssn from person where p_ssn in(select p_ssn from client)");
	    	  		   while(set13.next())
			           {
			        	  System.out.println(set13.getString(1)+"\t"+set13.getString(2));
			           }
	    	  		   int c_pssn12=Integer.parseInt(br.readLine());
	    	  		   ResultSet set14= st.executeQuery("select p_name from person where p_ssn in(select p_ssn from volunteer where p_ssn in(select p_ssn from serves where team_name in(select team_name from cares where p_ssn='"+c_pssn12+"')))");
	    	  		   System.out.println("List of volunteers are as follows");
	    	  		   while(set14.next())
		               {
		            	System.out.println(set14.getString(1));   
		               }
	    	  		   break;
	    	  //Retrieve the names and contact information of the clients that are supported by teams sponsored by an organization whose name starts with a letter between B and K. The client list should be sorted by name
	    	  case 13: System.out.println("Name and contact information of client those are supported by team that are sponsored by oraganization having names with starting letter b to k");
	    	  		   ResultSet set16= st.executeQuery("select p_name, mail_add,email_add,home_ph,work_ph,cell_ph from person where p_ssn in(select p_ssn from cares where team_name in(select team_name from sponsors where org_name in(select org_name from ext_org where org_name between 'b%' and 'k%'))) order by p_name");	
	    	  		   System.out.println("Client name  mail address  home ph  \twork ph  \tcell ph");
	    	  		   while(set16.next())
		               {
		            	System.out.println(set16.getString(1)+"\t\t"+set16.getString(2)+"\t\t"+set16.getString(3)+"\t"+set16.getString(4)+"\t"+set16.getString(5));   
		               }
	    	  		   break;
	    	  //Retrieve the name and total amount donated by donors that are also employees. The list should be sorted by the total amount of the donations, and indicate if each donor wishes to remain anonymous
	    	  case 14: System.out.println("Retrieving the name and total amount...");
	    	  		   System.out.println("name\t\tamount\t\tstatus");
	    	  		   ResultSet set31=st.executeQuery("select P.p_name,X.M,X.stat from(select max(a)as M,p_ssn,stat from(select p.p_name,d.anon_status as stat,d.p_ssn,(ca.amount+c.amount)as a from person p,employee e,donor d,cheque c, card ca where d.p_ssn=e.p_ssn )k group by p_ssn,stat)X, person P where X.p_ssn=P.p_ssn");
	    	  		   while(set31.next())
	    	  		   {
	    	  			 System.out.println("hi");
	    	  			   System.out.println(set31.getString(1)+"\t"+set31.getString(2)+"\t"+set31.getString(3));
	    	  		   }   
		               break;
	    	  //For each team, retrieve the name and associated contact information of the volunteer that has worked the most total hours between March and June
	    	  case 15: System.out.println("Retrieving the person name....");
	    	  		   ResultSet set30= st.executeQuery("select p_name,mail_add,email_add,home_ph,work_ph,cell_ph from person,serves where person.p_ssn=serves.p_ssn and (serves.team_name,serves.hours) in (select team_name,max(hours) from serves where month in ('March','April','May','June') group by team_name)");
		               while(set30.next())
		               {
		            	 System.out.println(set30.getString(1)+"\t\t"+set30.getString(2)+"\t\t"+set30.getString(3)+"\t"+set30.getString(4)+"\t"+set30.getString(5)+"\t"+set30.getString(6));   
		               }   
	    	  		   break;
	    	  //Increase the salary by 10% of all employees to whom more than one team must report
	    	  case 16: ResultSet set17= st.executeQuery("select * from employee");	
	    	  		   System.out.println("Employee ssn\temployee salary\tmarital status\thire date");
	    	           while(set17.next())
		               {
		            	System.out.println(set17.getString(1)+"\t\t"+set17.getString(2)+"\t\t"+set17.getString(3)+"\t"+set17.getString(4));   
		               }
	    	  	       System.out.println("Updating the salary...");
	    	  	       st.executeQuery("update employee set e_salary=e_salary+(0.1*e_salary) where p_ssn in(select p_ssn from report group by p_ssn having count(team_name)>1)");
	    		  	   System.out.println("Salary updated");
	    		  	   ResultSet set18= st.executeQuery("select * from employee");	
	    	  	       while(set18.next())
		               {
		            	System.out.println(set18.getString(1)+"\t\t"+set18.getString(2)+"\t\t"+set18.getString(3)+"\t"+set18.getString(4));   
		               }
	    		  	   break;
	    	  //Delete all clients who do not have health insurance and whose value of importance for transportation is less than 5
	    	  case 17: ResultSet s19= st.executeQuery("select * from client");
	    	  		   System.out.println("Displaying client table");
	    	  		   System.out.println("client ssn doctor name  attorny name  doctor ph  attorny ph client date");
	    	  		   while(s19.next())
			           {
			        	  System.out.println(s19.getString(1)+"\t"+s19.getString(2)+"\t"+s19.getString(3)+"\t"+s19.getString(4)+"\t"+s19.getString(5)+"\t"+s19.getString(6));
			           }
	    	  		   st.executeQuery("delete from client where p_ssn not in( select p_ssn from insurance_policy where p_type='health insurance') and p_ssn in(select p_ssn from needs where type='transportation' and value between 1 and 10)");
	    	  		   ResultSet set20= st.executeQuery("select * from client");
	    	  		   System.out.println("Displaying client table after deletion");
	    	  		   System.out.println("client ssn doctor name  attorny name  doctor ph  attorny ph client date");
	    	  		   while(set20.next())
			           {
			        	  System.out.println(set20.getString(1)+"\t"+set20.getString(2)+"\t"+set20.getString(3)+"\t"+set20.getString(4)+"\t"+set20.getString(5)+"\t"+set20.getString(6));
			           }
	    	  		   break;
	    	  //Import File to Database
	    	  case 18: System.out.println("Enter import file name: ");
	    	  	       String file_name=br.readLine();
	    	       	   FileInputStream fstream = new FileInputStream("D:\\"+file_name);
	    	           DataInputStream in = new DataInputStream(fstream);
	    	           BufferedReader br1 = new BufferedReader(new InputStreamReader(in));
	    	           String i_data;
			    	   while ((i_data = br1.readLine()) != null)
			    	   {
			    	   String data[] = i_data.split(";");
			    	   String e_p_ssn = data[0];
			    	   String emg_name = data[1];
			    	   String emg_contact = data[2];
			    	   String emg_relation = data[3];
			    	   st.executeUpdate("insert into emergency_contact values('"+e_p_ssn+"','"+ emg_name+ "','" + emg_contact + "','" +emg_relation+ "')");
			    	   System.out.println(" One row inserted succesfully");
			    	   }
			    	   System.out.println("File imported succesfully!!!");
		               break;
	    	  //Export File to Database
	    	  case 19:ResultSet set21 = st.executeQuery("select * from ext_org");
			    	  String string = null;
			    	  System.out.println("Enter output file name: ");
			    	  String file_name1=br.readLine();
			    	  BufferedWriter export = new BufferedWriter(new
			    	  FileWriter("D:\\"+file_name1));
			    	  while(set21.next())
			    	  {
			    	  string= set21.getString("org_name")+" "+set21.getString("org_add")+" "+set21.getString("org_ph")+" "+set21.getString("org_contact");
			    	  export.write("\n");
			    	  export.write(string);
			    	  export.write("\n");
			    	  System.out.println(" One row inserted succesfully!");
			    	  }
			    	  System.out.println(" File exported succesfully!!!");
			    	  export.close();
		              break;
	    	  //To exit from PAN
	    	  case 20: System.exit(0);
	    	          break;
	    	  }
	      }while(n<20);
	      //Close the database connectivity	  
          DB.close();
	   }
	   //To catch any exception in database connectivity
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
	  } 
}


