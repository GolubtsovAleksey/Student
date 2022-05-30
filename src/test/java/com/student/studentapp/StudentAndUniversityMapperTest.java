package com.student.studentapp;

import com.student.Mapper.StudentMapper;
import com.student.Mapper.UniversityMapper;
import com.student.domain.StudentEntity;
import com.student.domain.UniversityEntity;
import com.student.dto.StudentDto;
import com.student.dto.UniversityDto;
import org.junit.jupiter.api.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentAndUniversityMapperTest {

    @Test
    void studentMapToDtoTest() throws ParseException {
        StudentEntity studentEntity = new StudentEntity();                                    // дано:
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-05");
        studentEntity.setFirstName("Sanya");
        studentEntity.setLastName("Esip");
        studentEntity.setEmail("se@gmail.ru");
        studentEntity.setGender("male");
        studentEntity.setDateOfBirth(date);
        studentEntity.setCountryOfBirth("Russia");

        StudentDto studentDto = StudentMapper.mapToDto(studentEntity);                      // вызываем код который хотим проверить

        assertEquals("Sanya", studentDto.getFirst_name());                          // то что получили проверяем
        assertEquals("Esip", studentDto.getLast_name());
        assertEquals("se@gmail.ru", studentDto.getEmail());
        assertEquals("male", studentDto.getGender());
        assertEquals("Fri May 05 00:00:00 MSD 1995", studentDto.getDate_of_birth().toString());
        assertEquals("Russia", studentDto.getCountry_of_birth());
    }

    @Test
    void studentMapToEntityTest() throws ParseException {
        StudentDto studentDto = new StudentDto();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-05");
        studentDto.setFirst_name("Sanya");
        studentDto.setLast_name("Esip");
        studentDto.setEmail("se@gmail.ru");
        studentDto.setGender("male");
        studentDto.setDate_of_birth(date);
        studentDto.setCountry_of_birth("Russia");

        StudentEntity studentEntity = StudentMapper.mapToEntity(studentDto);

        assertEquals("Sanya", studentEntity.getFirstName());
        assertEquals("Esip", studentEntity.getLastName());
        assertEquals("se@gmail.ru", studentEntity.getEmail());
        assertEquals("male", studentEntity.getGender());
        assertEquals("Fri May 05 00:00:00 MSD 1995", studentEntity.getDateOfBirth().toString());
        assertEquals("Russia", studentEntity.getCountryOfBirth());
    }

    @Test
    void universityMapToDtoTest() throws ParseException {
        UniversityEntity universityEntity = new UniversityEntity();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-05");
        universityEntity.setAbbreviation("VSU");
        universityEntity.setFullTitle("Voronezh State University");
        universityEntity.setFoundingDate(date);

        UniversityDto universityDto = UniversityMapper.mapToDto(universityEntity);

        assertEquals("VSU", universityDto.getAbbreviation());
        assertEquals("Voronezh State University", universityDto.getFullTitle());
        assertEquals("Fri May 05 00:00:00 MSD 1995", universityDto.getFoundingDate().toString());
    }

    @Test
    void universityMapToEntityTest() throws ParseException {
        UniversityDto universityDto = new UniversityDto();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-05");
        universityDto.setAbbreviation("VSU");
        universityDto.setFullTitle("Voronezh State University");
        universityDto.setFoundingDate(date);

        UniversityEntity universityEntity = UniversityMapper.mapToEntity(universityDto);

        assertEquals("VSU", universityEntity.getAbbreviation());
        assertEquals("Voronezh State University", universityEntity.getFullTitle());
        assertEquals("Fri May 05 00:00:00 MSD 1995", universityEntity.getFoundingDate().toString());
    }

}