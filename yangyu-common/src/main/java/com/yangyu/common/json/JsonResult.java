package com.yangyu.common.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yangyu.common.exception.NotLoginException;
import com.yangyu.common.util.U;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** <span style="color:red;">!!!此实体类请只在 controller 中使用, 并只调用其 static 方法!!!</span> */
@Setter
@Getter
@NoArgsConstructor
@SuppressWarnings("unchecked")
public class JsonResult<T> {

    /** 返回码 */
    enum Code {
        /** 成功 */
        SUCCESS(0),
        /** 失败 */
        FAIL(1),
        /** 未登录 */
        NO_LOGIN(10);

        int flag;
        Code(int flag) { this.flag = flag; }
    }

    /**
     * <pre>
     * 返回码. 前台根据此值控制页面扭转.
     *
     *   返回 0 时显示 msg 给用户看.
     *   返回 1 时将 data 解析后渲染页面(依业务而定, 也可能显示 msg 给用户看, 如 收货地址添加成功 这种).
     *   返回 10 时导向登录页面引导用户登录.
     * </pre>
     */
//    @ApiModelProperty("0(成功, 操作 data 项或显示 msg 给用户看), 返回码 --> 1(失败, 显示 msg 给用户看), 10(未登录, 将用户导到登录页)")
    private int code = Code.FAIL.flag;

    /** 返回说明. 如: 用户名密码错误, 收货地址添加成功 等 */
//    @ApiModelProperty("返回说明. 如: 用户名密码错误, 收货地址添加成功 等")
    private String msg = U.EMPTY;

    /** 返回的数据. 具体是返回实体 {"id":1} 还是列表 [{"id":1},{"id":2}] 依具体的业务而定 */
//    @ApiModelProperty("返回的数据. 具体是返回实体 {\"id\":1} 还是列表 [{\"id\":1},{\"id\":2}] 依具体的业务而定")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private JsonResult(Code code, String msg) {
        this.code = code.flag;
        this.msg = msg;
    }
    private JsonResult(Code code, String msg, T data) {
        this.code = code.flag;
        this.msg = msg;
        this.data = data;
    }


    // ---------- 在 controller 中请只使用下面的静态方法就好了. 不要 new JsonResult()... 这样操作 ----------

    /** 有 msg 说明的成功. 不返回数据, 当返回 "地址添加成功" 这一类时 */
    public static JsonResult success(String msg) {
        return new JsonResult(Code.SUCCESS, msg);
    }
    /** 成功且有返回数据. 也应该给一个 msg 说明 */
    public static <T> JsonResult<T> success(String msg, T data) {
        return new JsonResult(Code.SUCCESS, msg, data);
    }

    /** 失败时要有 msg 说明. 要对用户友好, 可以直接显示给用户看的 */
    public static JsonResult fail(String msg) {
        return new JsonResult(Code.FAIL, msg);
    }

    /** 未登录时的返回, 全局处理即可 */
    public static JsonResult notLogin() {
        return new JsonResult(Code.NO_LOGIN, NotLoginException.DEFAULT_MSG);
    }
}
