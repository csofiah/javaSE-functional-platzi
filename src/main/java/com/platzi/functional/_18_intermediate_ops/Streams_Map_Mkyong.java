package com.platzi.functional._18_intermediate_ops;

import com.platzi.functional.model.Staff;
import com.platzi.functional.model.StaffPublic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams_Map_Mkyong {

    public static void main(String[] args) {

        List<String> alpha = Arrays.asList("a", "b", "c", "d");

        List<Staff> listStaff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );


      //  showUpperCase(alpha);

      //  showMultiploTwo();

      //  showListNames(listStaff);

        convertListStaffToStaffPublic(listStaff);
    }

    private static void convertListStaffToStaffPublic(List<Staff> listStaff) {
        List<StaffPublic> staffPublicList = listStaff.stream()
                .map(
                        staff -> {
                            StaffPublic sp = new StaffPublic();
                            sp.setAge(staff.getAge());
                            sp.setName(staff.getName());
                            if(staff.getName().equals("mkyong")){
                                sp.setExtra("This field is only for mkyong");
                            }
                            return sp;
                        }
                )
                .collect(Collectors.toList());
        System.out.println(staffPublicList);
    }

    private static void showListNames(List<Staff> listStaff) {
        List<String> names = listStaff.stream()
                .map(Staff::getName)
                .collect(Collectors.toList());

        System.out.println(names);
        //[mkyong, jack, lawrence]
    }

    private static void showMultiploTwo() {
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream()
                .map(n -> n*2)
                .collect(Collectors.toList());

        System.out.println(collect1);
    }

    private static void showUpperCase(List<String> alpha) {
        List<String> alphaUpperCase = alpha.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(alphaUpperCase);
    }
}
