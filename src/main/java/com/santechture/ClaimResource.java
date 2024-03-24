package com.santechture;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieRuntimeBuilder;


import java.util.ArrayList;
import java.util.List;

@Path("/v1")
public class ClaimResource {
    @Inject
    KieRuntimeBuilder kieRuntimeBuilder;
    @Getter
    @Setter
    private List<Group> groups;
    @Getter
    @Setter
    private List<GroupRange> groupsRanges;
    @Getter
    @Setter
    private List<GroupChildren> groupsChildren;
    @Getter
    @Setter
    private KieSession session;

    @PostConstruct
    public void init() {
        groups = Group.findAll().list();
        groupsRanges = groups.stream()
                .flatMap(group -> group.getRanges().stream())
                .toList();
        groupsChildren = groups.stream()
                .flatMap(group -> group.getChildren().stream())
                .toList();

        System.out.println(groups.size());
        System.out.println(groupsRanges.size());
        System.out.println(groupsChildren.size());

    }

    @POST()
    @Path("validate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Alert> validateClaim(ValidateRequest request) {
        session = kieRuntimeBuilder.newKieSession();

        session.getObjects().forEach(o -> System.out.println(o.getClass()));

        groups.forEach(session::insert);
        groupsRanges.forEach(session::insert);
        groupsChildren.forEach(session::insert);

        List<Alert> alerts = new ArrayList<>();

        session.setGlobal("alerts", alerts);
        if (request.getHeader() != null){
            session.insert(request.getHeader());
        }
        if (request.getClaim() != null){
            session.insert(request.getClaim());
            if (request.getClaim().getActivity() != null){
                request.getClaim().getActivity().forEach(session::insert);
            }
        }




        session.fireAllRules();
        session.dispose();

        return alerts;
    }

}
