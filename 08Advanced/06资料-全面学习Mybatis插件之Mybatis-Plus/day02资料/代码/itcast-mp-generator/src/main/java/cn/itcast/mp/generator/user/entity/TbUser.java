package cn.itcast.mp.generator.user.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author itcast
* @since 2019-05-09
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 用户名
            */
    private String userName;

            /**
            * 密码
            */
    private String password;

            /**
            * 姓名
            */
    private String name;

            /**
            * 年龄
            */
    private Integer age;

            /**
            * 邮箱
            */
    private String email;

    private Integer version;

            /**
            * 1代表删除，0代表未删除
            */
    private Integer deleted;

            /**
            * 1-男，2-女
            */
    private Integer sex;


}
