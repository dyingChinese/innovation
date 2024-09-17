package edu.wsyu.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class SQLUtils {

    private final LanguagesUtils languagesUtils;

    public SQLUtils(LanguagesUtils languagesUtils) {
        this.languagesUtils = languagesUtils;
    }

    public QueryWrapper<?> fillFieldByFuzzy(String searchKey, QueryWrapper<?> queryWrapper, Class<?> entityClass, String... fields) {
        if (searchKey == null || searchKey.isEmpty()) {
            return queryWrapper;
        }
        searchKey = searchKey.trim();

        for (String fieldName : fields) {
            try {
                Field field = entityClass.getDeclaredField(fieldName);
                Class<?> fieldType = field.getType();
                if (languagesUtils.isStringType(fieldType)) queryWrapper.or().like(fieldName, searchKey);
                else if (languagesUtils.isNumericType(fieldType)) {
                    applyNumericCondition(queryWrapper, fieldName, searchKey, fieldType);
                }
            } catch (NoSuchFieldException e) {
                // Skip if the field does not exist
            }
        }
        return queryWrapper;
    }

    private QueryWrapper<?> applyNumericCondition(QueryWrapper<?> queryWrapper, String fieldName, String searchKey, Class<?> fieldType) {
        if (NumberUtils.isCreatable(searchKey)) {
            Number number = NumberUtils.createNumber(searchKey);
            if (languagesUtils.isNumericType(fieldType)) queryWrapper.or().eq(fieldName, number.longValue());
            else if (languagesUtils.isIntegerType(fieldType)) queryWrapper.or().eq(fieldName, number.intValue());
            else if (languagesUtils.isDoubleType(fieldType)) queryWrapper.or().eq(fieldName, number.doubleValue());
        }
        return queryWrapper;
    }
}
