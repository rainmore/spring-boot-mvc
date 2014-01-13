package net.rainmore.platform.web.config;

import net.rainmore.platform.web.config.conversion.DateFormatter;
import net.rainmore.platform.web.config.conversion.LocalDateFormatter;
import net.rainmore.platform.web.config.conversion.LocalDateTimeFormatter;
import net.sourceforge.html5val.Html5ValDialect;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.resourceresolver.SpringResourceResourceResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import javax.servlet.Servlet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@ConditionalOnClass(SpringTemplateEngine.class)
public class TemplateConfig {

    @Autowired
    private SpringTemplateEngine templateEngine;

    public static final String DEFAULT_PREFIX = "classpath:/templates/";
    public static final String DEFAULT_SUFFIX = ".html";

    @Configuration
    @ConditionalOnMissingBean(name = "defaultTemplateResolver")
    public static class DefaultTemplateResolverConfiguration implements EnvironmentAware {

        @Autowired
        private ResourceLoader resourceLoader = new DefaultResourceLoader();

        private RelaxedPropertyResolver environment;

        @Override
        public void setEnvironment(Environment environment) {
            this.environment = new RelaxedPropertyResolver(environment,
                    "spring.thymeleaf.");
        }

        @Bean
        public ITemplateResolver defaultTemplateResolver() {
            TemplateResolver resolver = new TemplateResolver();
            resolver.setResourceResolver(thymeleafResourceResolver());
            resolver.setPrefix(this.environment.getProperty("prefix", DEFAULT_PREFIX));
            resolver.setSuffix(this.environment.getProperty("suffix", DEFAULT_SUFFIX));
            resolver.setTemplateMode(this.environment.getProperty("mode", "HTML5"));
            resolver.setCharacterEncoding(this.environment.getProperty("encoding",
                    "UTF-8"));
            resolver.setCacheable(this.environment.getProperty("cache", Boolean.class,
                    true));
            return resolver;
        }

        @Bean
        protected SpringResourceResourceResolver thymeleafResourceResolver() {
            return new SpringResourceResourceResolver();
        }

        public static boolean templateExists(Environment environment,
                                             ResourceLoader resourceLoader, String view) {
            String prefix = environment.getProperty("spring.thymeleaf.prefix",
                    TemplateConfig.DEFAULT_PREFIX);
            String suffix = environment.getProperty("spring.thymeleaf.suffix",
                    TemplateConfig.DEFAULT_SUFFIX);
            return resourceLoader.getResource(prefix + view + suffix).exists();
        }

    }

    @Configuration
    @ConditionalOnMissingBean(SpringTemplateEngine.class)
    protected static class ThymeleafDefaultConfiguration {

        @Autowired
        private Collection<ITemplateResolver> templateResolvers = Collections.emptySet();

        @Autowired(required = false)
        private Collection<IDialect> dialects = Collections.emptySet();

        @Bean
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine engine = new SpringTemplateEngine();
            for (ITemplateResolver templateResolver : this.templateResolvers) {
                engine.addTemplateResolver(templateResolver);
            }
            for (IDialect dialect : this.dialects) {
                engine.addDialect(dialect);
            }
            return engine;
        }

    }

    @Configuration
    @ConditionalOnClass(name = "nz.net.ultraq.thymeleaf.LayoutDialect")
    protected static class ThymeleafWebLayoutConfiguration {

        @Bean
        public LayoutDialect layoutDialect() {
            return new LayoutDialect();
        }

    }

    @Configuration
    @ConditionalOnClass({ Servlet.class })
    protected static class ThymeleafViewResolverConfiguration implements EnvironmentAware {

        private RelaxedPropertyResolver environment;

        @Override
        public void setEnvironment(Environment environment) {
            this.environment = new RelaxedPropertyResolver(environment,
                    "spring.thymeleaf.");
        }

        @Autowired
        private SpringTemplateEngine templateEngine;

        @Bean
        @ConditionalOnMissingBean(name = "thymeleafViewResolver")
        public ThymeleafViewResolver thymeleafViewResolver() {
            ThymeleafViewResolver resolver = new ThymeleafViewResolver();
            resolver.setTemplateEngine(this.templateEngine);
            resolver.setCharacterEncoding(this.environment.getProperty("encoding",
                    "UTF-8"));
            // Needs to come before any fallback resolver (e.g. a
            // InternalResourceViewResolver)
            resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 20);
            return resolver;
        }

    }

    @Bean
    public ConditionalCommentsDialect conditionalCommentsDialect() {
        return new ConditionalCommentsDialect();
    }

    @Bean
    public Html5ValDialect html5ValDialect() {
        return new Html5ValDialect();
    }

    @Configuration
    protected static class ThymeleafViewFormattingConversionConfiguration {

        @Bean
        @ConditionalOnClass(ThymeleafViewResolver.class)
        public FormattingConversionServiceFactoryBean conversionService() {
            FormattingConversionServiceFactoryBean cs = new FormattingConversionServiceFactoryBean();
            Set<Formatter> formatters = new HashSet<Formatter>();
            formatters.add(dateFormatter());
            formatters.add(localDateFormatter());
            formatters.add(localDateTimeFormatter());
            cs.setFormatters(formatters);
            return cs;
        }

        @Bean
        public DateFormatter dateFormatter() {
            return new DateFormatter();
        }

        @Bean
        public LocalDateFormatter localDateFormatter() {
            return new LocalDateFormatter();
        }

        @Bean
        public LocalDateTimeFormatter localDateTimeFormatter() {
            return new LocalDateTimeFormatter();
        }
    }

}
