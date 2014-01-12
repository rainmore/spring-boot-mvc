package net.rainmore.platform.core.repositories;

import net.rainmore.platform.core.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
