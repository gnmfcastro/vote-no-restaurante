package com.bluesoft.vote.no.restaurante.model.entities.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimePersistenceConverter implements AttributeConverter<LocalDateTime, Date>{
 
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
 
        if(localDateTime != null) {
            Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
            return Date.from(instant);
        }
         
        return null;
         
    }
 
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        Instant instant = Instant.ofEpochMilli(dbData.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
