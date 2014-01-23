package net.rainmore.platform.core.services.auth;

import net.rainmore.platform.core.models.auth.User;
import net.rainmore.platform.core.repository.GenericRepository;
import net.rainmore.platform.core.repository.auth.UserRepository;
import net.rainmore.platform.core.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, Long> {

    @Autowired
    UserRepository repository;

    @Override
    protected GenericRepository<User, Long> getRepository() {
        return repository;
    }

    public User findByName(String name) {
        return repository.findByName(name);
    }
}
