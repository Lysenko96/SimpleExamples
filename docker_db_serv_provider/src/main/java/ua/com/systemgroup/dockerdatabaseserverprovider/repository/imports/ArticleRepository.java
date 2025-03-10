package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Article;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ArticlePk;

@Repository
public interface ArticleRepository extends JpaRepository<Article, ArticlePk> {
}
