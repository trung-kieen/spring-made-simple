package com.trung_kieen.bean_play_around;


public class Student {
  public Student(){
    System.out.println("Student creation");
  }
  public void init(){
    System.out.println("Object init method called");
  }

  public void destroy(){
    System.out.println("Object destroy method called");
  }

}
