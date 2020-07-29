package mapper_extends.mine_mappers;

import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author lhang
 * @create 2020-07-28 19:27
 */
public interface MyBatchUpdateMapper<T> {
    @UpdateProvider(type = MyBatchUpdateProvider.class,method = "dynamicSQL")
    void batchUpdate(List<T> list);
}
