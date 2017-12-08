package ru.bravery_and_stupidity.secretOfSatan.dao;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.jetbrains.annotations.NotNull;
import ru.bravery_and_stupidity.secretOfSatan.model.User;

@JsonNaming
public class UserDao {

    @NotNull
    private String login = "";

    @NotNull
    private String password = "";

    @NotNull
    private String name = "";

    @NotNull
    private String desire = "";

    @NotNull
    private String targetLogin = "";

    public void setLogin(@NotNull String login) {
        this.login = login;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setDesire(@NotNull String desire) {
        this.desire = desire;
    }

    public void setTarget(@NotNull String targetLogin) {
        this.targetLogin = targetLogin;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getLogin() {
        return login;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    @NotNull
    public String getDesire() {
        return desire;
    }

    @NotNull
    public String getTarget() {
        return targetLogin;
    }

    @NotNull
    public User mapToModel() {
        User model = new User();
        model.setLogin(login);
        model.setPassword(password);
        model.setName(name);
        model.setDesire(desire);
        model.setTarget(targetLogin);
        model.setAdmin(false);
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDao userDao = (UserDao) o;

        return login.equals(userDao.login)
                && password.equals(userDao.password)
                && name.equals(userDao.name)
                && desire.equals(userDao.desire)
                && targetLogin.equals(userDao.targetLogin);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + desire.hashCode();
        result = 31 * result + targetLogin.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDao{"
                + "login='" + login + '\''
                + ", password='" + password + '\''
                + ", name='" + name + '\''
                + ", desire='" + desire + '\''
                + ", targetLogin='" + targetLogin + '\''
                + '}';
    }

}
