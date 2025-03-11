package ex0311.stream.ex03;

import java.util.Arrays;
import java.util.List;

import ex0311.stream.Student;

public class MatchHistroryExam02 {

	public static void main (String args[]) {
		List<Student>list = Arrays.asList(
				(new Student("그뭐냐", 22, 60, "컴퓨터"), new Student("그뭐냐", 22, 80, "영어"),
						new Student("뭐냐", 22, 70, "컴퓨터"), new Student("뭐더라", 22, 50, "수학"), new Student("그뭐냐", 22, 80, "컴퓨터"),
						new Student("뭐시기냐", 22, 70, "과학"));
	
				//allMatch
				boolean re=list.stream().allMatch((s)->sl.getScopre()>=80);
				
				
				//anymatch
				boolean re=list.stream().allMatch((s)->sl.getScopre()>=80);
				
				//noneMatch
				list.stream().allMatch((s)->sl.getScopre()>=80);
				
				
				//max()-가장많은나이
				 re=list.stream().allMatch((s)->sl.getScopre()>=80);
				
				
				 
				 Arrays.stream(new int 	[] {1,3,5,6,7,8});
				 
				 
				  
				 
				
				
			)

}
