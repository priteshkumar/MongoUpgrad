package entity;

import java.util.Random;
import org.bson.Document;

public class Student {

  private int _id;
  private String name;
  private int courseId;
  private int age;

  public int get_id() {
    return _id;
  }

  public void set_id(int _id) {
    this._id = _id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Student(int id, String name, int courseId, int age) {
    this._id = id;
    this.name = name;
    this.courseId = courseId;
    this.age = age;
  }

  public Document createDBObject() {
    Random seed = new Random();
    Document student = new Document();
    student.append("_id", (int)(seed.nextDouble() * 100));
    student.append("name",this.getName());
    student.append("courseId", this.getCourseId());
    student.append("age", this.getAge());
    return student;
  }
}
