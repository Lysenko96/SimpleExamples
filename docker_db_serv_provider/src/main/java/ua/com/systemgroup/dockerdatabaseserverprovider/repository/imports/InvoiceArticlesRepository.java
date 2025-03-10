package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.InvoiceArticles;

@Repository
public interface InvoiceArticlesRepository extends JpaRepository<InvoiceArticles, Short> {
}
