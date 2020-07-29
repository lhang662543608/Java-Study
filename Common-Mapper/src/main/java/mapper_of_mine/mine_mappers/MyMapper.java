package mapper_of_mine.mine_mappers;

import tk.mybatis.mapper.common.base.select.SelectAllMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;

/**
 * @author lhang
 * @create 2020-07-28 18:41
 */
public interface MyMapper<T>
    extends SelectAllMapper<T>,SelectByExampleMapper<T> {

}
