create table Person(P_SSN integer, P_Name varchar(20), Date_of_birth date, Race varchar(20), Gender varchar(7),Profession varchar(20),Mail_Add varchar(20),Email_Add varchar(30),Home_Ph integer,Work_Ph integer, Cell_Ph integer,Mail_list integer, PRIMARY KEY(P_SSN));

create table Client(P_SSN integer, Doc_name varchar(20),Att_name varchar(20), Doc_Ph integer,Att_Ph integer,C_Date date, FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Volunteer(P_SSN integer, Join_Date date,Train_Date date,Train_Loc varchar(20), FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Employee(P_SSN integer, E_Salary float,M_Status varchar(8),Hire_Date date, FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Donor(P_SSN integer, Anon_Status varchar(3), FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Emergency_Contact(P_SSN integer, E_Name varchar(20),Contact integer,Relation varchar(10), PRIMARY KEY(E_Name,Contact),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Needs(P_SSN integer, Type varchar(10),Value integer, FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Cheque(P_SSN integer, D_Date date,Amount float,Type varchar(15),Fund_Name varchar(20),Cheque_no integer,PRIMARY KEY(D_Date,Amount,Type,Fund_Name), FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Card(P_SSN integer, D_Date date,Amount float,Type varchar(15),Fund_Name varchar(20),Card_no integer,Card_type varchar(10),Exp_date date,PRIMARY KEY(D_Date,Amount,Type,Fund_Name), FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Team(P_SSN integer, Team_name varchar(20),Team_type varchar(20),T_date date,Report_desc varchar(20),Report_date date, PRIMARY KEY(Team_name),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Leads(P_SSN integer, Team_name varchar(20),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Serves(P_SSN integer, Team_name varchar(20),Hours integer,Month varchar(10),Active integer,FOREIGN KEY(Team_name) REFERENCES Team(Team_name));

create table Expense(P_SSN,Expense_date date,Expense_amount float,Expense_Desc varchar(20),FOREIGN KEY(P_SSN) REFERENCES person(P_SSN));

create table Cares(P_SSN integer, Team_name varchar(20),Status integer,FOREIGN KEY(Team_name) REFERENCES Team(Team_name),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
create table Insurance_Policy(P_SSN,Policy_id integer,Provider_id integer,Pr_address varchar(20),P_type varchar(20), PRIMARY KEY(Policy_id),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Ext_Org(Org_name varchar(20),Org_Add varchar(20),Org_Ph integer,Org_Contact varchar(20), PRIMARY KEY(Org_name));

create table Business(Org_name varchar(20),Business_type varchar(20),Business_size integer,Website varchar(30),FOREIGN KEY(Org_name) REFERENCES Ext_Org(Org_name));

create table Church(Org_name varchar(20),Affiliation varchar(20),FOREIGN KEY(Org_name) REFERENCES Ext_Org(Org_name));

create table Affiliated(Org_name varchar(20),P_SSN integer,FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));

create table Org_donors(Org_name varchar(20), Org_Anon_Status varchar(3),FOREIGN KEY(Org_name) REFERENCES Ext_Org(Org_name));

create table Org_Donation_cheque(Org_name varchar(20), Org_Don_Date date,Org_Don_Amount float,Org_Don_Type varchar(20),Org_Don_Fund_name varchar(20),Org_Don_cheqno integer,PRIMARY KEY(Org_Don_Date,Org_Don_Amount,Org_Don_Type,Org_Don_Fund_name),FOREIGN KEY(Org_name) REFERENCES Ext_Org(Org_name));

create table Org_Donation_card(Org_name varchar(20), Org_Don_Date date,Org_Don_Amount float,Org_Don_Type varchar(20),Org_Don_Fund_name varchar(20),Org_Don_Cno integer,Org_Don_Ctype varchar (10),Org_Don_Expdate date,PRIMARY KEY(Org_Don_Date,Org_Don_Amount,Org_Don_Type,Org_Don_Fund_name),FOREIGN KEY(Org_name) REFERENCES Ext_Org(Org_name));

create table Sponsors(Org_name varchar(20), Team_name varchar(20), FOREIGN KEY(Org_name) REFERENCES Ext_Org(Org_name), FOREIGN KEY(Team_name) REFERENCES Team(Team_name));

create table report( P_SSN integer,team_name varchar(20),report_desc varchar(20),report_date date,FOREIGN KEY(team_name) REFERENCES team(team_name));

create Index C_pssn on client(P_SSN);

create Index E_pssn on employee(P_SSN);

create Index S_tname on serves(team_name);

create Index S_mname on serves(month_name);

create Index N_type_value on needs(need_type,need_value);

create Index e_date on expense(expense_date);


create Index C_tname on cares(team_name);

create Index Ca_pssn on cares(p_ssn);

create Index I_ptype on Insurance_policy(p_type);

create Index Sp_orgname on sponsors(org_name);
