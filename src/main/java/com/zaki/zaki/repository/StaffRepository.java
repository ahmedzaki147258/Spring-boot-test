package com.zaki.zaki.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zaki.zaki.model.Staff;

@Repository
public class StaffRepository {
    private List<Staff> allStaff = new ArrayList<>();

    public List<Staff> getAllStaff() {
        return allStaff;
    }

    public void addStaff(Staff staff) {
        allStaff.add(staff);
    }

    public Staff getStaffByIndex(int index){
        return allStaff.get(index);
    }

    public void updateStaff(int index, Staff staff) {
        allStaff.set(index, staff);
    }

    public void deleteStaff(int index) {
        allStaff.remove(index);
    }

    public int getSize() {
        return allStaff.size();
    }
}
