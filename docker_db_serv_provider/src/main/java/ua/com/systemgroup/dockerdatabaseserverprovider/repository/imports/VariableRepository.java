package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Variable;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.VariablePk;

@Repository
public interface VariableRepository extends JpaRepository<Variable, VariablePk> {
}
