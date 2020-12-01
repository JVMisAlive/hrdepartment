package com.hr.service;

import com.hr.model.Branch;
import com.hr.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public void saveUser(Branch branch) {
        branchRepository.save(branch);
    }

    @Override
    public void edit(Branch branch) {
        branchRepository.save(branch);
    }

    @Override
    public Branch getBranchById(Long id) {
        return branchRepository.getOne(id);
    }

    @Override
    public boolean ifExists(Long id) {
        return branchRepository.existsById(id);
    }
}
