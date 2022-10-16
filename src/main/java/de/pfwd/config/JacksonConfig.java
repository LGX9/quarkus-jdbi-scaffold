package de.pfwd.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import io.quarkus.jackson.ObjectMapperCustomizer;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import javax.inject.Singleton;

@Singleton
public class JacksonConfig implements ObjectMapperCustomizer {

  DateTimeFormatter formatter = new DateTimeFormatterBuilder()
      // date/time
      .appendPattern("yyyy-MM-dd HH:mm:ss")
      // optional fraction of seconds (from 0 to 9 digits)
      .optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true).optionalEnd()
      // offset
      .appendPattern("x")
      // create formatter
      .toFormatter();

  @Override
  public void customize(ObjectMapper objectMapper) {
    objectMapper.registerModule(new ParameterNamesModule());
    JavaTimeModule timeModule = new JavaTimeModule();
    timeModule.addSerializer(OffsetDateTime.class, new CustomOffsetDateTimeSerializer(formatter));
    timeModule.addDeserializer(OffsetDateTime.class, new CustomOffsetDateTimeDeserializer(formatter));
    objectMapper.registerModule(timeModule);
    objectMapper.registerModule(new Jdk8Module());
  }

  public class CustomOffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {

    private DateTimeFormatter formatter;

    public CustomOffsetDateTimeDeserializer(DateTimeFormatter formatter) {
      this.formatter = formatter;
    }

    @Override
    public OffsetDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
      return OffsetDateTime.parse(parser.getText(), this.formatter);
    }
  }

  public class CustomOffsetDateTimeSerializer extends JsonSerializer<OffsetDateTime> {

    private DateTimeFormatter formatter;

    public CustomOffsetDateTimeSerializer(DateTimeFormatter formatter) {
      this.formatter = formatter;
    }

    @Override
    public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
      gen.writeString(value.format(this.formatter));
    }
  }
}
