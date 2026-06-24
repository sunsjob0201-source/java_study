package model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> findAll() {
        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee("EMP001", "英 雄輔", 23));
        empList.add(new Employee("EMP002", "渡部 みゆき", 22));

        return empList;
    }
}

