package net.rainmore.platform.web.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.Charset;

public class TestUtil {
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    public static final MediaType APPLICATION_JSONP_UTF8  = new MediaType("application", "x-javascript", Charset.forName("utf8"));

    private static int DEFAULT_RANDOM_LENGTH = 10;

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    public static String randomString(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }

    public static String randomString() {
        return RandomStringUtils.randomAlphanumeric(DEFAULT_RANDOM_LENGTH);
    }
}
