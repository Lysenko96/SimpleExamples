package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.ArticlesGroup;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.ArticlesGroupPk;

@Repository
public interface ArticlesGroupRepository extends JpaRepository<ArticlesGroup, ArticlesGroupPk> {
}
