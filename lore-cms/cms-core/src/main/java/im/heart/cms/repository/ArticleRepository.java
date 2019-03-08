package im.heart.cms.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import im.heart.cms.entity.Article;

/**
 * 
 * @功能说明：文章接口
 * @作者 gg
 */
public interface ArticleRepository extends JpaRepository<Article, BigInteger>, JpaSpecificationExecutor<Article> {
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query("update Article model set hits=hits+1 WHERE model.id = :id")
    public void updateHitsById(@Param("id") BigInteger id);
}
