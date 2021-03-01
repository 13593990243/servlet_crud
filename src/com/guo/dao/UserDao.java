package com.guo.dao;

import com.guo.entity.User;
import com.guo.uilts.DateUtil;
import com.guo.uilts.DbUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author guosx
 * @date 2021/2/25
 */
public class UserDao {
    /*
     *
     *功能描述 验证账号密码
     * @author Guosx
     * @date 2021/2/25
     * @param [user]
     * @return java.util.ArrayList<com.guo.entity.User>
     */
    public ArrayList<User> findByNameAndPs(User user) {
        ArrayList<User> list = new ArrayList<>();
        Connection conn = DbUtil.getConn();
        PreparedStatement prep = null;
        ResultSet rs = null;

        String sql = "select username,password from sys_user where username=? and password=?";
        try {
            prep = conn.prepareStatement(sql);
            prep.setString(1, user.getUsername());
            prep.setString(2, user.getPassword());
            rs = prep.executeQuery();
            while (rs.next()) {
                User user1 = new User();
                user1.setUsername(rs.getString("username"));
                user1.setPassword(rs.getString("password"));
                list.add(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs, prep, conn);
        }
        return list;
    }

    /*
     *
     *功能描述 根据id查询
     * @author Guosx
     * @date 2021/2/26
     * @param [id]
     * @return com.guo.entity.User
     */
    public User findById(Integer id) {
        User user = new User();
        Connection conn = DbUtil.getConn();
        PreparedStatement prep = null;
        ResultSet rs = null;
        String sql = "select * from sys_user where id=?";
        try {
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);
            rs = prep.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getInt("sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs, prep, conn);
        }
        return user;
    }

    /*
     *
     *功能描述 查询所有信息
     * @author Guosx
     * @date 2021/2/25
     * @param [user]
     * @return java.util.ArrayList<com.guo.entity.User>
     */
    public ArrayList<User> listAll() {
        ArrayList<User> list = new ArrayList<>();
        Connection conn = DbUtil.getConn();
        PreparedStatement prep = null;
        ResultSet rs = null;

        String sql = "select * from  sys_user";
        try {
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                User user1 = new User();
                user1.setId(rs.getInt("id"));
                user1.setUsername(rs.getString("username"));
                user1.setSex(rs.getInt("sex"));
                Timestamp createTime = rs.getTimestamp("create_time");
                String date = DateUtil.getDate(createTime);
                user1.setCreateTime(date);
                list.add(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(rs, prep, conn);
        }
        return list;
    }

    /*
     *
     *功能描述 添加
     * @author Guosx
     * @date 2021/2/26
     * @param [user]
     * @return void
     */
    public void addUser(User user) {
        Connection conn = DbUtil.getConn();
        PreparedStatement prep = null;
        String sql = "insert into sys_user(id,username,password,sex,create_time) values(null,?,?,?,?)";
        try {
            prep = conn.prepareStatement(sql);
            prep.setString(1, user.getUsername());
            prep.setString(2, user.getPassword());
            prep.setInt(3, user.getSex());
            prep.setString(4, user.getCreateTime());
            prep.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(prep, conn);
        }
    }


    /*
     *
     *功能描述 删除
     * @author Guosx
     * @date 2021/2/26
     * @param [id]
     * @return void
     */
    public void deleteById(Integer id) {
        Connection conn = DbUtil.getConn();
        PreparedStatement prep = null;
        String sql = "delete from sys_user where id=?";
        try {
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);
            prep.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(prep, conn);
        }
    }

    /*
    *
     *功能描述 修改
     * @author Guosx
     * @date 2021/2/26
     * @param [user]
     * @return void
     */
    public void updateUser(User user) {
        Connection conn = DbUtil.getConn();
        PreparedStatement prep = null;
        String sql = "update sys_user set username=? , `password`=?,sex=? where id=?";
        try {
            prep = conn.prepareStatement(sql);
            prep.setString(1, user.getUsername());
            prep.setString(2, user.getPassword());
            prep.setInt(3, user.getSex());
            prep.setInt(4, user.getId());
            prep.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(prep, conn);
        }
    }

}
