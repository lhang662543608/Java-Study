package datastructure.recursion;

/**
 * @author lhang
 * @create 2020-05-10 17:02
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //先把上下置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图的情况：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay2(map, 1, 1);

        //输出新的地图，小球走过，并标识过的
        System.out.println("新的地图：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * 使用递归回溯给小球找路
     * 1.map表示地图
     * 2.i，j表示从地图那个位置开始出发(1,1)
     * 3.如果小球能到达map[6][5]位置，则说明能找到。
     * 4.约定：当map[i][j]为0表示该点没有走过 ，当为1表示为墙  当为2表示通路 当为3表示该位置走过，走不通
     * 5.走迷宫时，需要确定一个策略  下->右->上->左
     *
     * @param map 表示地图
     * @param i   起始位置的
     * @param j
     * @return 找到通路就返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个点还没有走过
                //按照策略  下->右->上->左
                map[i][j] = 2;//假定可以走通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    map[i][j] = 3;//说明该点是死路，走不通
                    return false;
                }
            } else {//如果map[i][j]!=0,可能是1,2,3
                return false;
            }
        }
    }


    /**
     * 使用递归回溯给小球找路
     * 1.map表示地图
     * 2.i，j表示从地图那个位置开始出发(1,1)
     * 3.如果小球能到达map[6][5]位置，则说明能找到。
     * 4.约定：当map[i][j]为0表示该点没有走过 ，当为1表示为墙  当为2表示通路 当为3表示该位置走过，走不通
     * 5.走迷宫时，需要确定一个策略  下->右->上->左
     *
     * @param map 表示地图
     * @param i   起始位置的
     * @param j
     * @return 找到通路就返回true，否则返回false
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个点还没有走过
                //按照策略  上->右->下->左
                map[i][j] = 2;//假定可以走通
                if (setWay2(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    map[i][j] = 3;//说明该点是死路，走不通
                    return false;
                }
            } else {//如果map[i][j]!=0,可能是1,2,3
                return false;
            }
        }
    }
}
