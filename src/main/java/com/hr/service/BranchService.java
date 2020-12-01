package com.hr.service;

import com.hr.model.Branch;

import java.util.List;

public interface BranchService {
    List<Branch> getAllBranches();

    void deleteBranch(Long id);

    void saveUser(Branch branch);

    void edit(Branch branch);

    Branch getBranchById(Long id);

    boolean ifExists(Long id);
}
