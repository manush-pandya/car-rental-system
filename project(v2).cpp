#include<iostream>
#include<string.h>
#include<fstream>
#include<stdio.h>
using namespace std;

class hospital_mgmt
{
public:	
	int patient_id;
	string patient_name;
	int doctor_id;
	char doctor_name[10];
	int ward_no;
	char date_of_arrival[10];
	char disease_found[10];
	int type_of_ward;
	int treatment_type;
	char treated_by_doctor[10];
	
	void display_patient()
	{
		cout<<"patient id:"<<patient_id<<endl;
		cout<<"patient name: "<<patient_name<<endl;
		cout<<"ward no. : "<<ward_no<<endl;
		cout<<"date of arrival(dd/mm/yyyy): "<<date_of_arrival<<endl;
		cout<<"disease found: "<<disease_found<<endl;
		cout<<"type of ward: ";
		if(type_of_ward==1)
		{
			cout<<" neuro"<<endl;
		}
		else if(type_of_ward==2)
		{
			cout<<" emergency"<<endl;
		}
		else if(type_of_ward==3)
		{
			cout<<" cardio"<<endl;
		}
		if(treatment_type==1)
			cout<<"treatment type: severe"<<endl;
		else
			cout<<"treatment type: general: "<<endl;
		cout<<"name of doctor treating the patient: "<<treated_by_doctor<<endl;	
	}
	
	void display_doctor()
	{
		cout<<"doctor id: "<<doctor_id<<endl;
		cout<<"doctor name: "<<doctor_name<<endl;
	}
	
};

int main()
{
	hospital_mgmt ob[20];
	fstream file;
	int op1,op2;
	char z;
	char drs[]="Dr_Sharma";
	char dis[]="Asthama";
	char dis2[]="Cardiac_arrest";
	char dis3[]="Atheroclerosis";
	int a;
	
	
	cout<<"HOSPITAL MANAGEMENT SYSTEM";
	cout<<"\n please select one of the following option:"<<endl;
	cout<<"1. enter new data\n 2. use old data 3. exit";
	cin>>op1;
	
	switch(op1)
	{
		case 1: {	
					//store in file(patient)
					file.open("patient.txt",ios::out);
					if(!file)
					{
						cout<<"error in creating file.."<<endl;
						return 0;
					}
					cout<<"\nfile created successfully."<<endl;
					for(int i=0;i<20;i++)
					{
						cout<<"enter patient id: ";
						cin>>ob[i].patient_id;
						file<<ob[i].patient_id;
						cout<<"enter patient name: ";
						cin>>ob[i].patient_name;
						file<<ob[i].patient_name;
						cout<<"enter ward no.: ";
						cin>>ob[i].ward_no;
						file<<ob[i].ward_no;
						cout<<"enter date of arrival(dd/mm/yyyy): ";
						cin>>ob[i].date_of_arrival;
						file<<ob[i].date_of_arrival;
						cout<<"enter disease found: ";
						cin>>ob[i].disease_found;
						file<<ob[i].disease_found;
						cout<<"enter type of ward(neuro(1)/respiratory(2)/cardio(3)): ";
						cin>>ob[i].type_of_ward;
						file<<ob[i].type_of_ward;
						cout<<"enter treatment type (severe=1/general=0): ";
						cin>>ob[i].treatment_type;
						file<<ob[i].treatment_type;
						cout<<"enter name of doctor treating the patient: ";
						cin>>ob[i].treated_by_doctor;
						file<<ob[i].treated_by_doctor;
					}
					file.close();
					cout<<"\nFile saved and closed succesfully."<<endl;
					
					
					
					//store in file(doctor)
					file.open("doctor.txt",ios::out);
					if(!file)
					{
						cout<<"error in creating file.."<<endl;
						return 0;
					}
					cout<<"\nfile created successfully."<<endl;
					for(int i=0;i<8;i++)
					{
						cout<<"enter doctor id: ";
						cin>>ob[i].doctor_id;
						file<<ob[i].doctor_id;
						cout<<"enter doctor name: ";
						cin>>ob[i].doctor_name;
						file<<ob[i].doctor_name;
					}
					file.close();
					cout<<"\nFile saved and closed succesfully."<<endl;
				}
					
				
		case 2:		{
						//read from file(patient)
						file.open("patient.txt",ios::in);
						if(!file)
						{
							cout<<"error in opening file..";
							return 0;
						}
						for(int i=0;i<20;i++)
						{
							file>>ob[i].patient_id;
							file>>ob[i].patient_name;
							file>>ob[i].ward_no;
							file>>ob[i].date_of_arrival;
							file>>ob[i].disease_found;
							file>>ob[i].type_of_ward;
							file>>ob[i].treatment_type;
							file>>ob[i].treated_by_doctor;
						}
						file.close();
						
						//read from file(doctor)
						file.open("doctor.txt",ios::in);
						if(!file)
						{
							cout<<"error in opening file..";
							return 0;
						}
						for(int i=0;i<8;i++)
						{
							file>>ob[i].doctor_id;
							file>>ob[i].doctor_name;
						}
						file.close();
						cout<<"abc";
						
					break;
				}
			case 3: return 0;
				break;
		default: cout<<"wrong input...";
				//return 0;
	}
	
	do 
	{

		cout<<"slect the member to display contents";
		cout<<"1. member 1 \n2. member 2\n3. member 3";
		cin>>op2;
		
		switch(op2)
		{
			case 1: {
						//___________member 1___________
						
						cout<<"PATIENTS TREATED BY DR. SHARMA"<<endl<<endl;
						for(int i=0;i<20;i++)
						{
							a=strcmp(drs,ob[i].treated_by_doctor);
							if(a==0)
								{
									ob[i].display_patient();
									cout<<endl;
								}
						}
						cout<<"PATIENTS UNDERGOING TREATMENT FOR ASTHAMA"<<endl<<endl;
						for(int i=0;i<20;i++)
						{
							a=strcmp(dis,ob[i].disease_found);
							if(a==0)
								{
									ob[i].display_patient();
									cout<<endl;
								}
						}
						cout<<"DOCTORS TREATING SEVERE PATIENTS"<<endl<<endl;
						for(int i=0;i<20;i++)
						{
							if(ob[i].treatment_type==1)
								{
									for(int j=0;j<8;j++)
									{
										a=strcmp(ob[i].treated_by_doctor,ob[j].doctor_name);
										if(a==0)
											{
												ob[j].display_doctor();
												cout<<endl;
											}
									}
								}
						}
						break;
					}
		case 2:	{
			
				//__________________member 2____________________
				string name[20];
				int no[20];
				string doc[20];
				string dum;
				int dum2;
				
				//task 4
			/*	cout<<"PATIENTS NAMES WITH DOCTORS TREATING THEM IN ASCENDING ORDER(OF ID): ";
				for(int i=0;i<20;i++)
				{
					name[i]=ob[i].patient_name;
					no[i]=ob[i].patient_id;
					doc[i]=ob[i].doctor_name;
				}
				for(int i=0;i<20;i++)
				{
					if(no[i]>no[i+1])
					{
						dum2=no[i];
						no[i]=no[i+1];
						no[i+1]=dum2;
						dum=name[i];
						name[i]=name[i+1];
						name[i+1]=dum;
						dum=doc[i];
						doc[i]=doc[i+1];
						doc[i+1]=dum;
					}
				}
				for(int i=0; i<20;i++)
				{
					cout<<"\npatient id: "<<no[i];
					cout<<"\npatient name: "<<name[i];
					cout<<"\ntreated by doctor: "<<doc[i];
				} */
				
				//task 5
				
				cout<<"\nDISPLAY OF ALL PATIENTS ACCORDING TO WARD TYPE";
				cout<<"\nNeurology";
				for(int i=0; i<20; i++)
				{
					if(ob[i].type_of_ward==1)
					{
						ob[i].display_patient();
					}
				}
				cout<<"\nRespiratory";
				for(int i=0; i<20; i++)
				{
					if(ob[i].type_of_ward==2)
					{
						ob[i].display_patient();
					}
				}
				cout<<"\nCardiology";
				for(int i=0; i<20; i++)
				{
					if(ob[i].type_of_ward==3)
					{
						ob[i].display_patient();
					}
				}
				
				//task 6
				
						cout<<"PATIENTS NAME ACCORDING TO DISEASE FOUND"<<endl<<endl;
						cout<<"Asthama";
						for(int i=0;i<20;i++)
						{
							a=strcmp(dis,ob[i].disease_found);
							if(a==0)
								{
									ob[i].display_patient();
									cout<<endl;
								}
						}
						cout<<"\nCardiac arrest";
						for(int i=0;i<20;i++)
						{
							a=strcmp(dis2,ob[i].disease_found);
							if(a==0)
								{
									ob[i].display_patient();
									cout<<endl;
								}
						}
						cout<<"\nAtheroclerosis";
						for(int i=0;i<20;i++)
						{
							a=strcmp(dis3,ob[i].disease_found);
							if(a==0)
								{
									ob[i].display_patient();
									cout<<endl;
								}
						}
			break;	
		}
			
				case 3: {
		
				//task 7
				cout<<"/nDOCTOR NAMES ALONG WITH TREATEMENT TYPE";
				for(int i=0; i<20; i++)
					{
						cout<<"\ndoctor name: "<<ob[i].treated_by_doctor;
						cout<<"\ntreatement type: ";
						if(ob[i].treatment_type==1)
							cout<<"severe"<<endl;
						else
							cout<<"general"<<endl;
					}
					
				//task 8
				cout<<"PATIENTS -WARD NO, DOCTOR, DATE OF ARRIVAL"<<endl<<endl;
				for(int i=0;i<20;i++)
				{
					cout<<"patient name: "<<ob[i].patient_name<<endl;
					cout<<"ward no: "<<ob[i].ward_no<<endl;
					cout<<"doctor: "<<ob[i].treated_by_doctor<<endl;
					cout<<"date of arrival: "<<ob[i].date_of_arrival<<endl;
				}
		break;
	}		
	}//swich 2 end
	

cout<<"\n\n\n\n\ncontinue?(y/n)";
cin>>z;
}while(z=='y'||z=='Y');//while loop end
}//main end
