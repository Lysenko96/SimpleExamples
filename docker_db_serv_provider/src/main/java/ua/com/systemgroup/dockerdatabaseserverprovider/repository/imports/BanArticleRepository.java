package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.BanArticle;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.BanArticlePk;

@Repository
public interface BanArticleRepository extends JpaRepository<BanArticle, BanArticlePk> {
}
