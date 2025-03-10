package ua.com.systemgroup.dockerdatabaseserverprovider.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;

import static ua.com.systemgroup.dockerdatabaseserverprovider.util.ParseUtil.CSV_EXTENSION;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GenericFilter implements FilenameFilter {

    private String filename;

    @Override
    public boolean accept(File file, String s) {
        return s.equalsIgnoreCase(filename + CSV_EXTENSION);
    }
}
