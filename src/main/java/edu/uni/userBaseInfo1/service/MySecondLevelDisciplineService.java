package edu.uni.userBaseInfo1.service;

import com.github.pagehelper.PageInfo;
import edu.uni.professionalcourses.bean.SecondLevelDiscipline;

import java.util.List;

public interface MySecondLevelDisciplineService {
    /**
     * Author: chenenru 23:59 2019/4/29
     * @param
     * @return List<SecondLevelDiscipline>
     * @apiNote: 查询所有的二级学科
     */
    List<SecondLevelDiscipline> selectAllSecondLevelDisciplines();
    /**
     * Author: chenenru 0:00 2019/4/30
     * @param id
     * @return SecondLevelDiscipline
     * @apiNote: 根据id查询二级学科
     */
    SecondLevelDiscipline selectSecondLevelDisciplineById(long id);
    /**
     * Author: chenenru 0:00 2019/4/30
     * @param pageNum
     * @return PageInfo<SecondLevelDiscipline>
     * @apiNote: 分页查询二级学科
     */
    PageInfo<SecondLevelDiscipline> selectSecondLevelDisciplineByPage(int pageNum);
    /**
     * Author: chenenru 0:00 2019/4/30
     * @param SecondLevelDiscipline
     * @return boolean
     * @apiNote: 二级学科添加SecondLevelDiscipline表的一条记录
     */
    boolean insertSecondLevelDiscipline(SecondLevelDiscipline SecondLevelDiscipline);
    /**
     * Author: chenenru 0:00 2019/4/30
     * @param SecondLevelDiscipline
     * @return boolean
     * @apiNote:  用户更新一个SecondLevelDiscipline表的某个记录（传一个新的对象）
     */
    boolean updateSecondLevelDiscipline(SecondLevelDiscipline SecondLevelDiscipline);
    /**
     * Author: chenenru 0:00 2019/4/30
     * @param id
     * @return boolean
     * @apiNote:  用于删除SecondLevelDiscipline表的某个记录
     */
    boolean deleteSecondLevelDiscipline(long id);
    /**
     * Author: laizhouhao 20:56 2019/5/15
     * @param id
     * @return SecondLevelDiscipline
     * @apiNote: 根据id获取有效的二级学科信息
     */
    SecondLevelDiscipline selectValidSecondLevelDisciplineById(Long id);

    /**
     * Author: mokuanyuan 16:30 2019/6/27
     * @param name
     * @return List<SecondLevelDiscipline>
     * @apiNote 根据名称模糊搜索二级学科
     */
    List<SecondLevelDiscipline> selectByName(String name);
}
