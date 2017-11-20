package com.yangyu.common.page;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang.math.NumberUtils;

import java.io.Serializable;

/** <span style="color:red;">!!!此实体类请只在 controller 中使用!!! 传递给各模块的参数使用 bounds() 方法的返回.</span> */
@Setter
@Getter
@NoArgsConstructor
public class Page implements Serializable {

    /** 分页默认页 */
    public static final int DEFAULT_PAGE_NO = 1;
    /** 分页默认的每页条数 */
    public static final int DEFAULT_LIMIT = 10;
    /** 前台传递过来的分页参数名 */
    public static final String GLOBAL_PAGE = "page";
    /** 前台传递过来的每页条数名 */
    public static final String GLOBAL_LIMIT = "limit";

    private static final int MAX_LIMIT = 1000;

    @ApiParam("当前页数. 不传或传入 0, 或传入负数, 或传入非数字)则默认是 " + DEFAULT_PAGE_NO)
    private int page;
    @ApiParam("每页条数. 不传或传入 0, 或传入负数, 或传入非数字, 或大于 " + MAX_LIMIT + ")则默认是 " + DEFAULT_LIMIT)
    private int limit;

    public Page(String page, String limit) {
        int pageNum = NumberUtils.toInt(page);
        if (pageNum <= 0) {
            pageNum = DEFAULT_PAGE_NO;
        }
        this.page = pageNum;

        int limitNum = NumberUtils.toInt(limit);
        if (limitNum <= 0 || limitNum > MAX_LIMIT) {
            limitNum = DEFAULT_LIMIT;
        }
        this.limit = limitNum;
    }
}
