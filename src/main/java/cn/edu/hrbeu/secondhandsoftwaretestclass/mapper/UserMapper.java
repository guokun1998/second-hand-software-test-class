package cn.edu.hrbeu.secondhandsoftwaretestclass.mapper;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("INSERT INTO " +
            "user(user_name,user_student_id,user_password,user_phone_number) " +
            "VALUE(#{userName},#{userStudentId},#{userPassword},#{userPhoneNumber})")
    public void insertUser(User user);

    @Select("UPDATE user " +
            "SET user_name=#{userName},user_student_id=#{userStudentId},user_password=#{userPassword},user_phone_number=#{userPhoneNumber} " +
            "WHERE user_id=#{userId}")
    public void updateUser(User user);

    @Select("UPDATE user " +
            "SET user_power=#{userPower} " +
            "WHERE user_id=#{userId}")
    public void updateUserPower(User user);

    @Select("SELECT * FROM user WHERE user_id=#{userId}")
    public User findUserByUserId(Integer userId);

    @Select("SELECT * FROM user WHERE user_phone_number=#{uerPhoneNumber}")
    public User findUserByPhoneNumber(String userPhoneNumber);

    @Select("SELECT * FROM user " +
            "WHERE user_student_id=#{userStudentId} AND user_phone_number=#{userPhoneNumber}")
    public User findUserByPhoneAndStudentId(User user);

    @Select("SELECT * FROM user " +
            "WHERE user_student_id=#{userStudentId} AND user_password=#{userPassword}")
    public User findUserByStudentIdAndPassword(User user);
}
