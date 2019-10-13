package com.kc345ws.commancurd;

import java.sql.ResultSet;

//数据集结果处理类
public interface MyResultHandler<T> {
    T handle(ResultSet rs);
}
