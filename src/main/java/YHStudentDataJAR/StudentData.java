package YHStudentDataJAR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.joda.time.LocalDate;

import YHStudentData.CourseProgramme;
import YHStudentData.Module;
import YHStudentData.Student;

public class StudentData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap <String, List<Module>> ListOfModule;
		List<CourseProgramme> courseProgs = new ArrayList<CourseProgramme>(); 
		ArrayList<Student> studentsList = new ArrayList<Student>();
		
		LocalDate s1DOB = new LocalDate (1997,6,17);
		LocalDate s2DOB =  new LocalDate(1998,2,07);
		LocalDate s3DOB =  new LocalDate(1996,5,12);
		LocalDate s4DOB = new LocalDate (1993,8,10);

		Student s1 = new Student ("Paul", "Shane", s1DOB, 12100950);		
		Student s2 = new Student("Daniel", "Adam", s2DOB, 13100920 );		
		Student s3 = new Student("Adriaan", "Gabi",s3DOB, 111000950);		
		Student s4 = new Student ("Mary", "McDonal", s4DOB, 13100100);

		studentsList.add(s1);studentsList.add(s2);
		studentsList.add(s3);studentsList.add(s4);

		Module m1 = new Module("Software Engineering", "CA445");
		Module m2 = new Module("Data Mining", "CA455");
		Module m3 = new Module("Signal Processing", "EE435");
		Module m4 = new Module("Humanities Application", "CT327");
		Module m5 = new Module("Digital System", "EE425");
		Module m6 = new Module("Telecommunication", "EE475");
		
		List<Student> m1_students = new ArrayList<Student>();
		List<Student> m2_students = new ArrayList<Student>();
		List<Student> m3_students = new ArrayList<Student>();
		List<Student> m4_students = new ArrayList<Student>();
		List<Student> m5_students = new ArrayList<Student>();
		List<Student> m6_students = new ArrayList<Student>();
		
		
		m1_students.add(s1);m1_students.add(s2);
		m2_students.add(s3);m2_students.add(s4);
		m4_students.add(s1);m4_students.add(s2);
		m3_students.add(s3);m3_students.add(s4);
		m5_students.add(s3);m5_students.add(s2);
		m6_students.add(s4);m6_students.add(s1);
		
	
        	
		m1.addStudents("Module1", m1_students);m2.addStudents("Module2",m2_students);
		m3.addStudents("Module3", m3_students);m4.addStudents("Module1",m4_students);
		m5.addStudents("Module1",m5_students); m6.addStudents("Module1",m6_students);
		
		LocalDate startDate = new LocalDate(2017,9,04); LocalDate endDate = new LocalDate(2021, 5,15);
		CourseProgramme c1 = new CourseProgramme("Science",startDate,endDate);
		CourseProgramme c2 = new CourseProgramme ("Electronics", startDate, endDate); 

		List<Module> c1Modules = new ArrayList<Module>();
		List<Module> c2Modules = new ArrayList<Module>();
		
		c1Modules.add(m1);c1Modules.add(m4);
		c2Modules.add(m2);c2Modules.add(m3);
		c2Modules.add(m5);
		
		c1.addModule("CPrograme1", c1Modules);c2.addModule("CPrograme2", c2Modules);

		courseProgs.add(c1);courseProgs.add(c2);
		
		System.out.printf("%s",String.format("User Name \t\t Student Name \t\t\t Modules \t\t\t\t Course \n\n"));
		
		
		for (Student student : studentsList) {
			boolean coursePrint = true;
			boolean studentPrint = true;
			for (CourseProgramme course: courseProgs) {
				ListOfModule = course.getListOfModule();
				for (List<Module> modules: ListOfModule.values()) {
					for (Module module: modules) {
						HashMap<String, List<Student>> students = module.getListOfStudents();
						for (List<Student> stdList:students.values()) {
							for(Student std: stdList) {
								if (std.getSName().equals(student.getSName())){
									if (studentPrint) {
										System.out.printf("%s",String.format("%0$-25s%0$-35s",student.getUsername() ,student.getFName() + " " + student.getSName()));
										
										studentPrint = false;
									}
									else {System.out.printf("%s",String.format("%0$-50s",' '));
									}
									System.out.printf("%s",String.format("%0$-35s",module.getModuleName()));
									if (coursePrint) {
										System.out.printf("%s",String.format("%0$-40s",course.getCourseName()));
										coursePrint = false;
									}
								}
							}
							System.out.println();
						}
					}
				}
			}
		}
	}

}
