package net.rainmore.platform.core.services;

import net.rainmore.platform.core.models.Account;
import net.rainmore.platform.core.repository.AccountRepository;
import net.rainmore.platform.core.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService extends GenericService<Account, Long> {

    @Autowired
    private AccountRepository repository;

    @Override
    protected GenericRepository<Account, Long> getRepository() {
        return repository;
    }
}
