package com.test.answer.utils;

import org.apache.ibatis.session.RowBounds;

/**
 * mybatis 翻页工具
 */
public class RowBoundsUtil {

    private RowBoundsUtil() {
    }

    public static RowBounds of(int offset, int limit) {
        return new RowBounds(offset, limit);
    }
}
