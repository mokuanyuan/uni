/**
 * @Author Mr.k
 * @Description // Ecomm实体类的service层接口
 * @Date 17:16 2019/4/24
 **/

package edu.uni.userBaseInfo1.service;

import com.github.pagehelper.PageInfo;
import edu.uni.userBaseInfo1.bean.Ecomm;
import edu.uni.userBaseInfo1.utils.UserInfo;
import edu.uni.userBaseInfo1.bean.RequestMessage;

import java.util.HashMap;
import java.util.List;

public interface EcommService {

    /**
     * Author: mokuanyuan 14:52 2019/6/12
     * @param oldId
     * @param newId
     * @return boolean 操作结果
     * @apiNote: 当审批的最后一步都通过后进行的操作，把相应的信息记录进行更新操作
     */
    public boolean updateForApply(Long oldId,Long newId);

    /**
     * Author: mokuanyuan 16:55 2019/6/13
     * @param map
     * @param ecomm
     * @param idList
     * @param loginUser
     * @param modifiedUser
     * @return boolean
     * @apiNote: 用户点击申请时进行的一些系列为了创建申请记录所做的准备
     */
    public boolean readyForApply(HashMap<String,Object> map, Ecomm ecomm , long[] idList ,
                                 edu.uni.auth.bean.User loginUser, edu.uni.userBaseInfo1.bean.User modifiedUser);

    /**
     * Author: mokuanyuan 10:13 2019/4/26
     * @return List<Ecomm>
     * @apiNote: 查询所有的电子通讯方式
     */
    List<Ecomm> selectAll();

    /**
     * Author: mokuanyuan 10:15 2019/4/26
     * @param id
     * @return Ecomm
     * @apiNote: 根据id查询电子通信记录
     */
    Ecomm selectById(long id);

    /**
     * Author: mokuanyuan 10:18 2019/4/26
     * @param pageNum
     * @return List<Ecomm>
     * @apiNote: 分页查询电子通信记录
     */
    PageInfo<Ecomm> selectPage(int pageNum);

    /**
     * Author: mokuanyuan 21:08 2019/4/24
     * @param ecomm
     * @return boolean
     * @apiNote : 用于增加Ecomm表的一个记录
     */
    int insert(Ecomm ecomm);

    /**
     * Author: mokuanyuan 21:08 2019/4/24
     * @param ecomm
     * @return boolean
     * @apiNote : 用于更新Ecomm表的某个记录（传一个新的对象）
     */
    boolean update(Ecomm ecomm);

    /**
     * Author: mokuanyuan 21:08 2019/4/24
     * @param id
     * @return boolean
     * @apiNote : 用于删除Ecomm表的某个记录
     */
    boolean delete(long id);

    /**
     * Author: laizhouhao 15:41 2019/5/9
     * @param user_id
     * @return List<Ecomm>
     * @apiNote: 根据用户id返回用户的有效的通信信息
     */
    List<Ecomm> selectValidEcomByUserId(Long user_id);

    /**
     * Author: laizhouhao 18:35 2019/5/13
     * @param requestMessage
     * @return boolean
     * @apiNote: 用户点击申请修改通信方式
     */
    boolean clickApplyEcomm(RequestMessage requestMessage);

    /**
     * Author: mokuanyuan 20:03 2019/5/13
     * @param userInfo
     * @param user_id
     * @apiNote: 根据用户id查询电子通信方式，并把结果赋值到工具类UserInfo的相应属性中
     */
    public void getEcommByUserIdToUserInfo(UserInfo userInfo , Long user_id);

    /**
     * Author: mokuanyuan 10:47 2019/6/20
     * @param ecomms
     * @return List<Ecomm>
     * @apiNote: 传入一个电子通信方式数组，筛选出一个新的数组（同一种通信方式类型的记录最多只有一个）
     */
    public List<Ecomm> filterEcomm(List<Ecomm> ecomms);

    /**
     * Author: laizhouhao 20:21 2019/6/9
     * @param ecommList
     * @return 用户通信方式
     * @apiNote: 根据用户id获取用户的通信方式
     */
    public void getUserEcomm(HashMap<String, Object>map, List<Ecomm> ecommList);
}
