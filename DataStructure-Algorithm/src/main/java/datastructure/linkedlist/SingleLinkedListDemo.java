package datastructure.linkedlist;

import java.util.Stack;

/**
 * @author lhang
 * @create 2020-05-08 17:11
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        //创建链表
        SingleLinkedList linkedList = new SingleLinkedList();
        //加入链表
        linkedList.add(heroNode1);
        linkedList.add(heroNode4);
        linkedList.add(heroNode2);
        linkedList.add(heroNode3);
        //  加入按照编号的顺序
//        linkedList.addByOrder(heroNode1);
//        linkedList.addByOrder(heroNode4);
//        linkedList.addByOrder(heroNode2);
//        linkedList.addByOrder(heroNode3);

        //测试一下：单链表的翻转
        System.out.println("原来单链表的情况~~");
        linkedList.list();


//        System.out.println("翻转单链表~~");
//        reverseList(linkedList.getHead());
//        linkedList.list();

        System.out.println("翻转单链表~~");
        reversePrint(linkedList.getHead());

/*
        //显示链表
        linkedList.list();

        //测试修改节点的到吗
        HeroNode newHeroNode = new HeroNode(2, "张无忌", "乾坤丹挪移");
        linkedList.update(newHeroNode);

        System.out.println("修改后的链表情况~~");
        linkedList.list();

        //测试删除一个节点
        linkedList.del(1);
        linkedList.del(4);

        System.out.println("删除后的链表情况~~");
        linkedList.list();

        //测试一下：单链表的节点的个数getLength()
        int length = getLength(linkedList.getHead());
        System.out.println("length = " + length);

        //测试一下：查找单链表的倒数第K个节点
        HeroNode node = findLastIndexNode(linkedList.getHead(), 1);
        System.out.println("node = " + node);*/

    }

    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;//空链表不能打印
        }
        //创建一个栈，将各个节点压入站
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //将栈中的数据进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 将单链表进行翻转
     *
     * @param head
     */
    public static void reverseList(HeroNode head) {
        //如果当前链表为空或者链表只有一个节点，则不需要翻转
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点【cur】的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            next = cur.next;//先保存当前节点的下一个节点，因为 后面要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表的翻转
        head.next = reverseHead.next;


    }

    /**
     * 方法：查找单链表的倒数第K个节点【新浪】
     * 1.编写一个方法接收head节点，同时接收一个index
     * 2.index表示是倒数第index个节点
     * 3.先把链表从头到尾遍历一遍，得到链表的长度size
     * 4.我们从链表的第一个遍历size-index就可以得到
     * 5.如果找到了就返回该节点，否则返回空
     *
     * @param head
     * @param index
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，则返回null
        if (head.next == null) {
            return null;
        }
        //获取链表的长度
        int size = getLength(head);
        //进行index校验
        if (index < 0 || index > size) {
            return null;
        }
        //定义辅助变量，for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    /**
     * 方法：获取单链表的节点的个数（如果是带头结点链表，需要不统计头结点）
     *
     * @param head
     * @return
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode cur = head.next;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}

//定义SingleLinkedList 管理我们的英雄
class SingleLinkedList {
    //初始化一个头结点,头结点不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单项列表
     * 思路：当不考虑编号顺序时：
     * 1.找到当前链表的最后节点
     * 2.将最后节点的next指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode tmp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (tmp.next == null) {
                break;
            }
            //没有找到就将temp后移
            tmp = tmp.next;
        }
        //退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        tmp.next = heroNode;
    }

    /**
     * 按照编号顺序添加：
     * 1.首先找到新添加的节点的位置，通过辅助变量。通过遍历实现
     * 2.新的节点.next=temp.next
     * 3.temp.next = 新的节点
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们任然通过一个辅助指针来帮助我们找到添加的位置
        //因为单链表，因为我们找到的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode tmp = head;
        boolean flag = false;//flag 表示添加的编号是否存在，默认为false
        while (true) {
            if (tmp.next == null) {//说明已经在链表的最后
                break;
            }
            if (tmp.next.no > heroNode.no) {//位置找到了，就在temp的后面插入
                break;
            } else if (tmp.next.no == heroNode.no) {//说明希望添加的heroNode的编号依然存在
                flag = true;//编号已经存在
                break;
            }
            tmp = tmp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {//不能添加，说明编号已经存在
            System.out.printf("准备插入的英雄的编号%d已经存在了，不能添加\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = tmp.next;
            tmp.next = heroNode;
        }
    }

    /**
     * 修改节点的信息，根据no编号来修改，即no编号不能改
     * 说明：
     * 1.根据newHeroNode的no来修改即可
     *
     * @param heroNode
     */
    public void update(HeroNode heroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode tmp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (tmp == null) {
                break;//已经遍历完链表
            }
            if (tmp.no == heroNode.no) {
                //找到
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            tmp.name = heroNode.name;
            tmp.nickName = heroNode.nickName;
        } else {
            //没有找到
            System.out.printf("没有找到编号为%d的节点，不能修改\n", heroNode.no);
        }
    }

    /**
     * 删除节点：
     * 思路：
     * 1.head不能动，因此我们需要一个temp辅助接点找到到删除节点的前一个节点
     * 2。说明我们在比较时，是temp.next.no和需要删除的节点的no比较
     *
     * @param no
     */
    public void del(int no) {
        HeroNode tmp = head;
        boolean flag = false; //表示是否找到待删除节点的前一个节点
        while (true) {
            if (tmp.next == null) {//到达链表的最后
                break;
            }
            if (tmp.next.no == no) {
                //找到了待删除节点 的前一个节点
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            //可以删除
            tmp.next = tmp.next.next;
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }

    /**
     * 显示链表[遍历]
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        //定义临时变量
        HeroNode tmp = head.next;
        while (true) {
            //判断链表是否到最后
            if (tmp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(tmp);
            //将tmp节点后移
            tmp = tmp.next;
        }
    }

}


//定义一个HeronNode,每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
