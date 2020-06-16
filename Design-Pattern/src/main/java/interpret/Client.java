package interpret;

/**
 * 使用解释器模式设计一个简单的解释器，使得系统可以解释0和1的或运算和与运算（不考虑或运算和与运算的优先级），
 * 语句表达式和输出结果的几个实例如表所示：
 * 表18.1   表达式及输出结果部分实例表
 * 表达式                 输出结果                表达式                     输出结果
 * 1 and 0                 0                     1 and 1 or 0              1
 * 1 and 1                 1                     0 or 1 and 0              0
 * 0 and 0                 0                     0 or 1 and 1 or 1         1
 * 1 or 1                  1                     1 or 0 and 1 and 0 or 0   0
 * 1 or 0                  1
 * 0 or 0                  0
 */
public class Client {
    public static void main(String[] args) {
        String statement = "0 or 1 and 1 or 1";
        Context ctx = new Context();
        ctx.parse(statement);
        int result = ctx.execute();
        System.out.println(statement + "  " + result);
    }
}
