package com.example.controller;

import com.example.common.Result;
import com.example.entity.Course;
import com.example.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Reader;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    /**
     * 查询
     *
     * @param pageNum
     * @param pageSize
     * @param course
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "1") Integer pageSize,
                             Course course) {
        PageInfo<Course> pageInfo = courseService.selectPage(pageNum, pageSize, course);
        return Result.success(pageInfo);
    }

    /**
     * 添加课程
     *
     * @param course
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Course course) {
        courseService.add(course);
        return Result.success();
    }

    /**
     * 修改
     *
     * @param course
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Course course) {
        courseService.updateById(course);
        return Result.success();
    }


    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        courseService.deleteById(id);
        return Result.success();
    }
}
