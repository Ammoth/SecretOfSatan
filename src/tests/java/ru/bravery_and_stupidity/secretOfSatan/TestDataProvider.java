package ru.bravery_and_stupidity.secretOfSatan;

import org.jetbrains.annotations.NotNull;
import ru.bravery_and_stupidity.secretOfSatan.dao.UserDao;
import ru.bravery_and_stupidity.secretOfSatan.model.User;

public interface TestDataProvider {

    TestDataProvider INSTANCE = new TestDataProviderUnit();

    @NotNull
    UserDao getSimpleUserDaoExample();

    @NotNull
    UserDao getInvalidUserDaoExample();

    @NotNull
    User getNewSimpleUserExample();

}
