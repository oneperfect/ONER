package com.demon.admin.core.thymeleaf;

import com.demon.admin.core.thymeleaf.attribute.SelectDictAttrProcessor;
import com.demon.admin.core.thymeleaf.attribute.SelectListAttrProcessor;
import com.demon.admin.core.thymeleaf.attribute.UserAttrProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: oneperfect
 * @Date: 2019/4/13
 */
public class OnerDialect extends AbstractProcessorDialect implements IExpressionObjectDialect {

    private static final String NAME = "OnerDialect";
    private static final String PREFIX = "one";
    private IExpressionObjectFactory iExpressionObjectFactory = null;

    protected OnerDialect() {
        super(NAME, PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        if(iExpressionObjectFactory == null){
            this.iExpressionObjectFactory = new OnerExpressionObjectFactory();
        }
        return this.iExpressionObjectFactory;
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        Set<IProcessor> processors = new LinkedHashSet<>();
        processors.add(new UserAttrProcessor(dialectPrefix));
        processors.add(new SelectDictAttrProcessor(TemplateMode.HTML, dialectPrefix));
        processors.add(new SelectListAttrProcessor(TemplateMode.HTML, dialectPrefix));
        return null;
    }
}
