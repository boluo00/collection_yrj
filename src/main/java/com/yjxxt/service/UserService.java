package com.yjxxt.service;

import com.yjxxt.pojo.User;
import javafx.beans.value.WritableValue;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Consumer;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

/**
 * 用户模块
 */
public class UserService {
    private List<User> users;

    public UserService() {
        users = new ArrayList<User>();
        users.add(new User(1,"admin","123456","admin","",""));
        users.add(new User(2,"test","123456","test","",""));
    }

    /**
     * 添加用户
     */
    public void addUser(User user){
        /**
         * 1.参数合法化校验
         * 2.用户名唯一&昵称唯一
         * 3.添加
         */
        if (user == null) {
            throw new RuntimeException("用户记录为空！");
        }
        if (StringUtils.isBlank(user.getUserName())) {
            throw new RuntimeException("用户名不能为空");
        }
        if (StringUtils.isBlank(user.getUserPwd())) {
            throw new RuntimeException("用户密码不能为空");
        }

        /**
         * 用户名唯一校验
         */
        for (User temp: users) {
            if (temp.getUserName().equals(user.getUserName())) {
                throw new RuntimeException("用户名已存在");
            }
        }

        /*if (users.contains(user)) {
            throw new RuntimeException("用户名已存在");
        }*/

        /*Long count = users.stream()
                            .filter(u->u.getUserName().equals(user.getUserName()))
                            .count();
        if (count==1) {
            throw new RuntimeException("用户名已存在");
        }*/

        users.add(user);
    }

    /**
     * 展示用户
     */
    public void listUser(){
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }

        /*for (User user :users){
            System.out.println(user);
        }*/

        /*Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next());
        }*/

        /*ListIterator<User> userListIterator = users.listIterator();
        while (userListIterator.hasNext()) {
            System.out.println(userListIterator.next());
        }*/

        /*users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });*/

        /*users.forEach(u->{
            System.out.println(u);
        });*/
    }

    /**
     * 更新用户
     */
    public void updateUser(User user) {
        if(null == user){
            throw  new RuntimeException("用户记录为空!");
        }
        if(StringUtils.isBlank(user.getUserName())){
            throw  new RuntimeException("用户名称不能为空!");
        }
        if(StringUtils.isBlank(user.getUserPwd())){
            throw  new RuntimeException("用户密码不能为空!");
        }
        if(StringUtils.isBlank(user.getNick())){
            throw  new RuntimeException("用户昵称不能为空!");
        }

        if (user.getId()==null||null==findUserByUserId(user.getId())){
            throw new RuntimeException("待更新记录不存在");
        }

        Long count = users.stream()
                            .filter(u->u.getUserName().equals(user.getUserName()))
                            .filter(u->u.getId().equals(user.getId()))
                            .count();
        if (count==1) {
            throw new RuntimeException("用户昵称已存在");
        }

        users.set(users.indexOf(findUserByUserId(user.getId())),user);
    }

    /**
     * 删除用户
     */
    public void delUser(Integer userId) {
        User result = this.findUserByUserId(userId);
        if (result == null) {
            throw new RuntimeException("待删除记录不存在");
        }
        users.remove(result);
    }

    /**
     * 用户登录
     */
    public void login(String userName,String userPwd) {
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("用户名不能为空");
        }
        if (StringUtils.isBlank(userPwd)) {
            throw new RuntimeException("密码不能为空");
        }

        Integer index=null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName)){
                index = i;
                break;
            }
        }
        if (index==null)
            throw new RuntimeException("用户记录不存在");
        User temp = users.get(index);

        /*Optional<User> optionalUser = users.stream().filter(u->u.getUserName().equals(userName)).findFirst();
        if (!optionalUser.isPresent())
            throw new RuntimeException("用户记录不存在！");*/

        System.out.println("用户登录成功");
    }

    /**
     * 通过id查询
     * @param userId
     * @return
     */
    public User findUserByUserId(Integer userId) {
        /*Integer index = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userId)) {
                index = i;
                break;
            }
        }
        return index==null?null:users.get(index);*/

        /*User result = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userId)) {
                result = users.get(i);
            }
            break;
        }
        return result;*/

        Optional<User> optionalUser = users.stream()
                                            .filter(u->u.getId().equals(userId))
                                            .findFirst();
        return optionalUser.isPresent() ? optionalUser.get() :null;
    }
}
