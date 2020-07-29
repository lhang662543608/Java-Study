package mapper_extends.mine_mappers;

import tk.mybatis.mapper.common.base.select.SelectAllMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;

/**
 * @author lhang
 * @create 2020-07-28 19:25
 */
public interface MyMapper<T>
        extends SelectByExampleMapper<T>, SelectAllMapper<T>, MyBatchUpdateMapper<T> {
}
