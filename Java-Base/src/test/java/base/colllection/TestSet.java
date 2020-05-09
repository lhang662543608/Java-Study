package base.colllection;


import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestSet {

    @Test
    public void testHashSet() {
        //HashSet的操作
        //生成HashSet的实例对象
        HashSet<String> hashSet = new HashSet<String>();

        //HashSet的增加
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("4");
        hashSet.add("5");

        //HashSet的删除
        hashSet.remove("2");

        //HashSet的修改
        //因为HashSet的元素不存在通过下标去访问，所以修改操作是没有的

        //HashSet的查询
        //foreach语句方式
        for (String str : hashSet) {
            if (str.equals("a")) {
                System.out.println("该集合中存在a元素");
            }
        }

        //迭代器方式：
        Iterator<String> intertor1 = hashSet.iterator();
        while (intertor1.hasNext()) {
            if (intertor1.next().equals("a")) {
                System.out.println("该集合当中存在a元素");
            }
        }
    }

    @Test
    public void testTreeSet(){
        TreeSet<Student> treeSet = new TreeSet<Student>();
        treeSet.add(new Student("a", 1));
        treeSet.add(new Student("b", 2));
        treeSet.add(new Student("c", 3));
        treeSet.add(new Student("d", 5));
        treeSet.add(new Student("e", 3));
        treeSet.add(new Student("f", 7));

        //放入相同的
        treeSet.add(new Student("d", 5));
        treeSet.add(new Student("e", 3));
        treeSet.add(new Student("b", 2));

        for(Student student:treeSet){
            student.allMessage();
        }

    }



    @Test
    public void TestLinkedHashSet(){
        LinkedHashSet linkedHashSet = new LinkedHashSet();
    }

}
class Student implements Comparable<Student> {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void allMessage() {
        System.out.println("学生名字：" + name + ",学生年龄：" + age);
    }

    @Override
    public int compareTo(Student o) {

        //排序规则：按照年龄进行排序
        return age - o.age != 0 ? age - o.age : (name.equals(o.name) ? 0 : 1);
    }
}


