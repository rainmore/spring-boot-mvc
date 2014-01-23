package net.rainmore.platform;

import net.rainmore.platform.config.JPAConfiguration;
import net.rainmore.platform.config.TemplateConfig;
import net.rainmore.platform.config.WebConfig;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

@TransactionConfiguration(defaultRollback = false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "dev")
@ContextConfiguration(classes = {JPAConfiguration.class, WebConfig.class, TemplateConfig.class})
@WebAppConfiguration
public abstract class GenericSpringTest extends GenericTest {
}
