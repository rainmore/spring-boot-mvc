package net.rainmore.platform;


import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"net.rainmore.platform"})
public class Application {
    public enum Env {
        DEV,
        PROD,
        STAGE;

        public String value() {
            return toString();
        }

        public String toString() {
            return name().toLowerCase();
        }

        public static Env forValue(final String value) {
            for (Env env : Env.values()) {
                if (value.equals(env.value()) ) {
                    return env;
                }
            }
            return null;
        }

        public Boolean isDev() {
            return this.equals(DEV);
        }

    }

    public static final Config config = ConfigFactory.load();
    public static final String release = config.getString("system.release");

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public static void exit(ApplicationContext context, final int code) {
        SpringApplication.exit(context, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return code;
            }
        });
    }

    public static Env getEnv() {
        Env env = Env.forValue(System.getenv("ENV"));
        if (env == null) {
            env = Env.DEV;
        }
        return env;
    }
}
