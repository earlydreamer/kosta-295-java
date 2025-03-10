package ex0310.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Test00 {

    public static void main(String[] args) { 
        List<Student> students = Arrays.asList( 
            new Student("희정", 22, 88.5, "Computer Science"), 
            new Student("찬범", 24, 76.2, "Mathematics"), 
            new Student("가현", 23, 92.3, "Computer Science"), 
            new Student("현솔", 25, 81.7, "Physics"), 
            new Student("현준", 21, 85.4, "Mathematics") 
        ); 
    
        //기존방식
        List<Student> scoreList = new ArrayList<Student>();
        for(Student st:students) {
        	if(st.getScore()>=80) {
        		scoreList.add(st);
        	}
        }
        
        Collections.sort(scoreList,(o1,o2)->{
        	double res = o1.getScore()-o2.getScore();
        	
        	if(res==0.0) return 0;
        	else if (res>0.0) return 1;
        	else return -1;
        });
        List<String> nameList = new ArrayList<>();
        for(Student st:scoreList) {
        	nameList.add(st.getName());
        }
     System.out.println(nameList);   
    
     //------- Stream 사용 -----------
     //filter의 매개변수인 Interface Predicate<T> 는 람다식으로 사용 시 조건에 맞는지 검사해서 boolean형을 리턴한다.
     //
     List<String> resultName = students.stream().filter(s->s.getScore()>=80)
     .sorted(Comparator.comparingDouble(Student::getScore))
     .map(s->s.getName())
     .toList();
    
     resultName.forEach((name)->System.out.println(name)); //람다를 이용한
     resultName.forEach(System.out::println); //메소드 참조를 이용한
     
     
     
     
    }
    
    
    
    


}
