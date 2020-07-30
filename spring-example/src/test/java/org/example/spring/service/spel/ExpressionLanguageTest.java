package org.example.spring.service.spel;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author clx at 2017年5月25日 上午10:40:52
 */
public class ExpressionLanguageTest {

    @Test
    public void helloWorld() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser
                .parseExpression("('hello' + ' world').concat(#end)");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("end", "!");
        Assert.assertEquals("hello world!", expression.getValue(context));
    }

    @Test
    public void testParserContext() {
        ExpressionParser parser = new SpelExpressionParser();
        ParserContext parserContext = new ParserContext() {
            public boolean isTemplate() {
                return true;
            }

            public String getExpressionSuffix() {
                return "}";
            }

            public String getExpressionPrefix() {
                return "#{";
            }
        };
        String template = "#{'Hello World!'}";
        Expression expression = parser.parseExpression(template, parserContext);
        Assert.assertEquals("Hello World!", expression.getValue());
    }

    @Test
    public void testEL() {
        ExpressionParser parser = new SpelExpressionParser();
        boolean val = parser.parseExpression("true").getValue(boolean.class);
        Assert.assertEquals(true, val);
    }
}
