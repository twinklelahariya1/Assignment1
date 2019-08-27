package com.finalassignment.bookworm.service.impl;

import com.finalassignment.bookworm.dto.AdminDto;
import com.finalassignment.bookworm.exception.AdminNotFoundException;
import com.finalassignment.bookworm.model.Admin;
import com.finalassignment.bookworm.repository.AdminRepository;
import com.finalassignment.bookworm.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.finalassignment.bookworm.util.DtoUtil.fromAdmin;
import static com.finalassignment.bookworm.util.DtoUtil.fromAdminDto;


@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }



    @Override
    public AdminDto addAdmin(AdminDto adminDto) {
        Admin admin = adminRepository.save(fromAdminDto(adminDto));
        return adminDto;
    }

    @Override
    public List<AdminDto> getAdmin() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminDto> adminDtos = null;
        if (!CollectionUtils.isEmpty(admins)) {
            adminDtos = new ArrayList<>();
            for (Admin admin : admins) {
                AdminDto adminDto = fromAdmin(admin);
                adminDtos.add(adminDto);
            }
        }
        return adminDtos;
    }

    @Override
    public AdminDto findById(Long adminId) {

        Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException(adminId));
        AdminDto adminDto = fromAdmin(admin);
        return adminDto;
    }
}
