package com.hackbulgaria.corejava;

public class Student implements Comparable<Student> {

	public String name;
	public int grade;
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.grade>o.grade) {
			return 1;
		}
		else if(this.grade<o.grade) {
			return -1;
		}
		else if(this.grade == o.grade) {
			if(this.name.compareTo(o.name)>0){
				return 1;
			}
			else if(this.name.compareTo(o.name)<0) {
				return -1;
			}
		}
		return 0;
	}

}
