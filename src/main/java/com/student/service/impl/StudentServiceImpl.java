package com.student.service.impl;

import com.student.repository.StudentRepository;
import com.student.service.FileWriterService;
import com.student.service.StudentService;
import com.student.mapper.StudentMapper;
import com.student.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private FileWriterService writeService;

    public List<StudentDto> findByName(String name, boolean saveInFile, boolean saveInFileReadable) throws IOException {
        List<StudentDto> allName = studentRepository.findByName(name)
                .stream()
                .map(StudentMapper::mapToDto)
                .collect(Collectors.toList());
        if (saveInFile) {
            writeService.write(allName);
        }
        if (saveInFileReadable) {
            writeService.readableRecord(allName);
        }
        return allName;
    }

    public void addStudentEntity(List<StudentDto> studentDtoList) {
        studentRepository.addStudentEntity(studentDtoList);
    }

    public void updateStudentEntity(StudentDto studentDto, int id) {
        studentRepository.updateStudentEntity(studentDto, id);
    }
}
