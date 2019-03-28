package im.heart.cms.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import im.heart.cms.entity.Article;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gg
 * @desc 文章接口
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, BigInteger>, JpaSpecificationExecutor<Article> {
    /**
     * 更新点击次数
     * @param id
     */
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query("update Article model set hits=hits+1 WHERE model.id = :id")
    public void updateHitsById(@Param("id") BigInteger id);
}
