package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Measure;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.MeasurePk;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, MeasurePk> {
}
