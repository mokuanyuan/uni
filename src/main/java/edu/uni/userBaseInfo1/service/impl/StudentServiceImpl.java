package edu.uni.userBaseInfo1.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.uni.example.config.ExampleConfig;
import edu.uni.userBaseInfo1.bean.Student;
import edu.uni.userBaseInfo1.mapper.StudentMapper;
import edu.uni.userBaseInfo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author laizhouhao
 * @Description Student实体类的service层接口的实现类
 * @Date 10:11 2019/4/30
 **/
//Service类的注解，标志这是一个服务层接口类，这样才能被Spring”“”“”“”"扫描"到
@SuppressWarnings("ALL")
@Service
public class StudentServiceImpl implements StudentService {
    //持久层接口的对象
    @Autowired
    private StudentMapper studentMapper;  //爆红时由于编译器问题，不影响运行

    //配置类，规定了上传文件的路径和分页查询每一页的记录数
    @Autowired
    private ExampleConfig config;

    /**
     * Author: laizhouhao 10:14 2019/4/30
     * @return List<Student>
     * @apiNote: 查询所有学生记录，不分页
     */
    public List<Student> selectAll() {
        return studentMapper.selectByExample(null);
    }

    /**
     * Author: laizhouhao 10:15 2019/4/30
     * @param id
     * @return Student
     * @apiNote: 通过id查询一个学生记录
     */
    public Student selectById(long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    /**
     * Author: laizhouhao 10:16 2019/4/30
     * @param pageNum
     * @return pageInfo<Student>
     * @apiNote: 分页查询所有学生记录
     */
    public PageInfo<Student> selectPage(int pageNum) {
        //设置查询的是哪一页和每一页有多少个记录
        PageHelper.offsetPage(pageNum,config.getPageSize());

        //无条件查询（条件对象为null，即无条件），查询所有
        List<Student> ecomms = studentMapper.selectByExample(null);

        //检验查询的结果
        if(ecomms != null )
            return new PageInfo<>(ecomms);
        else
            return null;

    }

    /**
     * Author: laizhouhao 10:17 2019/4/30
     * @param student
     * @return boolean
     * @apiNote: 插入一条电子学生记录
     */
    public boolean insert(Student student) {
        return studentMapper.insertSelective(student) > 0 ? true : false;
    }

    /**
     * Author: laizhouhao 10:18 2019/4/30
     * @param student
     * @return  boolean
     * @apiNote: 以一个新的对象更新一条学生记录
     */
    public boolean update(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student) > 0 ? true : false;
    }

    /**
     * Author: laizhouhao 10:18 2019/4/30
     * @param id
     * @return boolean
     * @apiNote: 以id删除一条学生记录
     */
    public boolean delete(long id) {
        return studentMapper.deleteByPrimaryKey(id) > 0 ? true : false;
    }
}
