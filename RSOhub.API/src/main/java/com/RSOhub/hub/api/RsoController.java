package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.RsoMembershipRepository;
import com.RSOhub.hub.dao.RsoPetitionRepository;
import com.RSOhub.hub.dao.RsoRepository;
import com.RSOhub.hub.dao.UserRepository;
import com.RSOhub.hub.dto.IsUserInRsoRequest;
import com.RSOhub.hub.dto.JoinRequest;
import com.RSOhub.hub.dto.PetitionRequest;
import com.RSOhub.hub.model.Rso;
import com.RSOhub.hub.model.RsoMembership;
import com.RSOhub.hub.model.RsoPetition;
import com.RSOhub.hub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* TODO:
 * -----------------------------------------
 * Create
 *   1) create petition and rso (check)
 * -----------------------------------------
 * Join (check)
 *   1) increment member count
 *   2) update membership table
 *   3) if cnt==5,
 *       {a} promote user in petition table
 *       {b} set rso active
 *       {c} delete petition table entry
 * -----------------------------------------
 * List
 *   1) list by all (check)
 *   2) list by user (check)
 * -----------------------------------------
 * */
@RequestMapping("api/rso")
@RestController
public class RsoController {
    private final RsoRepository rsoRepository;
    private final RsoMembershipRepository rsoMembershipRepository;
    private final RsoPetitionRepository rsoPetitionRepository;
    private final UserRepository userRepository;

    @Autowired
    public RsoController(
            RsoRepository rsoRepository,
            RsoMembershipRepository rsoMembershipRepository,
            RsoPetitionRepository rsoPetitionRepository,
            UserRepository userRepository
    ) {
        this.rsoRepository = rsoRepository;
        this.rsoMembershipRepository = rsoMembershipRepository;
        this.rsoPetitionRepository = rsoPetitionRepository;
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "create")
    public Rso create(@RequestBody Rso rso) {
        return rsoRepository.save(rso);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "join")
    public Rso join(@RequestBody JoinRequest joinRequest) {
        try {
            boolean isUserInRso;

            // Get list of RSOs user is in.
            List<Rso> rsosUserIsIn = rsoMembershipRepository.findByRefUserId(joinRequest.getRefUserId()).stream()
                    .map(rsoMembership -> rsoMembership.getRefRsoId())
                    .map(rsoRepository::findById)
                    .map(rso -> rso.get())
                    .collect(Collectors.toList());

            // If request RSO is in that list, then the user is in the request RSO.
            for (Rso rso : rsosUserIsIn) {
                if (rso.getId() == joinRequest.getRefRsoId()) {
                    isUserInRso = true;
                }
            }
            isUserInRso = false;

            if (isUserInRso) {
                return null;
            }

            RsoMembership rsoMembership = new RsoMembership();
            Rso rso = rsoRepository.findById(joinRequest.getRefRsoId()).get();
            rso.setMemberCount(rso.getMemberCount() + 1);

            if (rso.getMemberCount() == 5) {
                rso.isActive = true;
                RsoPetition petition = rsoPetitionRepository.findByRefRsoId(rso.getId());
                int founderId = petition.getRefUserId();
                User founder = userRepository.findById(founderId).get();
                founder.setUserType("ADMIN");

                rsoPetitionRepository.delete(petition);
            }

            rsoRepository.save(rso);
            rsoMembership.setRefRsoId(rso.getId());
            rsoMembership.setRefUserId(joinRequest.getRefUserId());
            rsoMembershipRepository.save(rsoMembership);

            return rso;
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "petition")
    public RsoPetition petition(@RequestBody PetitionRequest petitionRequest) {
        Rso newRso = new Rso(petitionRequest.getRsoName());
        newRso = rsoRepository.save(newRso);

        // Create petition.
        RsoPetition rsoPetition = new RsoPetition();
        rsoPetition.setRefRsoId(newRso.getId());
        rsoPetition.setRefUserId(petitionRequest.getUserId());

        // Create membership.
        RsoMembership rsoMembership = new RsoMembership();
        newRso.setMemberCount(newRso.getMemberCount() + 1);
        rsoRepository.save(newRso);
        rsoMembership.setRefRsoId(newRso.getId());
        rsoMembership.setRefUserId(petitionRequest.getUserId());
        rsoMembershipRepository.save(rsoMembership);

        return rsoPetitionRepository.save(rsoPetition);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "list")
    public List<Rso> list() {
        return rsoRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "listByUserId")
    public List<Rso> listByUserId(@RequestBody int userId) {
        return rsoMembershipRepository.findByRefUserId(userId).stream()
                .map(rsoMembership -> rsoMembership.getRefRsoId())
                .map(rsoRepository::findById)
                .map(rso -> rso.get())
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "delete")
    public Rso delete(@RequestBody int rsoId) {
        try {
            Optional<Rso> deletedRso = rsoRepository.findById(rsoId);
            rsoRepository.deleteById(rsoId);
            return deletedRso.get();
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "isUserInRso")
    public boolean isUserInRso(@RequestBody IsUserInRsoRequest isUserInRsoRequest) {
        try {
            // Get list of RSOs user is in.
            List<Rso> rsosUserIsIn = rsoMembershipRepository.findByRefUserId(isUserInRsoRequest.getRefUserId()).stream()
                    .map(rsoMembership -> rsoMembership.getRefRsoId())
                    .map(rsoRepository::findById)
                    .map(rso -> rso.get())
                    .collect(Collectors.toList());

            // If request RSO is in that list, then the user is in the request RSO.
            for (Rso rso : rsosUserIsIn) {
                if (rso.getId() == isUserInRsoRequest.getRefRsoId()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
