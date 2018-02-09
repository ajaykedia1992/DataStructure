import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student{
	int rollNo;
	String name;
	public Student(int rollNo, String name){
		this.rollNo = rollNo;
		this.name = name;
	}
}

class SortByName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.name.compareTo(o2.name);
	}
	
}

class SortByRoll implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.rollNo - o2.rollNo;
	}
	
}

public class ComparatorSample {
	
	public static void main(String[] args) {
		List<Student> arrayList = new ArrayList<Student>();
		Student s1 = new Student(104,"Ranvijay");
		Student s2 = new Student(103,"Ajay");
		arrayList.add(s1);
		arrayList.add(s2);
		Collections.sort(arrayList, new SortByName());
		for(Student s : arrayList) {
			System.out.println(s.rollNo + " " + s.name);
		}
		
		Collections.sort(arrayList, new SortByRoll());
		for(Student s : arrayList) {
			System.out.println(s.rollNo + " " + s.name);
		}
	}
	
}
