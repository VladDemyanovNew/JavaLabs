package VDemyanov.Java_Lab8_WEB.dao;


import VDemyanov.Java_Lab8_WEB.entity.Role;

import java.util.List;

public interface RoleDAO {
    void add(Role person);
    List<Role> getAll();
    Role getById(int id);
    void update(Role person);
    void remove(Role person);
}
