package org.example.webservice;

import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "org.example.webservice.SimpleWebService")
public class SimpleWebServiceImpl implements SimpleWebService {

    private List<String> jobs = new ArrayList<>(); {{
        jobs.add("hr");
        jobs.add("programmer");
        jobs.add("manager");
    }};

    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public String checkJob(String jobName) {
        return "Check Job: " + jobName + (jobs.contains(jobName.toLowerCase()) ? " exists" : " does not exist");
    }
}
