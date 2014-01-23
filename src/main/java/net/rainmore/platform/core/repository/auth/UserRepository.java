package net.rainmore.platform.core.repository.auth;

import net.rainmore.platform.core.models.auth.User;
import net.rainmore.platform.core.repository.GenericRepository;

public interface UserRepository extends GenericRepository<User, Long> {

    User findByName(String name);
}
