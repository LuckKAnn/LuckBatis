package com.luck.lizzie.batis.mapping;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 11:15
 * @PackageName: com.luck.lizzie.batis.mapping
 * @ClassName: SqlCommandType
 * @Version 1.0
 */
public enum SqlCommandType {
    UNKOWN,
    SELECT,
    UPDATE,
    INSERT,
    DELETE;


    public SqlCommandType getType(String type) {
        return null;
    }
}
