/*
@author 
@Date   2025/3/23 11:11
@description
*/
public class student
{
    public String name;
    public int age;
    public String gender;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}
