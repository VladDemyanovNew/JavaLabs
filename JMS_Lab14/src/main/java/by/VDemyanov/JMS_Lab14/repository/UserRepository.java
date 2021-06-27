package by.VDemyanov.JMS_Lab14.repository;

import by.VDemyanov.JMS_Lab14.models.User;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User> {
    private List<User> users;
    private String filePathJSON = "";

    public UserRepository() {
        users = new ArrayList<User>();
    }

    @Override
    public boolean add(User item) {
        if (users.stream().anyMatch(user -> user.getId() == item.getId()))
            return false;
        users.add(item);
        return true;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public boolean update(User item) {
        return true;
    }

    @Override
    public boolean remove(int id) {
        return true;
    }

    public void writeInJson() {
        Gson gson = new Gson();
        String json = gson.toJson(users);
        try (FileWriter fw = new FileWriter("users.json", false)) {
            fw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
