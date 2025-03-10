package ua.com.systemgroup.dockerdatabaseserverprovider.repository.imports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.Barcode;
import ua.com.systemgroup.dockerdatabaseserverprovider.model.imports.pkey.BarcodePk;

@Repository
public interface BarcodeRepository extends JpaRepository<Barcode, BarcodePk> {
}
