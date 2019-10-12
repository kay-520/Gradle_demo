package com.digitalchina.sc.demo.gw.configurer.web;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/**
 * <p>================================================
 * <p>Title: 自定义sitemesh标签
 * <p>Description: Sitemesh 3 默认只提供了 body，title，head 等 tag 类型，
 * 我们可以通过实现 TagRuleBundle 扩展自定义的 tag 规则
 * <p>Date: 2018/2/25 15:47
 * <p>================================================
 *
 * @author Hope Chen
 * @version 1.0
 */
public class ExtHtmlRuleBundle implements TagRuleBundle {

    public static final String PAGE_FOOTER = "pagefooter";

    @Override
    public void install(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
        state.addRule(PAGE_FOOTER,
                new ExportTagToContentRule(siteMeshContext, contentProperty.getChild(PAGE_FOOTER), false));
    }

    @Override
    public void cleanUp(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
        if (!contentProperty.getChild(PAGE_FOOTER).hasValue()) {
            contentProperty.getChild(PAGE_FOOTER).setValue(contentProperty.getValue());
        }
    }
}
