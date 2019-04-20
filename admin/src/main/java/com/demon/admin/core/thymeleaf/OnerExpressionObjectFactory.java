package com.demon.admin.core.thymeleaf;

import com.demon.admin.core.thymeleaf.utility.DictUtil;
import com.demon.admin.core.thymeleaf.utility.LogUtil;
import com.demon.admin.core.thymeleaf.utility.PageUtil;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.*;

/**
 * @Author: oneperfect
 * @Date: 2019/4/13
 */
public class OnerExpressionObjectFactory implements IExpressionObjectFactory {

    private static final String PAGE_UTIL_NAME = "page_util";
    private static final String DICT_UTIL_NAME = "dict_util";
    private static final String LOG_UTIL_NAME = "log_util";
    private static final PageUtil PAGE_UTIL_OBJECT = new PageUtil();
    private static final DictUtil DICT_UTIL_OBJECT = new DictUtil();
    private static final LogUtil LOG_UTIL_OBJECT = new LogUtil();

    @Override
    public Set<String> getAllExpressionObjectNames() {
        Set<String> names = Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(
                PAGE_UTIL_NAME, DICT_UTIL_NAME, LOG_UTIL_NAME
        )));
        return names;
    }

    @Override
    public Object buildObject(IExpressionContext iExpressionContext, String expressionObjectName) {
        if(PAGE_UTIL_NAME.equals(expressionObjectName)) {
            return PAGE_UTIL_OBJECT;
        }
        if(DICT_UTIL_NAME.equals(expressionObjectName)) {
            return DICT_UTIL_OBJECT;
        }
        if(LOG_UTIL_NAME.equals(expressionObjectName)) {
            return LOG_UTIL_OBJECT;
        }

        return null;
    }

    @Override
    public boolean isCacheable(String expressionObjectName) {
        return expressionObjectName != null;
    }
}
