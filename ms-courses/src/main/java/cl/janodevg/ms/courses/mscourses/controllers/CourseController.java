package cl.janodevg.ms.courses.mscourses.controllers;


import cl.janodevg.ms.courses.mscourses.entity.Course;
import cl.janodevg.ms.courses.mscourses.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/course/all")
    public ResponseEntity<List<Course>> listCourses(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<?> getCourse(@PathVariable Long id){
        if(service.findById(id).isPresent()){
            return ResponseEntity.ok(service.findById(id).get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/course")
    public ResponseEntity<?> createCourse (@RequestBody Course course){
        return ResponseEntity.ok(service.save(course));
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<?> updateCourse (@RequestBody Course course, @PathVariable Long id){
        if (service.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(course));
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/course")
    public ResponseEntity<?> deleteCourse (@PathVariable Long id){
        if (service.findById(id).isPresent()){
            service.deleteById(id);
             return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
