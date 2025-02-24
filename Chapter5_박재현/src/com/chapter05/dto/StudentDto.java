/*
 * 패키지명은 클래스명과 식별을 쉽게 하기 위해 기본적으로 모두 소문자로 시작한다. camelCase 여부는 구분하지 않으나 가능한 한 단어로 구성한다.
 */

package com.chapter05.dto;

/**
 * 학생 성적 정보를 저장하는 객체<br>
 * 작성자 박재현
 * 2025-02-23
 */
public class StudentDto {
	
	private int studentNumber;
	private String studentName;
	private double korScore;
	private double matScore;
	private double engScore;
	private double totalScore;
	private double avgScore;
	private Grade grade;

	/**
	 * 성적 등급 <br>
	 * E등급은 없다
	 */
	public enum Grade{
		A,
		B,
		C,
		D,
		F;

	}
	
	/**
	 * 디폴트 생성자
	 */
	public StudentDto(){
		
	}
	
	

	/*
	 * --Getter--
	 */
	
	public int getStudentNumber() {
		return this.studentNumber;
	}
	
	public String getStudentName() {
		return this.studentName;
	}
	
	public double getKorScore() {
		return this.korScore;
	}
	
	public double getMatScore() {
		return this.matScore;
	}
	
	public double getEngScore() {
		return this.engScore;
	}
	
	public double getTotalScore() {
		return this.totalScore;
	}
	
	public double getAvgScore() {
		return this.avgScore;
	}
	
	public Grade getGrade() {
		return this.grade;
	}
	
	
	/*
	 * --Setter--
	 */

	
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void setKorScore(double korScore) {
		this.korScore = korScore;
	}
	
	public void setMatScore(double matScore) {
		this.matScore = matScore;
	}
	
	public void setEngScore(double engScore) {
		this.engScore = engScore;
	}
	
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	
	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;		
	}

	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
}



