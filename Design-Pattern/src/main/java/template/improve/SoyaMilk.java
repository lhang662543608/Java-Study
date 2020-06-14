package template.improve;

/**
 * @author lhang
 * @create 2020-06-14 15:20
 */
public abstract class SoyaMilk {
    /**
     * 制作豆浆，
     * 模板方法，make。模板方法可以做成final，不让子类去覆盖
     */
    final void make(){
     select();
     if (customWantAdd()) {
        add();
     }
     soak();
     beat();
    }

    /**
     * 第一步：筛选大豆
     */
    void select(){
        System.out.println("第一步：筛选新鲜的大豆");
    }

    /**
     * 第二步，添加配料
     */
    abstract void add();

    /**
     * 第三步：浸泡
     */
     void soak(){
         System.out.println("第三步：黄豆和配料开始浸泡，需要3个小时");
    }

    /**
     * 第四部：打磨豆浆
     */
    void beat(){
        System.out.println("第四步：黄豆和配料，放到豆浆机中去打碎。");
    }

    //钩子方法，是否添加配料
    boolean customWantAdd(){
        return true;
    }
}
