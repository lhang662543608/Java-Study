package base.colllection;

import org.junit.Test;

import java.util.*;

public class TestList {
    /**
     * ArrayList学习
     */
    @Test
    public void testArrayList() {
        //生成arrayList实例对象
        ArrayList<String> arrayList = new ArrayList<String>(0);
        System.out.println(arrayList.size());

        //ArrayList的添加：
        arrayList.add("A"); //在末尾添加元素
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add(2, "F");//在指定位置插入元素

        //ArrayList的删除
        arrayList.remove(2);//移除下标为2的元素

        //ArrayList的修改
        arrayList.set(0, "a");//把下标为1的元素修改为元素"a"

        //ArrayList的查询，这里需要遍历ArrayList
        //普通for语句遍历
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals("a")) {
                System.out.println("该集合当中存在a元素，并且位置在第" + (i + 1));
            }
        }

        //foreach语句遍历
        for (String str : arrayList) {
            if (str.equals("a")) {
                System.out.println("该集合当中存在a元素");//输出其位置就要另外添加变量了
            }
        }

        //迭代器方式：
        Iterator<String> intertor = arrayList.iterator();
        while (intertor.hasNext()) {
            if (intertor.next().equals("a")) {
                System.out.println("该集合当中存在a元素");
            }
        }


    }

    /**
     * LinkedList分析：
     */
    @Test
    public void testLinkedList() {
        //生成arrayList实例对象
        LinkedList<String> linkedList = new LinkedList<String>();
        System.out.println(linkedList.size());

        //ArrayList的添加：
        linkedList.add("A"); //在末尾添加元素
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add(null);
        linkedList.add(2, "F");//在指定位置插入元素

        //ArrayList的删除
        linkedList.remove(2);//移除下标为2的元素


        //ArrayList的修改
        linkedList.set(0, "a");//把下标为1的元素修改为元素"a"

        //ArrayList的查询，这里需要遍历ArrayList
        //普通for语句遍历
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i).equals("a")) {
                System.out.println("该集合当中存在a元素，并且位置在第" + (i + 1));
            }
        }

        //foreach语句遍历
        for (String str : linkedList) {
            if (str.equals("a")) {
                System.out.println("该集合当中存在a元素");//输出其位置就要另外添加变量了
            }
        }

        //迭代器方式：
        Iterator<String> intertor = linkedList.iterator();
        while (intertor.hasNext()) {
            if (intertor.next().equals("a")) {
                System.out.println("该集合当中存在a元素");
            }
        }


    }

    /**
     * Vector分析
     */
    @Test
    public void testVector() {
        Vector vector = new Vector();
    }

    /**
     * List笔试题
     */
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);//删除索引位置为2的元素
        list.remove(new Integer(2));//删除元素2
        System.out.println(list);
    }
}
