package com.hr.controller.rest;

import com.hr.model.Branch;
import com.hr.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRestController {
    private final BranchService branchService;

    public MainRestController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/allBranches")
    public ResponseEntity<List<Branch>> userList() {
        List<Branch> branches = branchService.getAllBranches();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Branch> newUser(@RequestBody Branch branch) {
        try {
            branchService.saveUser(branch);
            return new ResponseEntity<>(branch, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        try {
            branchService.deleteBranch(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
