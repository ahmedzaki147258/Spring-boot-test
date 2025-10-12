package com.zaki.zaki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaki.zaki.Constants;
import com.zaki.zaki.model.Staff;
import com.zaki.zaki.repository.StaffRepository;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    public void addStaff(Staff staff) {
        staffRepository.addStaff(staff);
    }

    public Staff getStaffById(String id) {
        int index = getStaffIndex(id);
        return index == Constants.NO_MATCH ? new Staff() : getStaffByIndex(index);
    }

    public Staff getStaffByIndex(int index) {
        return staffRepository.getStaffByIndex(index);
    }

    public void updateStaff(int index, Staff staff) {
        staffRepository.updateStaff(index, staff);
    }

    public void deleteStaff(String id) {
        int index = getStaffIndex(id);
        if(index != Constants.NO_MATCH) staffRepository.deleteStaff(index);
    }

    public int getSize() {
        return staffRepository.getSize();
    }

    private int getStaffIndex(String id){
        for (int i = 0; i < getSize(); i++) {
            if(getStaffByIndex(i).getId().equals(id)) return i;
        }
        return Constants.NO_MATCH;
    }

    public void submitStaff(Staff staff){
        int index = getStaffIndex(staff.getId());
        if(index == Constants.NO_MATCH) addStaff(staff);
        else updateStaff(index, staff);
    }
}
